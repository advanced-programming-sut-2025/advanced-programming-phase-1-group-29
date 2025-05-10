package org.example.models;

import java.util.HashMap;

public class Inventory {
    private final HashMap<InventoryItem, Integer> inventoryItems = new HashMap<>();

    public Inventory() {
        inventoryItems.put(new Hoe(), 1);
    }

    public HashMap<InventoryItem, Integer> getInventoryItems() {
        return inventoryItems;
    }
}
