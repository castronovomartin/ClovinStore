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
 * The Class Inventory.
 */
@Entity
@Table(name = "inventories")

/**
 * Gets the description inventory.
 *
 * @return the description inventory
 */
@Getter

/**
 * Sets the description inventory.
 *
 * @param descriptionInventory the new description inventory
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new inventory.
 *
 * @param id the id
 * @param descriptionInventory the description inventory
 */
@AllArgsConstructor

/**
 * Instantiates a new inventory.
 */
@NoArgsConstructor
public class Inventory {

	/** The id. */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	
	/** The description inventory. */
	@Column(name = "description_inventory")
	private String descriptionInventory;

}
