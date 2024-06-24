package com.lp;

import com.lp.entity.Teacher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class TeacherAwareBeanPostProcessor implements BeanPostProcessor {
	private final ConfigurableApplicationContext applicationContext;

	@Autowired
	public TeacherAwareBeanPostProcessor(ConfigurableApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof TeacherAware teacherAware){
			teacherAware.setTeacher(applicationContext.getBean(Teacher.class));
		}
		return bean;
	}
}
