package com.sopra.MobileStore.Exception;

public class MobileNotFoundException extends RuntimeException {

	public MobileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MobileNotFoundException(String message) {
		super(message);
	}
	
}
