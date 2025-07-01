package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Course;
import com.app.entity.CourseDTO;
import com.app.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping(path = "/create/course")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course) {
		CourseDTO newCourse = courseService.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
	}

	@GetMapping(path = "/course/{id}")
	public ResponseEntity<CourseDTO> getSingleCourse(@PathVariable long id) {
		CourseDTO existingCourse = courseService.getCourseById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(existingCourse);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourses(){
		List<CourseDTO> courses = courseService.getAllCourses();
		return ResponseEntity.status(HttpStatus.FOUND).body(courses);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
		return ResponseEntity.status(HttpStatus.OK).body("Course With id: "+ id +" deleted Successfull!!!");
	}
}
