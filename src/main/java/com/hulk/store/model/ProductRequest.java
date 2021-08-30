package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the id inventory.
 *
 * @return the id inventory
 */
@Getter

/**
 * Sets the id inventory.
 *
 * @param idInventory the new id inventory
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product request.
 *
 * @param productName the product name
 * @param productPrice the product price
 * @param idProductCategory the id product category
 * @param idInventory the id inventory
 */
@AllArgsConstructor

/**
 * Instantiates a new product request.
 */
@NoArgsConstructor
public class ProductRequest {

	/** The product name. */
	private String productName;
	
	/** The product price. */
	private double productPrice;
	
	/** The id product category. */
	private String idProductCategory;
	
	/** The id inventory. */
	private String idInventory;

}
