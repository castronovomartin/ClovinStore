package com.hulk.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.ShoppingCartRequest;
import com.hulk.store.service.ShoppingCartService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartController.
 */
@RestController
@RequestMapping("/carts")

/** The Constant log. */
@Slf4j
public class ShoppingCartController {

	/** The shopping cart service. */
	@Autowired
	@Qualifier("shoppingCartServiceImpl")
	private ShoppingCartService shoppingCartService;

	/**
	 * Adds the product shopping cart.
	 *
	 * @param shoppingCartRequest the shopping cart request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> addProductShoppingCart(@RequestBody ShoppingCartRequest shoppingCartRequest) {
		log.info("Entra al controller del servicio addProductShoppingCart");
		String messageResponse = shoppingCartService.addProductShoppingCart(shoppingCartRequest);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

	/**
	 * Delete shopping cart product.
	 *
	 * @param idShoppingCart      the id shopping cart
	 * @param shoppingCartRequest the shopping cart request
	 * @return the response entity
	 */
	@DeleteMapping("/{idShoppingCart}")
	public ResponseEntity<String> deleteShoppingCartProduct(@PathVariable("idShoppingCart") String idShoppingCart,
			@RequestBody ShoppingCartRequest shoppingCartRequest) {
		log.info("Entra al controller del servicio deleteShoppingCartProduct");
		String messageResponse = shoppingCartService.deleteProductShoppingCart(idShoppingCart, shoppingCartRequest);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

	/**
	 * Make A purchase.
	 *
	 * @param idShoppingCart the id shopping cart
	 * @param idInventory    the id inventory
	 * @return the response entity
	 */
	@PostMapping("/{idShoppingCart}")
	public ResponseEntity<String> makeAPurchase(@PathVariable("idShoppingCart") String idShoppingCart,
			@RequestParam(value = "idInventory", required = true) String idInventory) {
		log.info("Entra al controller del servicio makeAPurchase");
		String messageResponse = shoppingCartService.makeAPurchase(idShoppingCart, idInventory);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

}
