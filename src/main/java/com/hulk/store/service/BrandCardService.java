package com.hulk.store.service;

import com.hulk.store.model.BrandCardResponse;
import com.hulk.store.model.BrendCardRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface BrandCardService.
 */
public interface BrandCardService {
	
	/**
	 * Creates the brand card.
	 *
	 * @param brendCardRequest the brend card request
	 * @return the brand card response
	 */
	public abstract BrandCardResponse createBrandCard(BrendCardRequest brendCardRequest);

}
