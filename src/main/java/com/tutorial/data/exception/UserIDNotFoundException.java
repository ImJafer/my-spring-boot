package com.tutorial.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIDNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3799022592587986201L;

	public UserIDNotFoundException(String exception) {
		super(exception);
	}
}
