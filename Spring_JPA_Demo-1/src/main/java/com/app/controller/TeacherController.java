package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Teacher;
import com.app.entity.TeacherDTO;
import com.app.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/create/teacher")
	public ResponseEntity<TeacherDTO> createNewTeacher(@RequestBody Teacher teacher){
		TeacherDTO teacherDto = teacherService.createTeacher(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacherDto);
		
	}
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable String id){	
		TeacherDTO teacherDto = teacherService.getSingleTeacher(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(teacherDto);
	}
}
