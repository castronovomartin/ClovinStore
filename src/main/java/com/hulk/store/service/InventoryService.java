package com.hulk.store.service;

import java.util.Set;

import com.hulk.store.model.InventoryRequest;
import com.hulk.store.model.InventoryResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface InventoryService.
 */
public interface InventoryService {

	/**
	 * Delete list inventory.
	 *
	 * @param listIdInventories the list id inventories
	 */
	public abstract void deleteListInventory(Set<String> listIdInventories);

	/**
	 * Gets the inventory by id.
	 *
	 * @param idInventory the id inventory
	 * @return the inventory by id
	 */
	public abstract InventoryResponse getInventoryById(String idInventory);

	/**
	 * Update stock.
	 *
	 * @param inventoryRequest the inventory request
	 * @return the string
	 */
	public abstract String updateStock(InventoryRequest inventoryRequest);

}
