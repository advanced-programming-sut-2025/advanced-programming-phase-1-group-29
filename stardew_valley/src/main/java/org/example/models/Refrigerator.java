package org.example.models;

import java.util.HashMap;

public class Refrigerator {

    private final HashMap<InventoryItem, Integer> items = new HashMap<>();

    public void addItem(InventoryItem item, int quantity) {
        for (InventoryItem refrigeratorItem : items.keySet()) {
            if (refrigeratorItem.getName().equals(item.getName())) {
                quantity += items.get(refrigeratorItem);
                items.put(refrigeratorItem, quantity);
                return;
            }
        }
        items.put(item, quantity);
    }

    public void removeItem(String name, int quantity) {
        for (InventoryItem refrigeratorItem : items.keySet()) {
            if (refrigeratorItem.getName().equals(name)) {
                quantity = items.get(refrigeratorItem) - quantity;
                if (quantity == 0) {
                    items.remove(refrigeratorItem);
                }
                else {
                    items.put(refrigeratorItem, quantity);
                }
                return;
            }
        }
    }

    public int getQuantity(String name) {
        for (InventoryItem refrigeratorItem : items.keySet()) {
            if (refrigeratorItem.getName().equals(name)) {
                return items.get(refrigeratorItem);
            }
        }
        return 0;
    }

    public InventoryItem findItem(String name) {
        for (InventoryItem inventoryItem : items.keySet()) {
            if (inventoryItem.getName().equals(name)) {
                return inventoryItem;
            }
        }
        return null;
    }
}
