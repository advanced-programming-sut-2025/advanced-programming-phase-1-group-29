package org.example.models;

import org.example.models.enums.InventoryType;

import java.util.HashMap;

public class Inventory {
    private InventoryType type = InventoryType.PRIMARY;
    private final HashMap<InventoryItem, Integer> inventoryItems = new HashMap<>();

    public Inventory() {
        inventoryItems.put(new Hoe(), 1);
        inventoryItems.put(new WateringCan(), 1);
        inventoryItems.put(new Pickaxe(), 1);
        inventoryItems.put(new Axe(), 1);
        inventoryItems.put(new Seythe(), 1);
    }

    public InventoryType getType() {
        return type;
    }

    public void setType(InventoryType type) {
        this.type = type;
    }

    public HashMap<InventoryItem, Integer> getInventoryItems() {
        return inventoryItems;
    }
}
