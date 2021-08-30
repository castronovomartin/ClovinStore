package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserExistException.
 */
public class UserExistException extends RuntimeException {

	/**
	 * Instantiates a new user exist exception.
	 *
	 * @param message the message
	 */
	public UserExistException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new user exist exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
