package com.app.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.payload.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorMessage> globalException(CustomException exception){	
		ErrorMessage errorMessage = new ErrorMessage(exception.getStatus().value(), exception.getMessage());
		return new ResponseEntity<>(errorMessage, exception.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> allExceptionHandler(Exception exp){
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
