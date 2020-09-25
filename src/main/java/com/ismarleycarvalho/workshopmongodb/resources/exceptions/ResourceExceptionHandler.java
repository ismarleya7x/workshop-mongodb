package com.ismarleycarvalho.workshopmongodb.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ismarleycarvalho.workshopmongodb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
		String error = "Resource not found!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(), req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
//	@ExceptionHandler(DatabaseException.class)
//	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest req) {
//		String error = "Database error!";
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}
}
