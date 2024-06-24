package example.lp;

import com.lp.entity.Student;
import com.lp.entity.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		//Teacher teacher = (Teacher)context.getBean("teacher");
		//System.out.println("------------ApplicationContext="+teacher.getApplicationContext());
		//其实就是从一级缓存中获取的
		Student student = (Student)context.getBean("student");
		System.out.println("-----------"+student.getName());
		//System.out.println("------------Teacher="+student.getTeacher());
	}
}
