package com.example.mrp.controller;

import com.example.mrp.model.MrpResult;
import com.example.mrp.service.MrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mrp")
@CrossOrigin(origins = "http://localhost:8080") // Allows requests from the frontend running on localhost:8080
public class MrpController {

    @Autowired
    private MrpService mrpService; // Service layer to handle MRP calculations

    @GetMapping("/calculate")
    public List<MrpResult> calculateMrp(@RequestParam String productName, @RequestParam int quantity) {
    	// Calls the MRP service to calculate requirements and return the results
    	return mrpService.calculateMrp(productName, quantity);
    }
}