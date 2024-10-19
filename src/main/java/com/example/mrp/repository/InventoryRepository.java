package com.example.mrp.repository;

import com.example.mrp.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByPartName(String partName);
}