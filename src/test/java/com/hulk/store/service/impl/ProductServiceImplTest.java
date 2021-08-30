package com.hulk.store.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hulk.store.converter.ProductConverter;
import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductCategory;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.ShoppingCartProduct;
import com.hulk.store.model.ProductRequest;
import com.hulk.store.model.ProductResponse;
import com.hulk.store.repository.InventoryRepository;
import com.hulk.store.repository.ProductCategoryRepository;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.repository.ProductRepository;
import com.hulk.store.repository.ShoppingCartProductRepository;
import com.hulk.store.service.ProductInventoryService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	public static final String REMOVED_PRODUCT = "The product was removed successfully.";

	@InjectMocks
	private ProductServiceImpl service;
	@InjectMocks
	private ExceptionCommonServiceImpl commonService;

	@Mock
	private ProductConverter productConverter;
	@Mock
	private ProductInventoryService productInventoryService;
	@Mock
	private ProductCategoryRepository productCategoryRepository;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private ProductInventoryRepository productInventoryRepository;
	@Mock
	private InventoryRepository inventoryRepository;
	@Mock
	private ShoppingCartProductRepository shoppingCartProductRepository;

	ProductRequest productRequest;
	ProductResponse productResponse;
	Product product;
	Product productNull;
	ProductCategory productCategory;
	Inventory inventory;

	@BeforeEach
	void setup() {
		productRequest = ProductRequest.builder().productName("productName").productPrice(1D).idInventory("1")
				.idProductCategory("Marvel").build();
		product = Mockito.mock(Product.class);
		productNull = null;
		productCategory = Mockito.mock(ProductCategory.class);
		inventory = Mockito.mock(Inventory.class);
		productResponse = Mockito.mock(ProductResponse.class);
	}

	@Test
	void test_createProduct() {
		Mockito.when(productCategoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(productCategory));
		Mockito.when(inventoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(inventory));
		Mockito.when(productConverter.convertProductRequestToProduct(productRequest, productCategory))
				.thenReturn(product);
		Mockito.when(productConverter.convertProductToProductResponse(Mockito.any(Product.class)))
				.thenReturn(productResponse);
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
		ProductResponse productResponse = service.createProduct(productRequest);
		assertNotNull(productResponse);
	}

	@Test
	void test_updateProduct() {
		Mockito.when(productCategoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(productCategory));
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(productConverter.convertProductToProductResponse(Mockito.any(Product.class)))
				.thenReturn(productResponse);
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
		ProductResponse productResponse = service.updateProduct(Mockito.anyString(), productRequest);
		assertNotNull(productResponse);
	}

	@Test
	void test_deleteProduct() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		String message = service.deleteProduct(Mockito.anyString());
		assertEquals(REMOVED_PRODUCT, message);
	}

	@Test
	void test_getProduct() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(productConverter.convertProductToProductResponse(Mockito.any(Product.class)))
				.thenReturn(productResponse);
		ProductResponse productResponse = service.getProduct(Mockito.anyString());
		assertNotNull(productResponse);
	}

	@Test
	void test_getAllProducts() {
		Mockito.when(productRepository.findAll()).thenReturn(getListProduct());
		Mockito.when(productConverter.convertListProductToListProductResponse(getListProduct()))
				.thenReturn(getListProductResponse());
		List<ProductResponse> listProductResponse = service.getAllProducts();
		assertNotNull(listProductResponse.get(0));
	}

	private List<ProductResponse> getListProductResponse() {
		List<ProductResponse> listProductResponse = new ArrayList<>();
		listProductResponse.add(productResponse);
		return listProductResponse;
	}

	private List<Product> getListProduct() {
		List<Product> listProducts = new ArrayList<>();
		listProducts.add(product);
		return listProducts;
	}

}
