<<<<<<< HEAD
package com.loel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException {

	public ProjectIDException(String message) {
		super(message);
	}
}
=======
package com.loel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException {

	public ProjectIDException(String message) {
		super(message);
	}
}
>>>>>>> bb5f7472f599139ed6a3b9bc2ea695cff829329c
