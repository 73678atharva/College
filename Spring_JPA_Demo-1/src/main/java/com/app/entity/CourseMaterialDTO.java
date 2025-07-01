package com.app.entity;

public class CourseMaterialDTO {
	
	private long id;
	
	private String courseMaterialName;
	
	private String url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
}
