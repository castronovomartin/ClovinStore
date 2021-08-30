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
 * The Class CreditCard.
 */
@Entity
@Table(name = "credit_cards")

/**
 * Gets the brand card.
 *
 * @return the brand card
 */
@Getter

/**
 * Sets the brand card.
 *
 * @param brandCard the new brand card
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new credit card.
 *
 * @param idCreditCard the id credit card
 * @param cardNumber the card number
 * @param securityCode the security code
 * @param user the user
 * @param brandCard the brand card
 */
@AllArgsConstructor

/**
 * Instantiates a new credit card.
 */
@NoArgsConstructor
public class CreditCard {

	/** The id credit card. */
	@Id
	@Column(name = "id_credit_card", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idCreditCard;
	
	/** The card number. */
	@Column(name = "card_number")
	private String cardNumber;
	
	/** The security code. */
	@Column(name = "security_code")
	private String securityCode;
	
	/** The user. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User user;
	
	/** The brand card. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_brand_card")
	private BrandCard brandCard;

}
