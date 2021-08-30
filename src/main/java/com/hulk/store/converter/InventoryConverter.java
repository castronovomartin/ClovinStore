package com.hulk.store.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hulk.store.entity.Inventory;
import com.hulk.store.model.InventoryResponse;
import com.hulk.store.repository.ProductInventoryRepository;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryConverter.
 */
@Component("inventoryConverter")

/** The Constant log. */
@Slf4j
public class InventoryConverter {

	/** The product converter. */
	@Autowired
	@Qualifier("productConverter")
	private ProductConverter productConverter;

	/** The product inventory repository. */
	@Autowired
	@Qualifier("productInventoryRepository")
	private ProductInventoryRepository productInventoryRepository;

	/**
	 * Convert inventory to inventory response.
	 *
	 * @param inventory the inventory
	 * @return the inventory response
	 */
	public InventoryResponse convertInventoryToInventoryResponse(Inventory inventory) {
		log.info("Convierte Inventory a InventoryResponse");
		return InventoryResponse.builder().idInventary(inventory.getId())
				.descriptionInventory(inventory.getDescriptionInventory())
				.listProducts(productConverter.convertListProductInventoryToListProductResponse(
						productInventoryRepository.findProductInventoryByInventory(inventory)))
				.build();
	}

}
