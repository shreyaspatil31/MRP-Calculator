package com.example.mrp.model;

public class MrpResult {
    private String partName;
    private int requiredQuantity;
    private int onHandInventory;
    private int netRequirement;

    public MrpResult(String partName, int requiredQuantity, int onHandInventory, int netRequirement) {
        this.partName = partName;
        this.requiredQuantity = requiredQuantity;
        this.onHandInventory = onHandInventory;
        this.netRequirement = netRequirement;
    }

    // Getters and setters
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public int getOnHandInventory() {
        return onHandInventory;
    }

    public void setOnHandInventory(int onHandInventory) {
        this.onHandInventory = onHandInventory;
    }

    public int getNetRequirement() {
        return netRequirement;
    }

    public void setNetRequirement(int netRequirement) {
        this.netRequirement = netRequirement;
    }
}