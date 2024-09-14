package com.eventmanagement.Exceptions;

public class BadCredentialsException extends RuntimeException {

	public BadCredentialsException() {
		super("Invalid Credentials");
	}
	
	public BadCredentialsException(String message) {
		super(message);
	} 

}
