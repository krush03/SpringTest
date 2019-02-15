package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OtpExceptionController {
	@ExceptionHandler(value=OtpNotFoundException.class)
	public ResponseEntity<Object> exception(OtpNotFoundException exception) {
		return new ResponseEntity<Object>("Otp not found",HttpStatus.NOT_FOUND);
	}
}
