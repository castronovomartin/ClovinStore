package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
