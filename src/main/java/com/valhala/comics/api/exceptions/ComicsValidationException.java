package com.valhala.comics.api.exceptions;

import org.springframework.validation.Errors;

public class ComicsValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Errors errors;

	public ComicsValidationException(Errors errors) {
		super();
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

}
