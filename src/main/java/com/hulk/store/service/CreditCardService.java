package com.hulk.store.service;

import com.hulk.store.model.CreditCardRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface CreditCardService.
 */
public interface CreditCardService {

	/**
	 * Creates the credit card.
	 *
	 * @param creditCardRequest the credit card request
	 * @return the string
	 */
	public abstract String createCreditCard(CreditCardRequest creditCardRequest);

}
