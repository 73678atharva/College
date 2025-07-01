package com.app.mapper;

import com.app.entity.CourseMaterial;
import com.app.entity.CourseMaterialDTO;

public class CourseMaterialMapper {

	public static CourseMaterialDTO convertCourseMaterialToCourseMaterialDTO(CourseMaterial courseMaterial) {
		CourseMaterialDTO courseMaterialDTO = new CourseMaterialDTO();
		courseMaterialDTO.setId(courseMaterial.getId());
		courseMaterialDTO.setCourseMaterialName(courseMaterial.getCourseMaterialName());
		courseMaterialDTO.setUrl(courseMaterial.getUrl());
		return courseMaterialDTO;
	}
	
	public static CourseMaterial convertCourseMaterialDtoToCourseMaterial(CourseMaterialDTO courseMaterialDTO) {
		CourseMaterial courseMaterial = new CourseMaterial();
		courseMaterial.setCourseMaterialName(courseMaterialDTO.getCourseMaterialName());
		courseMaterial.setUrl(courseMaterialDTO.getUrl());
		return courseMaterial;
	}
}
