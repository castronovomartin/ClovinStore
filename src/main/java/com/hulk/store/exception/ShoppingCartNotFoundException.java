package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartNotFoundException.
 */
public class ShoppingCartNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new shopping cart not found exception.
	 *
	 * @param message the message
	 */
	public ShoppingCartNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new shopping cart not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ShoppingCartNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
