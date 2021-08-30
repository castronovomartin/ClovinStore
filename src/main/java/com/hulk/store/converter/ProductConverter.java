package com.hulk.store.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductCategory;
import com.hulk.store.entity.ProductInventory;
import com.hulk.store.model.ProductRequest;
import com.hulk.store.model.ProductResponse;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductConverter.
 */
@Component("productConverter")

/** The Constant log. */
@Slf4j
public class ProductConverter {

	/**
	 * Convert product request to product.
	 *
	 * @param productRequest the product request
	 * @param productCategory the product category
	 * @return the product
	 */
	public Product convertProductRequestToProduct(ProductRequest productRequest , ProductCategory productCategory) {
		log.info("Convierte ProductoRequest a Producto");
		return Product.builder()
				.productName(productRequest.getProductName())
				.productPrice(productRequest.getProductPrice())
				.productCategory(productCategory)
				.build();
	}

	/**
	 * Convert product to product response.
	 *
	 * @param product the product
	 * @return the product response
	 */
	public ProductResponse convertProductToProductResponse(Product product) {
		log.info("Convierte Producto a ProductoRequest");
		return ProductResponse.builder()
				.idProduct(product.getIdProduct())
				.productName(product.getProductName())
				.productPrice(product.getProductPrice())
				.productCategoryName(product.getProductCategory().getNameCategory())
				.build();
	}
	
	/**
	 * Convert list product to list product response.
	 *
	 * @param listProducts the list products
	 * @return the list
	 */
	public List<ProductResponse> convertListProductToListProductResponse(List<Product> listProducts) {
		log.info("Convierte ListProducts a ListProductResponse");
		List<ProductResponse> listResponse = new ArrayList<>();
		for(Product product : listProducts) {
			listResponse.add(convertProductToProductResponse(product));
		}
		return listResponse;
	}
	
	/**
	 * Convert list product inventory to list product response.
	 *
	 * @param listProductInventories the list product inventories
	 * @return the list
	 */
	public List<ProductResponse> convertListProductInventoryToListProductResponse(List<ProductInventory> listProductInventories){
		log.info("Convierte ListProductInventories a ListProductResponse");
		List<ProductResponse> listProductResponses = new ArrayList<>();
		for(ProductInventory productInventory : listProductInventories) {
			listProductResponses.add(convertProductToProductResponse(productInventory.getProduct()));
		}
		return listProductResponses;
	}

}
