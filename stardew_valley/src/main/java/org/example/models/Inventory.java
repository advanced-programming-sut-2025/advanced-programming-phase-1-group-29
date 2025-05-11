package org.example.models;

import org.example.models.enums.InventoryType;

import java.util.HashMap;

public class Inventory {
    private InventoryType type = InventoryType.PRIMARY;
    private final HashMap<InventoryItem, Integer> inventoryItems = new HashMap<>();

    public Inventory() {
        inventoryItems.put(new Hoe("Hoe", 0), 1);
        inventoryItems.put(new WateringCan("Watering Can", 0), 1);
        inventoryItems.put(new Pickaxe("Pickaxe", 0), 1);
        inventoryItems.put(new Axe("Axe", 0), 1);
        inventoryItems.put(new Seythe("Seythe", 0), 1);
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
        int items = 0;
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            items += inventoryItems.get(inventoryItem);
        }
        return type.getCapacity() - items;
    }

    public boolean isFull(){
        return getCapacity() >= type.getCapacity();
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

    public void addInventoryItem(String name, int amount, int price) {
        int oldAmount = 0;
        InventoryItem item = null;
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) {
                oldAmount = inventoryItems.get(inventoryItem);
                item = inventoryItem;
            }
        }
        if (item == null) {
            item = new InventoryItem(name, price);
        }
        inventoryItems.put(item, oldAmount + amount);
        if (oldAmount + amount == 0) inventoryItems.remove(item);
    }

    public void removeInventoryItem(String name, int amount) {
        InventoryItem item = findInventoryItem(name);
        if (item == null) return;
        if(inventoryItems.get(item) == amount){
            inventoryItems.remove(item);
            return;
        }
        inventoryItems.compute(item, (k, oldAmount) -> oldAmount - amount);
    }
}
