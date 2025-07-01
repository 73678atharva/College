package com.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.app.entity.Course;
import com.app.entity.CourseDTO;
import com.app.entity.Student;
import com.app.entity.StudentDTO;

public class StudentMapper {

	public static StudentDTO mapToStudentDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setFirstName(student.getFirstName());
		dto.setLastName(student.getLastName());
		
        if (student.getCourses() != null) {
            List<CourseDTO> courses = student.getCourses().stream()
                    .map(StudentMapper::toCourseDTO)
                    .collect(Collectors.toList());
            dto.setCourses(courses);
        }
        return dto;
	}
	
    public static Course toCourseEntity(CourseDTO dto) {
        if (dto == null) return null;

        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setCredit(dto.getCredit());
        return course;
    }
    
	public static Student mapStudentDtoToStudent(StudentDTO studentDto) {
		if(studentDto == null)
			return null;
		Student student = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		if(studentDto.getCourses() != null) {
			List<Course> course = studentDto.getCourses().stream().map(StudentMapper :: toCourseEntity).collect(Collectors.toList());
			student.setCourses(course);
		}
		return student;
	}
    public static CourseDTO toCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseName(course.getCourseName());
        dto.setCredit(course.getCredit());
        return dto;
    }
    
}
