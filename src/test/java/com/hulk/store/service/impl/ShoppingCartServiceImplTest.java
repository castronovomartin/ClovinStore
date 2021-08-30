package com.hulk.store.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.hulk.store.entity.CreditCard;
import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.ShoppingCartProduct;
import com.hulk.store.entity.User;
import com.hulk.store.model.ShoppingCartRequest;
import com.hulk.store.repository.CreditCardRepository;
import com.hulk.store.repository.InventoryRepository;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.repository.ProductRepository;
import com.hulk.store.repository.ShoppingCartProductRepository;
import com.hulk.store.repository.ShoppingCartRepository;
import com.hulk.store.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceImplTest {

	public static final String ADDED_PRODUCT = "The product has been successfully added to the shopping cart.";
	public static final String REMOVED_PRODUCT = "The product has been successfully removed from the shopping cart.";
	public static final String SUCCESSFUL_PURCHASE = "The purchase was successful.";

	@InjectMocks
	private ShoppingCartServiceImpl service;
	@InjectMocks
	private ExceptionCommonServiceImpl commonService;

	@Mock
	private ShoppingCartProductServiceImpl cartProductService;

	@Mock
	private ProductRepository productRepository;
	@Mock
	private InventoryRepository inventoryRepository;
	@Mock
	private UserRepository userRepository;
	@Mock
	private ShoppingCartRepository shoppingCartRepository;
	@Mock
	private ProductInventoryRepository productInventoryRepository;
	@Mock
	private ShoppingCartProductRepository shoppingCartProductRepository;
	@Mock
	private CreditCardRepository creditCardRepository;

	ShoppingCartRequest shoppingCartRequest;
	Product product;
	Inventory inventory;
	ProductInventory productInventory;
	ProductInventory productInventoryMinor;
	User user;
	ShoppingCartProduct shoppingCartProduct;
	ShoppingCartProduct shoppingCartProductMinor;
	ShoppingCart shoppingCart;
	CreditCard creditCard;

	@BeforeEach
	void setup() {
		cartProductService = new ShoppingCartProductServiceImpl();
		shoppingCartRequest = ShoppingCartRequest.builder().idInventory("I").idUser("U").idProduct("P").build();
		product = Mockito.mock(Product.class);
		inventory = Mockito.mock(Inventory.class);
		productInventory = ProductInventory.builder().stockProduct(5).build();
		productInventoryMinor = ProductInventory.builder().stockProduct(1).build();
		user = Mockito.mock(User.class);
		shoppingCartProduct = Mockito.mock(ShoppingCartProduct.class);
		shoppingCart = ShoppingCart.builder().user(user).build();
		creditCard = Mockito.mock(CreditCard.class);
		shoppingCartProductMinor = ShoppingCartProduct.builder().product(product).productQuantity(0).build();
	}

	@Test
	void test_addProductShoppingCart() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(inventoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(inventory));
		Mockito.when(productInventoryRepository.findProductInventoryByProductAndInventory(Mockito.any(Product.class),
				Mockito.any(Inventory.class))).thenReturn(productInventory);
		Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(user));
		Mockito.when(productInventoryRepository.findProductInventoryByProductAndInventory(product, inventory))
				.thenReturn(productInventory);
		Mockito.when(shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);
		Mockito.when(shoppingCartRepository.findByUser(Mockito.any(User.class))).thenReturn(shoppingCart);
		String message = service.addProductShoppingCart(shoppingCartRequest);
		assertEquals(ADDED_PRODUCT, message);
	}

	@Test
	void test_addProductShoppingCartNullShoppingCard() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(inventoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(inventory));
		Mockito.when(productInventoryRepository.findProductInventoryByProductAndInventory(Mockito.any(Product.class),
				Mockito.any(Inventory.class))).thenReturn(productInventory);
		Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(user));
		Mockito.when(productInventoryRepository.findProductInventoryByProductAndInventory(product, inventory))
				.thenReturn(productInventory);
		Mockito.when(shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);
		String message = service.addProductShoppingCart(shoppingCartRequest);
		assertEquals(ADDED_PRODUCT, message);
	}

	@Test
	void test_deleteProductShoppingCart() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(shoppingCartRepository.findById(Mockito.anyString())).thenReturn(Optional.of(shoppingCart));
		Mockito.when(shoppingCartProductRepository.findByProductAndShoppingCart(Mockito.any(Product.class),
				Mockito.any(ShoppingCart.class))).thenReturn(shoppingCartProduct);
		String message = service.deleteProductShoppingCart(Mockito.anyString(), shoppingCartRequest);
		assertEquals(REMOVED_PRODUCT, message);
	}

	@Test
	void test_deleteProductShoppingCartMinorQuantity() {
		Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
		Mockito.when(shoppingCartRepository.findById(Mockito.anyString())).thenReturn(Optional.of(shoppingCart));
		Mockito.when(shoppingCartProductRepository.findByProductAndShoppingCart(Mockito.any(Product.class),
				Mockito.any(ShoppingCart.class))).thenReturn(shoppingCartProductMinor);
		String message = service.deleteProductShoppingCart(Mockito.anyString(), shoppingCartRequest);
		assertEquals(REMOVED_PRODUCT, message);
	}

	@Test
	void test_makeAPurchase() {
		Mockito.when(inventoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(inventory));
		Mockito.when(shoppingCartRepository.findById(Mockito.anyString())).thenReturn(Optional.of(shoppingCart));
		Mockito.when(creditCardRepository.findByUser(Mockito.any(User.class))).thenReturn(creditCard);
		String message = service.makeAPurchase("1", "2");
		assertEquals(SUCCESSFUL_PURCHASE, message);
	}

	@Test
	void test_makeAPurchaseListShoppingCard() {
		Mockito.when(inventoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(inventory));
		Mockito.when(shoppingCartRepository.findById(Mockito.anyString())).thenReturn(Optional.of(shoppingCart));
		Mockito.when(creditCardRepository.findByUser(Mockito.any(User.class))).thenReturn(creditCard);
		Mockito.when(shoppingCartProductRepository.findByShoppingCart(Mockito.any(ShoppingCart.class)))
				.thenReturn(getListShoppingCartProduct());
		Mockito.when(productInventoryRepository.findProductInventoryByProductAndInventory(Mockito.any(Product.class),
				Mockito.any(Inventory.class))).thenReturn(productInventoryMinor);
		String message = service.makeAPurchase("1", "2");
		assertEquals(SUCCESSFUL_PURCHASE, message);
	}

	private List<ShoppingCartProduct> getListShoppingCartProduct() {
		List<ShoppingCartProduct> listShoppingCart = new ArrayList<>();
		listShoppingCart.add(shoppingCartProductMinor);
		return listShoppingCart;
	}
}
