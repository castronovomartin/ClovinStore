package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the name card.
 *
 * @return the name card
 */
@Getter

/**
 * Sets the name card.
 *
 * @param nameCard the new name card
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new brand card response.
 *
 * @param idBrandCard the id brand card
 * @param nameCard the name card
 */
@AllArgsConstructor

/**
 * Instantiates a new brand card response.
 */
@NoArgsConstructor
public class BrandCardResponse {

	/** The id brand card. */
	private String idBrandCard;
	
	/** The name card. */
	private String nameCard;

}
