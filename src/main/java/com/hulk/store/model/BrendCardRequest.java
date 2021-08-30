package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the brand card name.
 *
 * @return the brand card name
 */
@Getter

/**
 * Sets the brand card name.
 *
 * @param brandCardName the new brand card name
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new brend card request.
 *
 * @param brandCardName the brand card name
 */
@AllArgsConstructor

/**
 * Instantiates a new brend card request.
 */
@NoArgsConstructor
public class BrendCardRequest {

	/** The brand card name. */
	private String brandCardName;

}
