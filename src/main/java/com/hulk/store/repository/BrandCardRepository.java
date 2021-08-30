package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.BrandCard;

// TODO: Auto-generated Javadoc
/**
 * The Interface BrandCardRepository.
 */
@Repository("brandCardRepository")
public interface BrandCardRepository extends JpaRepository<BrandCard, Serializable> {

	/**
	 * Find by name card.
	 *
	 * @param nameCard the name card
	 * @return the brand card
	 */
	public abstract BrandCard findByNameCard(String nameCard);

}
