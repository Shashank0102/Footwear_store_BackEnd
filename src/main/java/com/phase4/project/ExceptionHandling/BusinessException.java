package com.phase4.project.ExceptionHandling;

public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5086297150102803610L;

	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
}
