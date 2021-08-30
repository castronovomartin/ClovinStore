package com.hulk.store.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Product;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.ShoppingCartProduct;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShoppingCartProductRepository.
 */
@Repository("shoppingCartProductRepository")
public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Serializable> {

	/**
	 * Find by product and shopping cart.
	 *
	 * @param product the product
	 * @param shoppingCart the shopping cart
	 * @return the shopping cart product
	 */
	public abstract ShoppingCartProduct findByProductAndShoppingCart(Product product, ShoppingCart shoppingCart);

	/**
	 * Find by shopping cart.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the list
	 */
	public abstract List<ShoppingCartProduct> findByShoppingCart(ShoppingCart shoppingCart);

}
