package com.nt.exception;

public class OtpNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OtpNotFoundException(String exception) {
		super(exception);
	}
}
