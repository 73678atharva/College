package com.app.service;

import com.app.entity.CourseMaterial;
import com.app.entity.CourseMaterialDTO;

public interface CourseMaterialService {

	public CourseMaterialDTO createCourseMaterial(CourseMaterial courseMaterial);
	
	public CourseMaterialDTO getCourseById(long id);
}
