package com.hulk.store.service;

import com.hulk.store.entity.Product;
import com.hulk.store.entity.ShoppingCart;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShoppingCartProductService.
 */
public interface ShoppingCartProductService {

	/**
	 * Creates the shoppin cart product.
	 *
	 * @param product the product
	 * @param shoppingCart the shopping cart
	 */
	public abstract void createShoppingCartProduct(Product product, ShoppingCart shoppingCart);

	/**
	 * Adds the product to shopping cart.
	 *
	 * @param product the product
	 * @param shoppingCart the shopping cart
	 */
	public abstract void addProductToShoppingCart(Product product, ShoppingCart shoppingCart);

}
