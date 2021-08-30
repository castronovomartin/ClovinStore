package com.hulk.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.ShoppingCartProduct;
import com.hulk.store.entity.User;
import com.hulk.store.model.ShoppingCartRequest;
import com.hulk.store.service.ShoppingCartProductService;
import com.hulk.store.service.ShoppingCartService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartServiceImpl.
 */
@Service("shoppingCartServiceImpl")

/** The Constant log. */
@Slf4j
public class ShoppingCartServiceImpl extends ExceptionCommonServiceImpl implements ShoppingCartService {

	/** The Constant ADDED_PRODUCT. */
	public static final String ADDED_PRODUCT = "The product has been successfully added to the shopping cart.";
	
	/** The Constant REMOVED_PRODUCT. */
	public static final String REMOVED_PRODUCT = "The product has been successfully removed from the shopping cart.";
	
	/** The Constant SUCCESSFUL_PURCHASE. */
	public static final String SUCCESSFUL_PURCHASE = "The purchase was successful.";

	/** The shopping cart product service. */
	@Autowired
	@Qualifier("shoppingCartProductServiceImpl")
	private ShoppingCartProductService shoppingCartProductService;

	/**
	 * Adds the product shopping cart.
	 *
	 * @param shoppingCartRequest the shopping cart request
	 * @return the string
	 */
	@Override
	public String addProductShoppingCart(ShoppingCartRequest shoppingCartRequest) {
		log.info("Ejecuta servicio: addProductShoppingCart");
		Product product = getProductByIdProduct(shoppingCartRequest.getIdProduct());
		Inventory inventory = getInventoryByIdInventory(shoppingCartRequest.getIdInventory());
		User user = getUserByIdUser(shoppingCartRequest.getIdUser());
		checkIfThereIsStockByIdProduct(product, inventory, 1);
		ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);

		if (Objects.isNull(shoppingCart)) {
			shoppingCart = ShoppingCart.builder().user(user).totalPrice(product.getProductPrice()).build();
			shoppingCartRepository.save(shoppingCart);
			shoppingCartProductService.createShoppingCartProduct(product, shoppingCart);
		} else {
			shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + product.getProductPrice());
			shoppingCartRepository.save(shoppingCart);
			shoppingCartProductService.addProductToShoppingCart(product, shoppingCart);
		}
		return ADDED_PRODUCT;
	}

	/**
	 * Delete product shopping cart.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @param shoppingCartRequest the shopping cart request
	 * @return the string
	 */
	@Override
	public String deleteProductShoppingCart(String idShoppingCart, ShoppingCartRequest shoppingCartRequest) {
		log.info("Ejecuta servicio: deleteProductShoppingCart");
		Product product = getProductByIdProduct(shoppingCartRequest.getIdProduct());
		ShoppingCart shoppingCart = getShoppingCartByIdShoppingCart(idShoppingCart);
		ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.findByProductAndShoppingCart(product,
				shoppingCart);
		if (shoppingCartProduct.getProductQuantity() < 1) {
			shoppingCartProductRepository.delete(shoppingCartProduct);

		} else {
			shoppingCartProduct.setProductQuantity(shoppingCartProduct.getProductQuantity() - 1);
			shoppingCartProductRepository.save(shoppingCartProduct);
		}
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - product.getProductPrice());
		shoppingCartRepository.save(shoppingCart);
		return REMOVED_PRODUCT;
	}

	/**
	 * Make A purchase.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @param idInventory the id inventory
	 * @return the string
	 */
	@Override
	public String makeAPurchase(String idShoppingCart, String idInventory) {
		log.info("Ejecuta servicio: makeAPurchase");
		Inventory inventory = getInventoryByIdInventory(idInventory);
		ShoppingCart shoppingCart = getShoppingCartByIdShoppingCart(idShoppingCart);
		checkIfTheUserHasAnAssociatedCard(shoppingCart.getUser());
		List<ShoppingCartProduct> listShoppingCartProducts = new ArrayList<>();
		for (ShoppingCartProduct shoppingCartProduct : shoppingCartProductRepository.findByShoppingCart(shoppingCart)) {
			checkIfThereIsStockByIdProduct(shoppingCartProduct.getProduct(), inventory,
					shoppingCartProduct.getProductQuantity());
			listShoppingCartProducts.add(shoppingCartProduct);

		}
		for (ShoppingCartProduct shoppingCartProduct : listShoppingCartProducts) {
			ProductInventory productInventory = productInventoryRepository
					.findProductInventoryByProductAndInventory(shoppingCartProduct.getProduct(), inventory);
			productInventory
					.setStockProduct(productInventory.getStockProduct() - shoppingCartProduct.getProductQuantity());
			productInventoryRepository.save(productInventory);
			shoppingCartProductRepository.delete(shoppingCartProduct);
		}
		shoppingCartRepository.delete(shoppingCart);
		return SUCCESSFUL_PURCHASE;
	}

}
