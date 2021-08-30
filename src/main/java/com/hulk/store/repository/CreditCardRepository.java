package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.CreditCard;
import com.hulk.store.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface CreditCardRepository.
 */
@Repository("creditCardRepository")
public interface CreditCardRepository extends JpaRepository<CreditCard, Serializable> {

	/**
	 * Find by card number.
	 *
	 * @param cardNumber the card number
	 * @return the credit card
	 */
	public abstract CreditCard findByCardNumber(String cardNumber);

	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return the credit card
	 */
	public abstract CreditCard findByUser(User user);

}
