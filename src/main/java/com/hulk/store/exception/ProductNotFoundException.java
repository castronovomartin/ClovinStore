package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductNotFoundException.
 */
public class ProductNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param message the message
	 */
	public ProductNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
