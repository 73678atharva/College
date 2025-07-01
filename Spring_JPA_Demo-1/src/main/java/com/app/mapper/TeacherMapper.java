package com.app.mapper;

import com.app.entity.Teacher;
import com.app.entity.TeacherDTO;

public class TeacherMapper {

	public static TeacherDTO convertTeacherToTeacherDTO(Teacher teacher){
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(teacher.getId());
		teacherDTO.setFirstName(teacher.getFirstName());
		teacherDTO.setLastName(teacher.getLastName());
		
		return teacherDTO;
	}
	
	public static Teacher convertTeacherDTOtoTeacher(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName(teacherDTO.getFirstName());
		teacher.setLastName(teacherDTO.getLastName());
		return teacher;
	}
}
