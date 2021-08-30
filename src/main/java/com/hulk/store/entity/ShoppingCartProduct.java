package com.hulk.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartProduct.
 */
@Entity
@Table(name = "shopping_cart_products")

/**
 * Gets the product quantity.
 *
 * @return the product quantity
 */
@Getter

/**
 * Sets the product quantity.
 *
 * @param productQuantity the new product quantity
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new shopping cart product.
 *
 * @param idShoppingCartProduct the id shopping cart product
 * @param product the product
 * @param shoppingCart the shopping cart
 * @param productQuantity the product quantity
 */
@AllArgsConstructor

/**
 * Instantiates a new shopping cart product.
 */
@NoArgsConstructor
public class ShoppingCartProduct {

	/** The id shopping cart product. */
	@Id
	@Column(name = "id_shopping_cart_product", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idShoppingCartProduct;
	
	/** The product. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_product")
	private Product product;
	
	/** The shopping cart. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_shopping_cart")
	private ShoppingCart shoppingCart;
	
	/** The product quantity. */
	@Column(name = "product_quantity")
	private int productQuantity;

}
