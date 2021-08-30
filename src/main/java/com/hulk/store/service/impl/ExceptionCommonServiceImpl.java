package com.hulk.store.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.TestCrypt;
import com.hulk.store.entity.BrandCard;
import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductCategory;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.User;
import com.hulk.store.exception.BrandCardExistException;
import com.hulk.store.exception.CreditCardExistException;
import com.hulk.store.exception.CreditCardNotFoundException;
import com.hulk.store.exception.InventoryNotFoundException;
import com.hulk.store.exception.NoStockException;
import com.hulk.store.exception.ProductCategoryExistException;
import com.hulk.store.exception.ProductCategoryNotFoundException;
import com.hulk.store.exception.ProductExistException;
import com.hulk.store.exception.ProductNotFoundException;
import com.hulk.store.exception.ShoppingCartNotFoundException;
import com.hulk.store.exception.UserExistException;
import com.hulk.store.exception.UserNotFoundException;
import com.hulk.store.repository.BrandCardRepository;
import com.hulk.store.repository.CreditCardRepository;
import com.hulk.store.repository.InventoryRepository;
import com.hulk.store.repository.ProductCategoryRepository;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.repository.ProductRepository;
import com.hulk.store.repository.ShoppingCartProductRepository;
import com.hulk.store.repository.ShoppingCartRepository;
import com.hulk.store.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionCommonServiceImpl.
 */
@Service("exceptionCommonServiceImpl")
public class ExceptionCommonServiceImpl {

	/** The test crypt. */
	@Autowired
	@Qualifier("testCrypt")
	private TestCrypt testCrypt;

	/** The product repository. */
	@Autowired
	@Qualifier("productRepository")
	public ProductRepository productRepository;

	/** The product category repository. */
	@Autowired
	@Qualifier("productCategoryRepository")
	public ProductCategoryRepository productCategoryRepository;

	/** The inventory repository. */
	@Autowired
	@Qualifier("inventoryRepository")
	public InventoryRepository inventoryRepository;

	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;

	/** The brand card repository. */
	@Autowired
	@Qualifier("brandCardRepository")
	public BrandCardRepository brandCardRepository;

	/** The credit card repository. */
	@Autowired
	@Qualifier("creditCardRepository")
	public CreditCardRepository creditCardRepository;

	/** The product inventory repository. */
	@Autowired
	@Qualifier("productInventoryRepository")
	public ProductInventoryRepository productInventoryRepository;

	/** The shopping cart product repository. */
	@Autowired
	@Qualifier("shoppingCartProductRepository")
	public ShoppingCartProductRepository shoppingCartProductRepository;

	/** The shopping cart repository. */
	@Autowired
	@Qualifier("shoppingCartRepository")
	public ShoppingCartRepository shoppingCartRepository;

	/**
	 * Gets the product category by id product category.
	 *
	 * @param idProductCategory the id product category
	 * @return the product category by id product category
	 */
	public ProductCategory getProductCategoryByIdProductCategory(String idProductCategory) {
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(idProductCategory);
		if (!productCategory.isPresent()) {
			throw new ProductCategoryNotFoundException("The indicated category does not exist.",
					new Exception("Error ProductCategoryNotFoundException"));
		} else {
			return productCategory.get();
		}
	}

	/**
	 * Check product category exist by name.
	 *
	 * @param productCategoryName the product category name
	 */
	public void checkProductCategoryExistByName(String productCategoryName) {
		if (!Objects.isNull(productCategoryRepository.findByNameCategory(productCategoryName))) {
			throw new ProductCategoryExistException("The category you want to create already exists.",
					new Exception("Error ProductCategoryExistException"));
		}
	}

	/**
	 * Check product exist by name.
	 *
	 * @param productName the product name
	 */
	public void checkProductExistByName(String productName) {
		if (!Objects.isNull(productRepository.findProductByProductName(productName))) {
			throw new ProductExistException("The product you want to create already exists.",
					new Exception("Error ProductExistException"));
		}
	}

	/**
	 * Gets the product by id product.
	 *
	 * @param idProduct the id product
	 * @return the product by id product
	 */
	public Product getProductByIdProduct(String idProduct) {
		Optional<Product> product = productRepository.findById(idProduct);
		if (!product.isPresent()) {
			throw new ProductNotFoundException("The indicated product doesn't exist.",
					new Exception("Error ProductNotFoundException"));
		} else {
			return product.get();
		}
	}

