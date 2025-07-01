package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{

	public CourseMaterial findByCourseMaterialName(String name);
}
