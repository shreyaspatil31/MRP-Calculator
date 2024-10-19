package com.example.mrp.service;

import com.example.mrp.model.Bom;
import com.example.mrp.model.Inventory;
import com.example.mrp.model.MrpResult;
import com.example.mrp.repository.BomRepository;
import com.example.mrp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MrpService {

    @Autowired
    private BomRepository bomRepository;  // Repository to access Bill of Materials (BOM) data

    @Autowired
    private InventoryRepository inventoryRepository;  // Repository to access inventory data

    // Calculates the Material Requirements Planning (MRP) based on a product name and quantity.
    public List<MrpResult> calculateMrp(String productName, int quantity) {
        // Map to store total material requirements (key: part name, value: required quantity)
        Map<String, Integer> totalRequirements = new HashMap<>();

        // Calculate the total requirements for the product and its components recursively
        calculateRequirements(productName, quantity, totalRequirements);

        List<MrpResult> results = new ArrayList<>();

        // For each part in the total requirements, calculate the net requirement after accounting for inventory
        for (Map.Entry<String, Integer> entry : totalRequirements.entrySet()) {
            String partName = entry.getKey();
            int requiredQuantity = entry.getValue();

            // Get current on-hand inventory for the part
            Inventory inventory = inventoryRepository.findByPartName(partName);
            int onHandInventory = inventory != null ? inventory.getOnHandInventory() : 0;

            // Calculate net requirement (total requirement - on-hand inventory)
            int netRequirement = Math.max(requiredQuantity - onHandInventory, 0);

            // Add the result for this part to the list of MRP results
            results.add(new MrpResult(partName, requiredQuantity, onHandInventory, netRequirement));
        }

        return results;  // Return the list of MRP results
    }

    // Recursively calculates the total requirements for a product and its components based on the BOM.
    private void calculateRequirements(String productName, int quantity, Map<String, Integer> totalRequirements) {
        // Get the list of BOM items (components) for the product
        List<Bom> bomItems = bomRepository.findByProductName(productName);

        // For each BOM item, calculate the total required quantity and update the total requirements
        for (Bom item : bomItems) {
            int requiredQuantity = item.getRequiredQuantity() * quantity;

            // Merge the calculated required quantity into the total requirements map
            totalRequirements.merge(item.getPartName(), requiredQuantity, Integer::sum);

            // Recursively calculate the requirements for each component of this part
            calculateRequirements(item.getPartName(), requiredQuantity, totalRequirements);
        }
    }
}
