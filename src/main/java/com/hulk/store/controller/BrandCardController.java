package com.hulk.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.BrandCardResponse;
import com.hulk.store.model.BrendCardRequest;
import com.hulk.store.service.BrandCardService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandCardController.
 */
@RestController
@RequestMapping("/brands")

/** The Constant log. */
@Slf4j
public class BrandCardController {

	/** The brand card service. */
	@Autowired
	@Qualifier("brandCardServiceImpl")
	private BrandCardService brandCardService;

	/**
	 * Creates the brand card.
	 *
	 * @param brendCardRequest the brend card request
	 * @return the response entity
	 */
	@PostMapping()
	public ResponseEntity<BrandCardResponse> createBrandCard(@RequestBody BrendCardRequest brendCardRequest) {
		log.info("Entra al controller del servicio createBrandCard");
		BrandCardResponse brandCardResponse = brandCardService.createBrandCard(brendCardRequest);
		return new ResponseEntity<BrandCardResponse>(brandCardResponse, HttpStatus.OK);
	}

}