	/**
	 * Gets the shopping cart by id shopping cart.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @return the shopping cart by id shopping cart
	 */
	public ShoppingCart getShoppingCartByIdShoppingCart(String idShoppingCart) {
		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(idShoppingCart);
		if (!shoppingCart.isPresent()) {
			throw new ShoppingCartNotFoundException("The indicated shopping cart does not exist.",
					new Exception("Error ShoppingCartNotFoundException"));
		} else {
			return shoppingCart.get();
		}
	}

	/**
	 * Gets the inventory by id inventory.
	 *
	 * @param idInventory the id inventory
	 * @return the inventory by id inventory
	 */
	public Inventory getInventoryByIdInventory(String idInventory) {
		Optional<Inventory> inventory = inventoryRepository.findById(idInventory);
		if (!inventory.isPresent()) {
			throw new InventoryNotFoundException("The indicated inventory does not exist.",
					new Exception("Error InventoryNotFoundException"));
		} else {
			return inventory.get();
		}
	}

	/**
	 * Check user exist by username.
	 *
	 * @param username the username
	 */
	public void checkUserExistByUsername(String username) {
		if (!Objects.isNull(userRepository.findByUsername(username))) {
			throw new UserExistException("The username entered already exists.",
					new Exception("Error UserExistException"));
		}
	}

	/**
	 * Check brand card exist by name.
	 *
	 * @param brandCardName the brand card name
	 */
	public void checkBrandCardExistByName(String brandCardName) {
		if (!Objects.isNull(brandCardRepository.findByNameCard(brandCardName))) {
			throw new BrandCardExistException("The credit card brand you want to create already exists.",
					new Exception("Error BrandCardExistException"));
		}
	}

	/**
	 * Gets the brand card by id.
	 *
	 * @param IdBrandCard the id brand card
	 * @return the brand card by id
	 */
	public BrandCard getBrandCardById(String IdBrandCard) {
		Optional<BrandCard> brandCard = brandCardRepository.findById(IdBrandCard);
		if (!brandCard.isPresent()) {
			throw new BrandCardExistException("The indicated credit card brand does not exist.",
					new Exception("Error BrandCardExistException"));
		} else {
			return brandCard.get();
		}
	}

	/**
	 * Check user exist by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void checkUserExistByUsernameAndPassword(String username, String password) {
		if (Objects.isNull(
				userRepository.findByUsernameAndPassword(testCrypt.encrypt(username), testCrypt.encrypt(password)))) {
			throw new UserNotFoundException("The username or password entered with incorrect.",
					new Exception("Error UserNotFoundException"));
		}
	}

	/**
	 * Gets the user by id user.
	 *
	 * @param idUser the id user
	 * @return the user by id user
	 */
	public User getUserByIdUser(String idUser) {
		Optional<User> user = userRepository.findById(idUser);
		if (!user.isPresent()) {
			throw new UserNotFoundException("The indicated user does not exist.",
					new Exception("Error UserNotFoundException"));
		} else {
			return user.get();
		}
	}

	/**
	 * Check credit card exist by card number.
	 *
	 * @param cardNumber the card number
	 */
	public void checkCreditCardExistByCardNumber(String cardNumber) {
		if (!Objects.isNull(creditCardRepository.findByCardNumber(testCrypt.encrypt(cardNumber)))) {
			throw new CreditCardExistException("The credit card you want to create already exists.",
					new Exception("Error CreditCardExistException"));
		}
	}

	/**
	 * Check if there is stock by id product.
	 *
	 * @param product   the product
	 * @param inventory the inventory
	 * @param quantity  the quantity
	 */
	public void checkIfThereIsStockByIdProduct(Product product, Inventory inventory, int quantity) {
		if (productInventoryRepository.findProductInventoryByProductAndInventory(product, inventory)
				.getStockProduct() < quantity) {
			throw new NoStockException("There is no stock of the selected product: " + product.getProductName(),
					new Exception("Error NoStockException"));
		}
	}

	/**
	 * Check if the user has an associated card.
	 *
	 * @param user the user
	 */
	public void checkIfTheUserHasAnAssociatedCard(User user) {
		if (Objects.isNull(creditCardRepository.findByUser(user))) {
			throw new CreditCardNotFoundException("The user does not have an associated credit card.",
					new Exception("Error CreditCardNotFoundException"));
		}
	}

}
