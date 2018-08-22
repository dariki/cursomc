package com.netcracker.cursomc.service.exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StandardError {

	private Integer results;
	private Calendar timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private Integer errorCode;
	private String id;
	
	public StandardError() {
		timestamp = Calendar.getInstance();
	}
	
	public static ResponseEntity<StandardError> getInstance(HttpStatus httpStatus) {
		
		StandardError standardError = new StandardError();
		standardError.setError(httpStatus.name());
		standardError.setStatus(httpStatus.value());
		
		switch (httpStatus) {
		case NOT_FOUND:
			standardError.setMessage("register didn't found.");
			break;
		default:
			standardError.setMessage(HttpStatus.BAD_GATEWAY.getReasonPhrase());
			break;
		}
		ResponseEntity<StandardError> responseReturn = new ResponseEntity<StandardError>(standardError, httpStatus);
		return responseReturn;
	}
	
	public Integer getResults() {
		return results;
	}
	public void setResults(Integer results) {
		this.results = results;
	}
	public Calendar getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
