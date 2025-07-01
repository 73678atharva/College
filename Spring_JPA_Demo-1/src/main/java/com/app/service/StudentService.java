package com.app.service;

import com.app.entity.StudentDTO;
public interface StudentService {
	
	public StudentDTO createStudent(StudentDTO student);
	
	public StudentDTO findById(long id);
}
