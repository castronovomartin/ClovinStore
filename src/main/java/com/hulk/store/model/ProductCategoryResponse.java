package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the name category.
 *
 * @return the name category
 */
@Getter

/**
 * Sets the name category.
 *
 * @param nameCategory the new name category
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product category response.
 *
 * @param idProductCategory the id product category
 * @param nameCategory the name category
 */
@AllArgsConstructor

/**
 * Instantiates a new product category response.
 */
@NoArgsConstructor
public class ProductCategoryResponse {

	/** The id product category. */
	private String idProductCategory;
	
	/** The name category. */
	private String nameCategory;

}
