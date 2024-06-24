package com.lp.entity;

import com.lp.TeacherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class Student implements TeacherAware, EnvironmentAware {
	private String name;

	private Teacher teacher;

	private Environment environment;

	public Teacher getTeacher() {
		return teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setTeacher(Teacher teacher) {
		this.teacher =teacher;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
