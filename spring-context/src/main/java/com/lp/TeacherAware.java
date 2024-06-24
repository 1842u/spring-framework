package com.lp;

import com.lp.entity.Teacher;
import org.springframework.beans.factory.Aware;

public interface TeacherAware extends Aware {
	void setTeacher(Teacher teacher);
}
