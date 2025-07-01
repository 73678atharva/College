package com.app.service;

import java.util.List;

import com.app.entity.Course;
import com.app.entity.CourseDTO;

public interface CourseService {

	public List<CourseDTO> getAllCourses();

	public CourseDTO getCourseById(long id);
	
	public CourseDTO createCourse(Course course);
	
	public void deleteCourse(String id);
}
