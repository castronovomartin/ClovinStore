package com.hulk.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandCard.
 */
@Entity
@Table(name = "brand_cards")

/**
 * Gets the name card.
 *
 * @return the name card
 */
@Getter

/**
 * Sets the name card.
 *
 * @param nameCard the new name card
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new brand card.
 *
 * @param idBrandCard the id brand card
 * @param nameCard the name card
 */
@AllArgsConstructor

/**
 * Instantiates a new brand card.
 */
@NoArgsConstructor
public class BrandCard {
	
	/** The id brand card. */
	@Id
	@Column(name = "id_brand_card", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idBrandCard;
	
	/** The name card. */
	@Column(name = "name_card")
	private String nameCard;

}
