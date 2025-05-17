package org.example.models;

import org.example.models.ToolsPackage.*;
import org.example.models.enums.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private InventoryType type = InventoryType.PRIMARY;
    private final HashMap<InventoryItem, Integer> inventoryItems = new HashMap<>();

    public Inventory() {
        inventoryItems.put(new Hoe("Hoe", 0), 1);
        inventoryItems.put(new WateringCan("WateringCan", 0), 1);
        inventoryItems.put(new Pickaxe("Pickaxe", 0), 1);
        inventoryItems.put(new Axe("Axe", 0), 1);
        inventoryItems.put(new Seythe("Seythe", 0), 1);
    }

    public ArrayList<String> getUniqueInventoryItems() {
        ArrayList<String> items = new ArrayList<>();
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            boolean isRepeated = false;
            for (String item : items) {
                if (item.equalsIgnoreCase(inventoryItem.getName().replaceAll("\\s+", ""))) {
                    isRepeated = true;
                    break;
                }
            }
            if (!isRepeated) items.add(inventoryItem.getName().replaceAll("\\s+", ""));
        }
        return items;
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
        return type.getCapacity() - getUniqueInventoryItems().size();
    }

    public InventoryItem findInventoryItem(String name) {
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) return inventoryItem;
        }
        return null;
    }

    public int getNumberOfInventoryItem(String name) {
        int items = 0;
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name)) {
                items += inventoryItems.get(inventoryItem);
            }
        }
        return items;
    }

    public void addInventoryItem(String name, int amount, int price) {
        int oldAmount = 0;
        InventoryItem item = null;
        for (InventoryItem inventoryItem : inventoryItems.keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name) && inventoryItem.getPrice() == price) {
                oldAmount = inventoryItems.get(inventoryItem);
                item = inventoryItem;
            }
        }
        if (item == null) {
            //TODO special types of inventory items
            if(FoodRecipe.getByName(name) != null) {
                App.getCurrentGame().getCurrentPlayer().getFoodRecipeList().add(FoodRecipe.getByName(name));
                return;
            }
            if(CraftingItemEnum.getByName(name) != null) {
                App.getCurrentGame().getCurrentPlayer().getCraftingRecipeList().add(CraftingItemEnum.getByName(name));
                return;
            }
            try {
                CropSeedEnum.valueOf(name.toUpperCase());
                item = new CropSeed(name, price);
            } catch (IllegalArgumentException _) {
                try {
                    TreeSeedEnum.valueOf(name.toUpperCase());
                    item = new TreeSeed(name, price);
                } catch (IllegalArgumentException _) {
                    item = new InventoryItem(name, price);
                }
            }
        }
        inventoryItems.put(item, oldAmount + amount);
        if (oldAmount + amount == 0) inventoryItems.remove(item);
    }

    public void addInventoryItem(InventoryItem item, int amount) {
        int oldAmount = 0;
        if (this.inventoryItems.containsKey(item)) {
            oldAmount = this.inventoryItems.get(item);
        }
        inventoryItems.put(item, amount + oldAmount);
    }

    public void removeInventoryItem(String name, int amount) {
        while(amount > 0) {
            InventoryItem item = findInventoryItem(name);
            if (item == null) return;
            if (inventoryItems.get(item) <= amount) {
                amount -= inventoryItems.get(item);
                inventoryItems.remove(item);
            }
            else {
                inventoryItems.put(item, inventoryItems.get(item) - amount);
                amount = 0;
            }
        }
    }
}
