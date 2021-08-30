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
 * Instantiates a new inventory request.
 *
 * @param stockProduct the stock product
 * @param idProduct the id product
 * @param idInventory the id inventory
 */
@AllArgsConstructor

/**
 * Instantiates a new inventory request.
 */
@NoArgsConstructor
public class InventoryRequest {

	/** The stock product. */
	private int stockProduct;
	
	/** The id product. */
	private String idProduct;
	
	/** The id inventory. */
	private String idInventory;

}
