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
 * The Class ProductCategory.
 */
@Entity
@Table(name = "product_categories")

/**
 * Gets the name category.
 *
 * @return the name category
 */
@Getter

/**
 * Sets the name category.
 *
 * @param nameCategory the new name category
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product category.
 *
 * @param idProductCategory the id product category
 * @param nameCategory the name category
 */
@AllArgsConstructor

/**
 * Instantiates a new product category.
 */
@NoArgsConstructor
public class ProductCategory {

	/** The id product category. */
	@Id
	@Column(name = "id_product_category", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idProductCategory;
	
	/** The name category. */
	@Column(name = "name_category")
	private String nameCategory;

}
