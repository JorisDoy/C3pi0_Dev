package com.indra.iopen.exception;

public class ExpectationFailedException extends Exception {
	private static final long serialVersionUID = 7755089830182900873L;
	private String message;

	public ExpectationFailedException(String message) {
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
