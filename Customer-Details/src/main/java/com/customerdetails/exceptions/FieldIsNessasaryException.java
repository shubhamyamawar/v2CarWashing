package com.customerdetails.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FieldIsNessasaryException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FieldIsNessasaryException(String exception) {
		super(exception);
	}

	
}
