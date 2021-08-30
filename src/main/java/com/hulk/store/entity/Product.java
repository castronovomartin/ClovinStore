package com.hulk.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@Entity
@Table(name = "products")

/**
 * Gets the product category.
 *
 * @return the product category
 */
@Getter

/**
 * Sets the product category.
 *
 * @param productCategory the new product category
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product.
 *
 * @param idProduct the id product
 * @param productName the product name
 * @param productPrice the product price
 * @param productCategory the product category
 */
@AllArgsConstructor

/**
 * Instantiates a new product.
 */
@NoArgsConstructor
public class Product {

	/** The id product. */
	@Id
	@Column(name = "id_product", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idProduct;
	
	/** The product name. */
	@Column(name = "product_name")
	private String productName;
	
	/** The product price. */
	@Column(name = "product_price")
	private double productPrice;
	
	/** The product category. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_product_category")
	private ProductCategory productCategory;

}
