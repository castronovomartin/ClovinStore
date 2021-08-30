package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductExistException.
 */
public class ProductExistException extends RuntimeException {

	/**
	 * Instantiates a new product exist exception.
	 *
	 * @param message the message
	 */
	public ProductExistException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new product exist exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ProductExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
