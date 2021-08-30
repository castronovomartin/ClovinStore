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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.ProductRequest;
import com.hulk.store.model.ProductResponse;
import com.hulk.store.service.ProductService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("/products")

/** The Constant log. */
@Slf4j
public class ProductController {

	/** The product service. */
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	/**
	 * Creates the product.
	 *
	 * @param productRequest the product request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
		log.info("Entra al controller del servicio createProduct");
		ProductResponse productResponse = productService.createProduct(productRequest);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}

	/**
	 * Update product.
	 *
	 * @param idProduct      the id product
	 * @param productRequest the product request
	 * @return the response entity
	 */
	@PutMapping("/{idProduct}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable("idProduct") String idProduct,
			@RequestBody ProductRequest productRequest) {
		log.info("Entra al controller del servicio updateProduct");
		ProductResponse productResponse = productService.updateProduct(idProduct, productRequest);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}

	/**
	 * Delete product.
	 *
	 * @param idProduct the id product
	 * @return the response entity
	 */
	@DeleteMapping("/{idProduct}")
	public ResponseEntity<String> deleteProduct(@PathVariable("idProduct") String idProduct) {
		log.info("Entra al controller del servicio deleteProduct");
		String messageResponse = productService.deleteProduct(idProduct);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

	/**
	 * Gets the product.
	 *
	 * @param idProduct the id product
	 * @return the product
	 */
	@GetMapping("/{idProduct}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("idProduct") String idProduct) {
		log.info("Entra al controller del servicio getProduct");
		ProductResponse productResponse = productService.getProduct(idProduct);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		log.info("Entra al controller del servicio getAllProducts");
		List<ProductResponse> listProductResponse = productService.getAllProducts();
		return new ResponseEntity<List<ProductResponse>>(listProductResponse, HttpStatus.OK);
	}

}
