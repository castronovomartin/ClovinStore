package com.hulk.store.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the list products.
 *
 * @return the list products
 */
@Getter

/**
 * Sets the list products.
 *
 * @param listProducts the new list products
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new inventory response.
 *
 * @param idInventary the id inventary
 * @param descriptionInventory the description inventory
 * @param listProducts the list products
 */
@AllArgsConstructor

/**
 * Instantiates a new inventory response.
 */
@NoArgsConstructor
public class InventoryResponse {

	/** The id inventary. */
	private String idInventary;
	
	/** The description inventory. */
	private String descriptionInventory;
	
	/** The list products. */
	@Builder.Default
	private List<ProductResponse> listProducts = new ArrayList<>();

}
