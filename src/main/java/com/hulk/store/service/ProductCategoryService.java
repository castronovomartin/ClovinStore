package com.hulk.store.service;

import java.util.List;

import com.hulk.store.model.ProductCategoryResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductCategoryService.
 */
public interface ProductCategoryService {

	/**
	 * Creates the category.
	 *
	 * @param nameCategory the name category
	 * @return the product category response
	 */
	public abstract ProductCategoryResponse createCategory(String nameCategory);

	/**
	 * Update category.
	 *
	 * @param idCategory the id category
	 * @param nameCategory the name category
	 * @return the product category response
	 */
	public abstract ProductCategoryResponse updateCategory(String idCategory, String nameCategory);

	/**
	 * Delete category.
	 *
	 * @param idCategory the id category
	 * @return the string
	 */
	public abstract String deleteCategory(String idCategory);

	/**
	 * Gets the category.
	 *
	 * @param idCategory the id category
	 * @return the category
	 */
	public abstract ProductCategoryResponse getCategory(String idCategory);

	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	public abstract List<ProductCategoryResponse> getAllCategory();

}
