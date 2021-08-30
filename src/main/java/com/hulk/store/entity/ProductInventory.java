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
 * The Class ProductInventory.
 */
@Entity
@Table(name = "product_inventories")

/**
 * Gets the stock product.
 *
 * @return the stock product
 */
@Getter

/**
 * Sets the stock product.
 *
 * @param stockProduct the new stock product
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product inventory.
 *
 * @param idProductInventory the id product inventory
 * @param inventory the inventory
 * @param product the product
 * @param stockProduct the stock product
 */
@AllArgsConstructor

/**
 * Instantiates a new product inventory.
 */
@NoArgsConstructor
public class ProductInventory {

	/** The id product inventory. */
	@Id
	@Column(name = "id_product_inventory", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idProductInventory;
	
	/** The inventory. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_inventory")
	private Inventory inventory;
	
	/** The product. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_product")
	private Product product;
	
	/** The stock product. */
	@Column(name = "stock_product")
	private int stockProduct;

}
