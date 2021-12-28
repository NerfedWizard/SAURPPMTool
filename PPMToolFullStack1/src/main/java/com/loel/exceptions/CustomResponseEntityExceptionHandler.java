<<<<<<< HEAD
package com.loel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIDException(ProjectIDException ex, WebRequest request) {
		ProjectIDExceptionResponse exceptionResponse = new ProjectIDExceptionResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException ex,
			WebRequest request) {
		ProjectNotFoundExceptionResponse exceptionResponse = new ProjectNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleDuplicateUsernameException(DuplicateUsernameException ex,
			WebRequest request) {
		DuplicateUsernameResponse exceptionResponse = new DuplicateUsernameResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
=======
package com.loel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIDException(ProjectIDException ex, WebRequest request) {
		ProjectIDExceptionResponse exceptionResponse = new ProjectIDExceptionResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException ex,
			WebRequest request) {
		ProjectNotFoundExceptionResponse exceptionResponse = new ProjectNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	public final ResponseEntity<Object> handleDuplicateUsernameException(DuplicateUsernameException ex,
			WebRequest request) {
		DuplicateUsernameResponse exceptionResponse = new DuplicateUsernameResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
>>>>>>> bb5f7472f599139ed6a3b9bc2ea695cff829329c
