package com.hulk.store.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.InventoryConverter;
import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;
import com.hulk.store.model.InventoryRequest;
import com.hulk.store.model.InventoryResponse;
import com.hulk.store.repository.InventoryRepository;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.repository.ProductRepository;
import com.hulk.store.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryServiceImpl.
 */
@Service("inventoryServiceImpl")

/** The Constant log. */
@Slf4j
public class InventoryServiceImpl extends ExceptionCommonServiceImpl implements InventoryService {

	/** The Constant UPDATE_STOCK. */
	public static final String UPDATE_STOCK = "The stock has been updated successfully.";

	/** The inventory repository. */
	@Autowired
	@Qualifier("inventoryRepository")
	private InventoryRepository inventoryRepository;

	/** The product repository. */
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	/** The product inventory repository. */
	@Autowired
	@Qualifier("productInventoryRepository")
	private ProductInventoryRepository productInventoryRepository;

	/** The inventory converter. */
	@Autowired
	@Qualifier("inventoryConverter")
	private InventoryConverter inventoryConverter;

	/**
	 * Delete list inventory.
	 *
	 * @param listIdInventories the list id inventories
	 */
	@Override
	public void deleteListInventory(Set<String> listIdInventories) {
		log.info("Ejecuta servicio: deleteListInventory");
		for (String idInventory : listIdInventories) {
			inventoryRepository.delete(inventoryRepository.findById(idInventory).get());
		}
	}

	/**
	 * Gets the inventory by id.
	 *
	 * @param idInventory the id inventory
	 * @return the inventory by id
	 */
	@Override
	public InventoryResponse getInventoryById(String idInventory) {
		log.info("Ejecuta servicio: getInventoryById");
		Inventory inventory = getInventoryByIdInventory(idInventory);
		return inventoryConverter.convertInventoryToInventoryResponse(inventory);
	}

	/**
	 * Update stock.
	 *
	 * @param inventoryRequest the inventory request
	 * @return the string
	 */
	@Override
	public String updateStock(InventoryRequest inventoryRequest) {
		log.info("Ejecuta servicio: updateStock");
		Product product = getProductByIdProduct(inventoryRequest.getIdProduct());
		Inventory inventory = getInventoryByIdInventory(inventoryRequest.getIdInventory());
		ProductInventory productInventory = productInventoryRepository
				.findProductInventoryByProductAndInventory(product, inventory);
		productInventory.setStockProduct(productInventory.getStockProduct() + inventoryRequest.getStockProduct());
		productInventoryRepository.save(productInventory);
		return UPDATE_STOCK;
	}

}
