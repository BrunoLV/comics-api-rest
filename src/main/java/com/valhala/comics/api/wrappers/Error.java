package com.valhala.comics.api.wrappers;

import java.io.Serializable;

public class Error implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;
	
	public Error() {
		super();
	}

	public Error(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
