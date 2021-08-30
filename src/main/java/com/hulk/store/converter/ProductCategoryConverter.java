package com.hulk.store.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hulk.store.entity.ProductCategory;
import com.hulk.store.model.ProductCategoryResponse;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCategoryConverter.
 */
@Component("productCategoryConverter")

/** The Constant log. */
@Slf4j
public class ProductCategoryConverter {

	/**
	 * Convert product category to product category response.
	 *
	 * @param productCategory the product category
	 * @return the product category response
	 */
	public ProductCategoryResponse convertProductCategoryToProductCategoryResponse(ProductCategory productCategory) {
		log.info("Procede a convertir ProductCategory a ProductCategoryResponse");
		return ProductCategoryResponse.builder().idProductCategory(productCategory.getIdProductCategory())
				.nameCategory(productCategory.getNameCategory()).build();
	}

	/**
	 * Convert list product category to list product category response.
	 *
	 * @param listProductCategory the list product category
	 * @return the list
	 */
	public List<ProductCategoryResponse> convertListProductCategoryToListProductCategoryResponse(
			List<ProductCategory> listProductCategory) {
		log.info("Procede a convertir List<ProductCategory> a List<ProductCategoryResponse>");
		List<ProductCategoryResponse> listProductCategoryResponse = new ArrayList<>();
		for (ProductCategory productCategory : listProductCategory) {
			listProductCategoryResponse.add(convertProductCategoryToProductCategoryResponse(productCategory));
		}
		return listProductCategoryResponse;
	}

}
