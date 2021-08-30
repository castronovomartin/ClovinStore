package com.hulk.store.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Product;
import com.hulk.store.entity.ShoppingCart;
import com.hulk.store.entity.ShoppingCartProduct;
import com.hulk.store.repository.ShoppingCartProductRepository;
import com.hulk.store.service.ShoppingCartProductService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartProductServiceImpl.
 */
@Service("shoppingCartProductServiceImpl")

/** The Constant log. */
@Slf4j
public class ShoppingCartProductServiceImpl extends ExceptionCommonServiceImpl implements ShoppingCartProductService {

	/** The shopping cart product repository. */
	@Autowired
	@Qualifier("shoppingCartProductRepository")
	private ShoppingCartProductRepository shoppingCartProductRepository;

	/**
	 * Creates the shoppin cart product.
	 *
	 * @param product the product
	 * @param shoppingCart the shopping cart
	 */
	@Override
	public void createShoppingCartProduct(Product product, ShoppingCart shoppingCart) {
		log.info("Ejecuta servicio: createShoppinCartProduct");
		shoppingCartProductRepository.save(
				ShoppingCartProduct.builder().product(product).shoppingCart(shoppingCart).productQuantity(1).build());
	}

	/**
	 * Adds the product to shopping cart.
	 *
	 * @param product the product
	 * @param shoppingCart the shopping cart
	 */
	@Override
	public void addProductToShoppingCart(Product product, ShoppingCart shoppingCart) {
		log.info("Ejecuta servicio: addProductToShoppingCart");
		ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.findByProductAndShoppingCart(product,
				shoppingCart);
		if (Objects.isNull(shoppingCartProduct)) {
			createShoppingCartProduct(product, shoppingCart);
		} else {
			shoppingCartProduct.setProductQuantity(shoppingCartProduct.getProductQuantity() + 1);
			shoppingCartProductRepository.save(shoppingCartProduct);
		}
	}

}
