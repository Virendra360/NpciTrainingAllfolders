package com.npci.exception;

public class UserNotFoundException extends Exception {
	// always recommended that we must create constructor matching one of the 
		// constructor of Exception class

	public UserNotFoundException() {
		super();
		
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserNotFoundException(String message) {
		super(message);
			}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		
	}
}
