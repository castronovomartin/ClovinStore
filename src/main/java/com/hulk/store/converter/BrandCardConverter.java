package com.hulk.store.converter;

import org.springframework.stereotype.Component;

import com.hulk.store.entity.BrandCard;
import com.hulk.store.model.BrandCardResponse;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandCardConverter.
 */
@Component("brandCardConverter")

/** The Constant log. */
@Slf4j
public class BrandCardConverter {

	/**
	 * Convert brand card to brand card response.
	 *
	 * @param brandCard the brand card
	 * @return the brand card response
	 */
	public BrandCardResponse convertBrandCardToBrandCardResponse(BrandCard brandCard) {
		log.info("Convierte BrandCard a BrandCardResponse");
		return BrandCardResponse.builder().idBrandCard(brandCard.getIdBrandCard()).nameCard(brandCard.getNameCard())
				.build();
	}

}
