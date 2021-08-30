package com.hulk.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Inventory;

/**
 * The Interface InventoryRepository.
 */
@Repository("inventoryRepository")
public interface InventoryRepository extends JpaRepository<Inventory, Serializable> {

}
