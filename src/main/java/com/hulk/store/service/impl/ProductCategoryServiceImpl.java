package com.hulk.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.ProductCategoryConverter;
import com.hulk.store.entity.ProductCategory;
import com.hulk.store.model.ProductCategoryResponse;
import com.hulk.store.repository.ProductCategoryRepository;
import com.hulk.store.service.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCategoryServiceImpl.
 */
@Service("productCategoryServiceImpl")

/** The Constant log. */
@Slf4j
public class ProductCategoryServiceImpl extends ExceptionCommonServiceImpl implements ProductCategoryService {

	/** The Constant ELIMINATED_CATEGORY. */
	public static final String ELIMINATED_CATEGORY = "The indicated category was successfully removed.";

	/** The product category converter. */
	@Autowired
	@Qualifier("productCategoryConverter")
	private ProductCategoryConverter productCategoryConverter;

	/** The product category repository. */
	@Autowired
	@Qualifier("productCategoryRepository")
	private ProductCategoryRepository productCategoryRepository;

	/**
	 * Creates the category.
	 *
	 * @param nameCategory the name category
	 * @return the product category response
	 */
	@Override
	public ProductCategoryResponse createCategory(String nameCategory) {
		log.info("Ejecuta servicio: createCategory");
		checkProductCategoryExistByName(nameCategory);
		return productCategoryConverter.convertProductCategoryToProductCategoryResponse(
				productCategoryRepository.save(ProductCategory.builder().nameCategory(nameCategory).build()));
	}

	/**
	 * Update category.
	 *
	 * @param idCategory the id category
	 * @param nameCategory the name category
	 * @return the product category response
	 */
	@Override
	public ProductCategoryResponse updateCategory(String idCategory, String nameCategory) {
		log.info("Ejecuta servicio: updateCategory");
		ProductCategory productCategory = getProductCategoryByIdProductCategory(idCategory);
		productCategory.setNameCategory(nameCategory);
		return productCategoryConverter.convertProductCategoryToProductCategoryResponse(productCategory);
	}

	/**
	 * Delete category.
	 *
	 * @param idCategory the id category
	 * @return the string
	 */
	@Override
	public String deleteCategory(String idCategory) {
		log.info("Ejecuta servicio: deleteCategory");
		ProductCategory productCategory = getProductCategoryByIdProductCategory(idCategory);
		productCategoryRepository.delete(productCategory);
		return ELIMINATED_CATEGORY;
	}

	/**
	 * Gets the category.
	 *
	 * @param idCategory the id category
	 * @return the category
	 */
	@Override
	public ProductCategoryResponse getCategory(String idCategory) {
		log.info("Ejecuta servicio: getCategory");
		ProductCategory productCategory = getProductCategoryByIdProductCategory(idCategory);
		return productCategoryConverter.convertProductCategoryToProductCategoryResponse(productCategory);
	}

	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	@Override
	public List<ProductCategoryResponse> getAllCategory() {
		log.info("Ejecuta servicio: getAllCategory");
		return productCategoryConverter
				.convertListProductCategoryToListProductCategoryResponse(productCategoryRepository.findAll());
	}

}
