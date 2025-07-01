package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.StudentDTO;
import com.app.service.StudentServiceImp;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImp serviceImp;
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable long id){
		StudentDTO existingStudent = serviceImp.findById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(existingStudent);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDTO student) {
		StudentDTO savedStudent = serviceImp.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
}
