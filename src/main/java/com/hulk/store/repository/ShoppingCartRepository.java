package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShoppingCartRepository.
 */
@Repository("shoppingCartRepository")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Serializable> {

	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return the shopping cart
	 */
	public abstract ShoppingCart findByUser(User user);

}
