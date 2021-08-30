package com.hulk.store.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Inventory;
import com.hulk.store.entity.Product;
import com.hulk.store.entity.ProductInventory;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductInventoryRepository.
 */
@Repository("productInventoryRepository")
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Serializable> {

	/**
	 * Find product inventory by product.
	 *
	 * @param product the product
	 * @return the list
	 */
	public abstract List<ProductInventory> findProductInventoryByProduct(Product product);

	/**
	 * Find product inventory by inventory.
	 *
	 * @param inventory the inventory
	 * @return the list
	 */
	public abstract List<ProductInventory> findProductInventoryByInventory(Inventory inventory);

	/**
	 * Find product inventory by product and inventory.
	 *
	 * @param product the product
	 * @param inventory the inventory
	 * @return the product inventory
	 */
	public abstract ProductInventory findProductInventoryByProductAndInventory(Product product, Inventory inventory);

}
