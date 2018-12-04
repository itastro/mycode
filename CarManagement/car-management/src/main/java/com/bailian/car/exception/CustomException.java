package com.bailian.car.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 6162800786110959296L;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

}
