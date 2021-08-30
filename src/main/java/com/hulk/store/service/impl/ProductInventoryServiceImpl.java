package com.hulk.store.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;
import com.hulk.store.repository.InventoryRepository;
import com.hulk.store.repository.ProductInventoryRepository;
import com.hulk.store.repository.ProductRepository;
import com.hulk.store.service.InventoryService;
import com.hulk.store.service.ProductInventoryService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductInventoryServiceImpl.
 */
@Service("productInventoryServiceImpl")

/** The Constant log. */
@Slf4j
public class ProductInventoryServiceImpl extends ExceptionCommonServiceImpl implements ProductInventoryService {

	/** The Constant INITIAL_STOCK. */
	public static final int INITIAL_STOCK = 1;

	/** The product inventory repository. */
	@Autowired
	@Qualifier("productInventoryRepository")
	private ProductInventoryRepository productInventoryRepository;

	/** The product repository. */
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	/** The inventory repository. */
	@Autowired
	@Qualifier("inventoryRepository")
	private InventoryRepository inventoryRepository;

	/** The inventory service. */
	@Autowired
	@Qualifier("inventoryServiceImpl")
	private InventoryService inventoryService;

	/**
	 * Creates the product inventory.
	 *
	 * @param product the product
	 * @param inventory the inventory
	 */
	@Override
	public void createProductInventory(Product product, Inventory inventory) {
		log.info("Ejecuta servicio: createProductInventory");
		productInventoryRepository.save(
				ProductInventory.builder().product(product).inventory(inventory).stockProduct(INITIAL_STOCK).build());
	}

	/**
	 * Delete list product inventory.
	 *
	 * @param listProductInventories the list product inventories
	 */
	@Override
	public void deleteListProductInventory(List<ProductInventory> listProductInventories) {
		log.info("Ejecuta servicio: deleteListProductInventory");
		Set<String> listIdInventory = new HashSet<String>();
		for (ProductInventory productInventory : listProductInventories) {
			listIdInventory.add(productInventory.getInventory().getId());
			productInventoryRepository.delete(productInventory);
		}
		inventoryService.deleteListInventory(listIdInventory);
	}

}
