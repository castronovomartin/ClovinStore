package com.hulk.store.service;

import com.hulk.store.model.ShoppingCartRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShoppingCartService.
 */
public interface ShoppingCartService {

	/**
	 * Adds the product shopping cart.
	 *
	 * @param shoppingCartRequest the shopping cart request
	 * @return the string
	 */
	public abstract String addProductShoppingCart(ShoppingCartRequest shoppingCartRequest);

	/**
	 * Delete product shopping cart.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @param shoppingCartRequest the shopping cart request
	 * @return the string
	 */
	public abstract String deleteProductShoppingCart(String idShoppingCart, ShoppingCartRequest shoppingCartRequest);

	/**
	 * Make A purchase.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @param idInventory the id inventory
	 * @return the string
	 */
	public abstract String makeAPurchase(String idShoppingCart, String idInventory);

}
