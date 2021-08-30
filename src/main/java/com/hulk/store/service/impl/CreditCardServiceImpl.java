package com.hulk.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.TestCrypt;
import com.hulk.store.entity.BrandCard;
import com.hulk.store.entity.CreditCard;
import com.hulk.store.entity.User;
import com.hulk.store.model.CreditCardRequest;
import com.hulk.store.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class CreditCardServiceImpl.
 */
@Service("creditCardServiceImpl")

/** The Constant log. */
@Slf4j
public class CreditCardServiceImpl extends ExceptionCommonServiceImpl implements CreditCardService {

	/** The Constant CREDIT_CARD_CREATED. */
	public static final String CREDIT_CARD_CREATED = "The credit card has been created successfully.";

	/** The test crypt. */
	@Autowired
	@Qualifier("testCrypt")
	private TestCrypt testCrypt;

	/**
	 * Creates the credit card.
	 *
	 * @param creditCardRequest the credit card request
	 * @return the string
	 */
	@Override
	public String createCreditCard(CreditCardRequest creditCardRequest) {
		log.info("Ejecuta servicio: createCreditCard");
		checkCreditCardExistByCardNumber(creditCardRequest.getCardNumber());
		User user = getUserByIdUser(creditCardRequest.getIdUser());
		BrandCard brandCard = getBrandCardById(creditCardRequest.getIdBrandCard());
		creditCardRepository.save(
				CreditCard.builder().cardNumber(testCrypt.encrypt(String.valueOf(creditCardRequest.getCardNumber())))
						.securityCode(testCrypt.encrypt(String.valueOf(creditCardRequest.getSecurityCode()))).user(user)
						.brandCard(brandCard).build());
		return CREDIT_CARD_CREATED;
	}

}
