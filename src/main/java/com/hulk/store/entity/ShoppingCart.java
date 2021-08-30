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
 * The Class ShoppingCart.
 */
@Entity
@Table(name = "shopping_cards")

/**
 * Gets the user.
 *
 * @return the user
 */
@Getter

/**
 * Sets the user.
 *
 * @param user the new user
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new shopping cart.
 *
 * @param idShoppingCart the id shopping cart
 * @param totalPrice the total price
 * @param user the user
 */
@AllArgsConstructor

/**
 * Instantiates a new shopping cart.
 */
@NoArgsConstructor
public class ShoppingCart {

	/** The id shopping cart. */
	@Id
	@Column(name = "id_shopping_cart", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idShoppingCart;
	
	/** The total price. */
	@Column(name = "total_price")
	private double totalPrice;
	
	/** The user. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User user;

}
