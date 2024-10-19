package com.example.mrp.repository;

import com.example.mrp.model.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BomRepository extends JpaRepository<Bom, Long> {
    List<Bom> findByProductName(String productName);
}