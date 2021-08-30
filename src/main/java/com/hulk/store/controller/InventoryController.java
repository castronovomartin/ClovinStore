package com.hulk.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.InventoryRequest;
import com.hulk.store.model.InventoryResponse;
import com.hulk.store.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryController.
 */
@RestController
@RequestMapping("/inventories")

/** The Constant log. */
@Slf4j
public class InventoryController {

	/** The inventory service. */
	@Autowired
	@Qualifier("inventoryServiceImpl")
	private InventoryService inventoryService;

	/**
	 * Gets the inventory by id.
	 *
	 * @param idInventary the id inventary
	 * @return the inventory by id
	 */
	@GetMapping("/{idInventary}")
	public ResponseEntity<InventoryResponse> getInventoryById(@PathVariable("idInventary") String idInventary) {
		log.info("Entra al controller del servicio getInventoryById");
		InventoryResponse inventoryResponse = inventoryService.getInventoryById(idInventary);
		return new ResponseEntity<InventoryResponse>(inventoryResponse, HttpStatus.OK);
	}

	/**
	 * Adds the stock product.
	 *
	 * @param inventoryRequest the inventory request
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<String> addStockProduct(@RequestBody InventoryRequest inventoryRequest) {
		log.info("Entra al controller del servicio addStockProduct");
		String messageResponse = inventoryService.updateStock(inventoryRequest);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

}
