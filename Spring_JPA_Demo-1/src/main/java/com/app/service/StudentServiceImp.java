package com.app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.entity.Course;
import com.app.entity.Student;
import com.app.entity.StudentDTO;
import com.app.exception.CustomException;
import com.app.mapper.StudentMapper;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public StudentDTO createStudent(StudentDTO studentDTO) {
	    Student existingStudent = studentRepository.findByFirstName(studentDTO.getFirstName());
	    if (existingStudent != null) {
	        throw new CustomException("Student with name " + studentDTO.getFirstName() + " already exists", HttpStatus.CONFLICT);
	    }

	    Student student = StudentMapper.mapStudentDtoToStudent(studentDTO);

	    List<Course> resolvedCourses = new ArrayList<>();

	    for (Course course : student.getCourses()) {
	        Course existingCourse = courseRepository.findByCourseName(course.getCourseName());

	        if (existingCourse != null) {
	            resolvedCourses.add(existingCourse);
	        }
	    }

	    student.setCourses(resolvedCourses);
	    Student savedStudent = studentRepository.save(student);
	    return StudentMapper.mapToStudentDTO(savedStudent);
	}

	
	@Override
	public StudentDTO findById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty())
			throw new CustomException("Student with Id: "+ id + " not found", HttpStatus.NOT_FOUND);
		return StudentMapper.mapToStudentDTO(student.get());
	}
	
}
