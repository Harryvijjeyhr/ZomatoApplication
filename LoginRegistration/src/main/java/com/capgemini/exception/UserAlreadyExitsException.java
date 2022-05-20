package com.capgemini.exception;

public class UserAlreadyExitsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExitsException() {
		super();
	}
	public UserAlreadyExitsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
