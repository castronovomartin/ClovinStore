package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the product category name.
 *
 * @return the product category name
 */
@Getter

/**
 * Sets the product category name.
 *
 * @param productCategoryName the new product category name
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product response.
 *
 * @param idProduct the id product
 * @param productName the product name
 * @param productPrice the product price
 * @param productCategoryName the product category name
 */
@AllArgsConstructor

/**
 * Instantiates a new product response.
 */
@NoArgsConstructor
public class ProductResponse {

	/** The id product. */
	private String idProduct;
	
	/** The product name. */
	private String productName;
	
	/** The product price. */
	private double productPrice;
	
	/** The product category name. */
	private String productCategoryName;

}
