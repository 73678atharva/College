package com.app.payload;

import java.time.LocalDateTime;

public class ErrorMessage {

	private int status;
	private String message;
	private LocalDateTime timeStamp;
	
	public ErrorMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
	public int getStatus() {
		return status;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
