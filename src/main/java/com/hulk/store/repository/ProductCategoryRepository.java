package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.ProductCategory;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductCategoryRepository.
 */
@Repository("productCategoryRepository")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Serializable> {

	/**
	 * Find by name category.
	 *
	 * @param nameCategory the name category
	 * @return the product category
	 */
	public abstract ProductCategory findByNameCategory(String nameCategory);

}
