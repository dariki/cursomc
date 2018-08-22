package com.netcracker.cursomc.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StandardError> objectNotFound(EmptyResultDataAccessException emptyResultException, HttpServletRequest request){
		StandardError standardError = new StandardError();
		standardError.setError(HttpStatus.BAD_REQUEST.name());
		standardError.setStatus(HttpStatus.BAD_REQUEST.value());
		standardError.setMessage(emptyResultException.getMessage());
		standardError.setPath(request.getContextPath());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> objectNotFound(ConstraintViolationException constraintViolationException, HttpServletRequest request){
		StandardError standardError = new StandardError();
		standardError.setError(HttpStatus.BAD_REQUEST.name());
		standardError.setStatus(HttpStatus.BAD_REQUEST.value());
		standardError.setMessage(constraintViolationException.getMessage());
		standardError.setPath(request.getRequestURL().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
}
