package com.revature;

import java.io.Serializable;

public class RvrException extends RuntimeException implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public RvrException() {
	}

	/**

	 *
	 * @param message
	 */
	public RvrException(String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */
	public RvrException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public RvrException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * If a corresponding AMW exception
	 * is not found, the exception is wrapped in an AMWBusinessException.
	 *
	 * @param msg - the message string
	 * @param e - the root cause
	 */
	public static void throwRvrException(String msg, Exception e) {

		if (e instanceof RvrException) {
			throw (RvrException) e;
		}
		throw new RvrException(msg,e);
	}
}
