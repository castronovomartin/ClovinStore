package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the id brand card.
 *
 * @return the id brand card
 */
@Getter

/**
 * Sets the id brand card.
 *
 * @param idBrandCard the new id brand card
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new credit card request.
 *
 * @param cardNumber the card number
 * @param securityCode the security code
 * @param idUser the id user
 * @param idBrandCard the id brand card
 */
@AllArgsConstructor

/**
 * Instantiates a new credit card request.
 */
@NoArgsConstructor
public class CreditCardRequest {

	/** The card number. */
	private String cardNumber;
	
	/** The security code. */
	private String securityCode;
	
	/** The id user. */
	private String idUser;
	
	/** The id brand card. */
	private String idBrandCard;

}
