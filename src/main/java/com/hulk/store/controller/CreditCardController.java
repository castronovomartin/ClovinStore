package com.hulk.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.CreditCardRequest;
import com.hulk.store.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class CreditCardController.
 */
@RestController
@RequestMapping("/cards")

/** The Constant log. */
@Slf4j
public class CreditCardController {

	/** The credit card service. */
	@Autowired
	@Qualifier("creditCardServiceImpl")
	private CreditCardService creditCardService;

	/**
	 * Creates the credit card.
	 *
	 * @param creditCardRequest the credit card request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> createCreditCard(@RequestBody CreditCardRequest creditCardRequest) {
		log.info("Entra al controller del servicio createCreditCard");
		String messageResponse = creditCardService.createCreditCard(creditCardRequest);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

}
