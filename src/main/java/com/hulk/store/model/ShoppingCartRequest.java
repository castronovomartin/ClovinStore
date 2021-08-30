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
 * Instantiates a new shopping cart request.
 *
 * @param idUser the id user
 * @param idProduct the id product
 * @param idInventory the id inventory
 */
@AllArgsConstructor

/**
 * Instantiates a new shopping cart request.
 */
@NoArgsConstructor
public class ShoppingCartRequest {

	/** The id user. */
	private String idUser;
	
	/** The id product. */
	private String idProduct;
	
	/** The id inventory. */
	private String idInventory;

}
