package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.entity.CourseMaterial;
import com.app.entity.CourseMaterialDTO;
import com.app.exception.CustomException;
import com.app.mapper.CourseMaterialMapper;
import com.app.repository.CourseMaterialRepository;

@Service
public class CourseMaterialImp implements CourseMaterialService{

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	

	@Override
	public CourseMaterialDTO createCourseMaterial(CourseMaterial courseMaterial) {
		if(courseMaterialRepository.findByCourseMaterialName(courseMaterial.getCourseMaterialName()) != null)
			throw new CustomException("Course Material ALready Exisit!!", HttpStatus.CONFLICT);
		return CourseMaterialMapper.convertCourseMaterialToCourseMaterialDTO(courseMaterialRepository.save(courseMaterial));
		}


	@Override
	public CourseMaterialDTO getCourseById(long id) {
		Optional<CourseMaterial> existingCourseMaterial = courseMaterialRepository.findById(id);
		if(existingCourseMaterial.isEmpty())
			throw new CustomException("Course Material with id: "+ id + " not Found!!!", HttpStatus.NOT_FOUND);
		return CourseMaterialMapper.convertCourseMaterialToCourseMaterialDTO(existingCourseMaterial.get());
	}
	
	
}
