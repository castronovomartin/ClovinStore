package com.hulk.store.exception.api;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the errors.
 *
 * @return the errors
 */
@Getter

/**
 * Sets the errors.
 *
 * @param errors the new errors
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class ErrorResponse {

	/** The status. */
	private HttpStatus status;
	
	/** The message. */
	private String message;
	
	/** The errors. */
	private List<String> errors;

}
