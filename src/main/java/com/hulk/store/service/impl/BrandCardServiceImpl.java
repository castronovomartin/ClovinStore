package com.hulk.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.BrandCardConverter;
import com.hulk.store.entity.BrandCard;
import com.hulk.store.model.BrandCardResponse;
import com.hulk.store.model.BrendCardRequest;
import com.hulk.store.service.BrandCardService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandCardServiceImpl.
 */
@Service("brandCardServiceImpl")

/** The Constant log. */
@Slf4j
public class BrandCardServiceImpl extends ExceptionCommonServiceImpl implements BrandCardService {

	/** The brand card converter. */
	@Autowired
	@Qualifier("brandCardConverter")
	private BrandCardConverter brandCardConverter;

	/**
	 * Creates the brand card.
	 *
	 * @param brendCardRequest the brend card request
	 * @return the brand card response
	 */
	@Override
	public BrandCardResponse createBrandCard(BrendCardRequest brendCardRequest) {
		log.info("Ejecuta servicio: createBrandCard");
		checkBrandCardExistByName(brendCardRequest.getBrandCardName());
		return brandCardConverter.convertBrandCardToBrandCardResponse(
				brandCardRepository.save(BrandCard.builder().nameCard(brendCardRequest.getBrandCardName()).build()));
	}

}
