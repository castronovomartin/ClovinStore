package com.hulk.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.ProductCategoryResponse;
import com.hulk.store.service.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCategoryController.
 */
@RestController
@RequestMapping("/categories")

/** The Constant log. */
@Slf4j
public class ProductCategoryController {

	/** The product category service. */
	@Autowired
	@Qualifier("productCategoryServiceImpl")
	private ProductCategoryService productCategoryService;

	/**
	 * Creates the category.
	 *
	 * @param categoryName the category name
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<ProductCategoryResponse> createCategory(
			@RequestParam(value = "categoryName", required = true) String categoryName) {
		log.info("Entra al controller del servicio createCategory");
		ProductCategoryResponse productCategoryResponse = productCategoryService.createCategory(categoryName);
		return new ResponseEntity<ProductCategoryResponse>(productCategoryResponse, HttpStatus.OK);
	}

	/**
	 * Update category.
	 *
	 * @param idProductCategory the id product category
	 * @param categoryName      the category name
	 * @return the response entity
	 */
	@PutMapping("/{idProductCategory}")
	public ResponseEntity<ProductCategoryResponse> updateCategory(
			@PathVariable("idProductCategory") String idProductCategory,
			@RequestParam(value = "categoryName", required = true) String categoryName) {
		log.info("Entra al controller del servicio updateCategory");
		ProductCategoryResponse productCategoryResponse = productCategoryService.updateCategory(idProductCategory,
				categoryName);
		return new ResponseEntity<ProductCategoryResponse>(productCategoryResponse, HttpStatus.OK);
	}

	/**
	 * Delete category.
	 *
	 * @param idProductCategory the id product category
	 * @return the response entity
	 */
	@DeleteMapping("/{idProductCategory}")
	public ResponseEntity<String> deleteCategory(@PathVariable("idProductCategory") String idProductCategory) {
		log.info("Entra al controller del servicio deleteCategory");
		String messageResponse = productCategoryService.deleteCategory(idProductCategory);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

	/**
	 * Gets the category by id.
	 *
	 * @param idProductCategory the id product category
	 * @return the category by id
	 */
	@GetMapping("/{idProductCategory}")
	public ResponseEntity<ProductCategoryResponse> getCategoryById(
			@PathVariable("idProductCategory") String idProductCategory) {
		log.info("Entra al controller del servicio getCategoryById");
		ProductCategoryResponse productCategoryResponse = productCategoryService.getCategory(idProductCategory);
		return new ResponseEntity<ProductCategoryResponse>(productCategoryResponse, HttpStatus.OK);
	}

	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	@GetMapping
	public ResponseEntity<List<ProductCategoryResponse>> getAllCategories() {
		log.info("Entra al controller del servicio getAllCategories");
		List<ProductCategoryResponse> listProductCategories = productCategoryService.getAllCategory();
		return new ResponseEntity<List<ProductCategoryResponse>>(listProductCategories, HttpStatus.OK);
	}

}
