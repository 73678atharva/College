package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.entity.Course;
import com.app.entity.CourseDTO;
import com.app.entity.CourseMaterial;
import com.app.entity.Teacher;
import com.app.exception.CustomException;
import com.app.mapper.StudentMapper;
import com.app.repository.CourseMaterialRepository;
import com.app.repository.CourseRepository;
import com.app.repository.TeacherRepository;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<CourseDTO> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		if (courses == null)
			throw new CustomException("All Courses not found", HttpStatus.NOT_FOUND);
		List<CourseDTO> allCourses = new ArrayList<>();
		for(Course course : courses) {
			allCourses.add(StudentMapper.toCourseDTO(course));
		}
		return allCourses;
	}

	@Override
	public CourseDTO getCourseById(long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isEmpty())
			throw new CustomException("Course with id: " + id + " not found!!", HttpStatus.NOT_FOUND);
		return StudentMapper.toCourseDTO(course.get());
	}

	@Override
	public CourseDTO createCourse(Course course) {
		if (course == null) {
			throw new CustomException("Please Enter Course Details!!", HttpStatus.NOT_ACCEPTABLE);
		}
		Course existingCourse = courseRepository.findByCourseName(course.getCourseName());
		if (existingCourse != null)
			throw new CustomException("Course Already Exist!!", HttpStatus.CONFLICT);

		String existingCourseMaterialName = course.getCourseMaterial().getCourseMaterialName();
		CourseMaterial existingCourseMaterial = courseMaterialRepository.findByCourseMaterialName(existingCourseMaterialName);
		if(existingCourseMaterial != null)
			course.setCourseMaterial(existingCourseMaterial);
		
		Teacher exisitngTeacher = course.getTeacher() ;
		return StudentMapper.toCourseDTO(courseRepository.save(course));
	}

	@Override
	public void deleteCourse(String id) {
		Optional<Course> course = courseRepository.findById(Long.parseLong(id));
		if (course.isEmpty())
			throw new CustomException("Course With id: " + id + " not found!!!", HttpStatus.NOT_FOUND);
		courseRepository.deleteById(Long.parseLong(id));
	}
}
