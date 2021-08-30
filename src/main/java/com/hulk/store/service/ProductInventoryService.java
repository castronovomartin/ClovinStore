package com.hulk.store.service;

import java.util.List;

import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductInventoryService.
 */
public interface ProductInventoryService {

	/**
	 * Creates the product inventory.
	 *
	 * @param product the product
	 * @param inventory the inventory
	 */
	public abstract void createProductInventory(Product product, Inventory inventory);

	/**
	 * Delete list product inventory.
	 *
	 * @param listProductInventories the list product inventories
	 */
	public abstract void deleteListProductInventory(List<ProductInventory> listProductInventories);

}
