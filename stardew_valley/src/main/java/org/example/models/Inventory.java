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

    public int getCapacity() {
        return type.getCapacity();
    }

    public InventoryItem findInventoryItem(String name) {
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) return inventoryItem;
        }
        return null;
    }

    public int getNumberOfInventoryItem(String name) {
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) {
                return inventoryItems.get(inventoryItem);
            }
        }
        return 0;
    }

    public void addInventoryItem(String name, int amount) {
        int oldAmount = 0;
        InventoryItem item = null;
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) {
                oldAmount = inventoryItems.get(inventoryItem);
                item = inventoryItem;
            }
        }
        if (item == null) {
            item = new InventoryItem();
            item.setName(name);
        }
        inventoryItems.put(item, oldAmount + amount);
        if (oldAmount + amount == 0) inventoryItems.remove(item);
    }
}
