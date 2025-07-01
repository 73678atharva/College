package com.app.service;

import com.app.entity.Teacher;
import com.app.entity.TeacherDTO;

public interface TeacherService {

	public TeacherDTO createTeacher(Teacher teacher);
	
	public TeacherDTO getSingleTeacher(String id);
}
