package com.orctom.sample.springmvc.exception;

/**
 * @author Hao-Chen2
 */
public class LogicException extends RuntimeException {

	private static final long serialVersionUID = -2604788096097873361L;

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return null;
	}

}
