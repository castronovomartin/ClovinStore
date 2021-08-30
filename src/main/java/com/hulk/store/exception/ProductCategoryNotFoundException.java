package com.hulk.store.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCategoryNotFoundException.
 */
public class ProductCategoryNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new product category not found exception.
	 *
	 * @param message the message
	 */
	public ProductCategoryNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new product category not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ProductCategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
