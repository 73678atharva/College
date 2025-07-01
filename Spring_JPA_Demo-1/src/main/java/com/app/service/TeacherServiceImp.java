package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.entity.Teacher;
import com.app.entity.TeacherDTO;
import com.app.exception.CustomException;
import com.app.mapper.TeacherMapper;
import com.app.repository.TeacherRepository;

@Service
public class TeacherServiceImp implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public TeacherDTO createTeacher(Teacher teacher) {
		if(teacher == null)
			throw new CustomException("Teacher Cannot be null, please Enter Data!!!", HttpStatus.NOT_ACCEPTABLE);	
		
		Teacher existingTeacher = teacherRepository.findByFirstName(teacher.getFirstName());
		if(existingTeacher != null)
			throw new CustomException("Teacher ALready Exist!!", HttpStatus.CONFLICT);
		
		return TeacherMapper.convertTeacherToTeacherDTO(teacherRepository.save(teacher));
	}

	@Override
	public TeacherDTO getSingleTeacher(String id) {
		Optional<Teacher> existingTeacher = teacherRepository.findById(Long.parseLong(id));
		if(existingTeacher.isEmpty())
			throw new CustomException("Teacher with id: " + id + " not found!!!", HttpStatus.NOT_FOUND);
		return TeacherMapper.convertTeacherToTeacherDTO(existingTeacher.get());
	}

}
