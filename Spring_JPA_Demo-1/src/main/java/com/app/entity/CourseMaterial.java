package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class CourseMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String courseMaterialName;
	
	private String url;

	@OneToOne(mappedBy = "courseMaterial",fetch = FetchType.LAZY)
	private Course course;
	
	public String getCourseMaterialName() {
		return courseMaterialName;
	}

	public void setCourseMaterialName(String courseMaterialName) {
		this.courseMaterialName = courseMaterialName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
