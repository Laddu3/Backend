package com.mms.project.exceptions;

//NoSuchplanetExistsException class
public class NoSuchMedicineExistsException extends RuntimeException {

	private String message;

	public NoSuchMedicineExistsException(String msg) {
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
