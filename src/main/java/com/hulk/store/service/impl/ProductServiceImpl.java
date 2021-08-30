package com.hulk.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.ProductConverter;
import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductCategory;
import com.hulk.store.model.ProductRequest;
import com.hulk.store.model.ProductResponse;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.service.ProductInventoryService;
import com.hulk.store.service.ProductService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service("productServiceImpl")

/** The Constant log. */
@Slf4j
public class ProductServiceImpl extends ExceptionCommonServiceImpl implements ProductService {

	/** The Constant REMOVED_PRODUCT. */
	public static final String REMOVED_PRODUCT = "The product was removed successfully.";

	/** The product converter. */
	@Autowired
	@Qualifier("productConverter")
	private ProductConverter productConverter;

	/** The product inventory service. */
	@Autowired
	@Qualifier("productInventoryServiceImpl")
	private ProductInventoryService productInventoryService;

	/** The product inventory repository. */
	@Autowired
	@Qualifier("productInventoryRepository")
	private ProductInventoryRepository productInventoryRepository;

	/**
	 * Creates the product.
	 *
	 * @param productRequest the product request
	 * @return the product response
	 */
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		log.info("Ejecuta servicio: createProduct");
		checkProductExistByName(productRequest.getProductName());
		ProductCategory productCategory = getProductCategoryByIdProductCategory(productRequest.getIdProductCategory());
		Inventory inventory = getInventoryByIdInventory(productRequest.getIdInventory());
		Product product = productRepository
				.save(productConverter.convertProductRequestToProduct(productRequest, productCategory));
		productInventoryService.createProductInventory(product, inventory);
		return productConverter.convertProductToProductResponse(product);
	}

	/**
	 * Update product.
	 *
	 * @param idProduct the id product
	 * @param productRequest the product request
	 * @return the product response
	 */
	@Override
	public ProductResponse updateProduct(String idProduct, ProductRequest productRequest) {
		log.info("Ejecuta servicio: updateProduct");
		getProductCategoryByIdProductCategory(productRequest.getIdProductCategory());
		Product product = getProductByIdProduct(idProduct);
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		product.setProductCategory(productCategoryRepository.findById(productRequest.getIdProductCategory()).get());
		return productConverter.convertProductToProductResponse(productRepository.save(product));
	}

	/**
	 * Delete product.
	 *
	 * @param idProduct the id product
	 * @return the string
	 */
	@Override
	public String deleteProduct(String idProduct) {
		log.info("Ejecuta servicio: deleteProduct");
		Product product = getProductByIdProduct(idProduct);
		productInventoryService
				.deleteListProductInventory(productInventoryRepository.findProductInventoryByProduct(product));
		productRepository.delete(productRepository.findById(idProduct).get());
		return REMOVED_PRODUCT;
	}

	/**
	 * Gets the product.
	 *
	 * @param idProduct the id product
	 * @return the product
	 */
	@Override
	public ProductResponse getProduct(String idProduct) {
		log.info("Ejecuta servicio: getProduct");
		Product product = getProductByIdProduct(idProduct);
		return productConverter.convertProductToProductResponse(product);
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public List<ProductResponse> getAllProducts() {
		log.info("Ejecuta servicio: getAllProducts");
		return productConverter.convertListProductToListProductResponse(productRepository.findAll());
	}

}
