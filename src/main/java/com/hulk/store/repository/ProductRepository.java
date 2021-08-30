package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductRepository.
 */
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Serializable> {

	/**
	 * Find product by product name.
	 *
	 * @param productName the product name
	 * @return the product
	 */
	public abstract Product findProductByProductName(String productName);

}
