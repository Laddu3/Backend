package com.mms.project.exceptions;

//NoSuchplanetExistsException class
public class NoSuchBranchAdminExistsException extends RuntimeException {

	private String message;

	public NoSuchBranchAdminExistsException(String msg) {
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
