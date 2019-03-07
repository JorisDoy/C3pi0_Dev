package com.indra.iopen.exception;

public class ObjectNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = null;

	public ObjectNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
