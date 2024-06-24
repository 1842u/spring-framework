package com.lp;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
			for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
				Object value = propertyValue.getValue();
				if (value != null && value instanceof TypedStringValue){


					String input = ((TypedStringValue) value).getValue();
					String regex = "\\^\\{([^}]*)\\}";

					// 编译正则表达式
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(input);

					// 查找匹配项并提取捕获组
					if (matcher.find()) {
						String extracted = matcher.group(1); // 捕获组1的内容
						// 获取 Constants 类的所有字段
						Field[] fields = Constants.class.getDeclaredFields();
						for (Field field : fields) {
							if (field.getName().equals(extracted)){
								Object object = null;
								try {
									object = field.get(null);
								} catch (IllegalAccessException e) {
									throw new RuntimeException(e);
								}
								propertyValues.addPropertyValue(propertyValue.getName(), object);
								break;
							}else {
								propertyValues.addPropertyValue(propertyValue.getName(), "");
							}
						}
					}
				}
			}
		}
	}
}
