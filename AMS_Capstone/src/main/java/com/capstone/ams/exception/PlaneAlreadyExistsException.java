package com.capstone.ams.exception;


//PlaneAlreadyExistsException class
public class PlaneAlreadyExistsException extends RuntimeException {
	
	private String message;

	public PlaneAlreadyExistsException(String msg) {
		super(msg);
		this.setMessage(msg);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
}
