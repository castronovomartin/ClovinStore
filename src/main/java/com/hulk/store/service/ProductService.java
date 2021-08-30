package com.hulk.store.service;

import java.util.List;

import com.hulk.store.model.ProductRequest;
import com.hulk.store.model.ProductResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Creates the product.
	 *
	 * @param productRequest the product request
	 * @return the product response
	 */
	public abstract ProductResponse createProduct(ProductRequest productRequest);

	/**
	 * Update product.
	 *
	 * @param idProduct the id product
	 * @param productRequest the product request
	 * @return the product response
	 */
	public abstract ProductResponse updateProduct(String idProduct, ProductRequest productRequest);

	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the string
	 */
	public abstract String deleteProduct(String id);

	/**
	 * Gets the product.
	 *
	 * @param id the id
	 * @return the product
	 */
	public abstract ProductResponse getProduct(String id);

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	public abstract List<ProductResponse> getAllProducts();

}
