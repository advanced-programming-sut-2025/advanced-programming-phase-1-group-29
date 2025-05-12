package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Objectt;
import org.example.models.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Store extends Objectt {
    private ArrayList<InventoryItem> products = new ArrayList<>();
    private final HashMap<InventoryItem, Integer> productNumbers = new HashMap<>();

    public abstract void resetCapacity();
    public abstract Result welcomeMessage();
    public abstract void openStore();
    public abstract boolean isOpen();
    public void resetProducts() {
        products.clear();
        productNumbers.clear();
    }
    public void addProduct(InventoryItem product, int quantity) {
        if (!productNumbers.containsKey(product)) {
            products.add(product);
        }
        productNumbers.put(product, productNumbers.getOrDefault(product, 0) + quantity);
    }
    public void removeProductQuantity(InventoryItem product, int quantity) {
        if (!productNumbers.containsKey(product)) {
            return;
        }
        int currentQuantity = productNumbers.get(product);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity < 0) { newQuantity = 0; }
        productNumbers.put(product, newQuantity);
    }
    public void removeProduct(InventoryItem product) {
        if (productNumbers.containsKey(product)) {
            productNumbers.remove(product);
            products.remove(product);
        }
    }
    public Result showAllProducts() {
        if (productNumbers.isEmpty()) {
            return new Result(false, "Store is empty.");
        }
        StringBuilder result = new StringBuilder("Products in store:\n");
        for (Map.Entry<InventoryItem, Integer> entry : productNumbers.entrySet()) {
            result.append("- ")
                    .append(entry.getKey().getName())
                    .append(" | Quantity: ")
                    .append(entry.getValue())
                    .append(" | Price: ")
                    .append(entry.getKey().getPrice())
                    .append("\n");
        }
        return new Result(true, result.toString());
    }
    public Result purchase(String productName, int quantity) {
        for (InventoryItem item : products) {
            if (item.getName().equalsIgnoreCase(productName)) {
                int available = productNumbers.getOrDefault(item, 0);
                if (available >= quantity) {
                    int totalPrice = item.getPrice() * quantity;
                    if (App.getCurrentGame().getCurrentPlayer().getCoins() < totalPrice) {
                        return new Result(false, "You don't have enough money to purchase.");
                    }
                    if (App.getCurrentGame().getCurrentPlayer().getInventory().getCapacity() < quantity){
                        return new Result(false, "You don't have enough capacity for this product.");
                    }
                    App.getCurrentGame().getCurrentPlayer().addCoins(-totalPrice);
                    productNumbers.put(item, available - quantity);
                    App.getCurrentGame().getCurrentPlayer().getInventory().addInventoryItem(productName, quantity, item.getPrice());
                    return new Result(true, "Successfully purchased.");
                }
                else {
                    return new Result(false, "Not enough stock");
                }
            }
        }
        return new Result(false, "Product not found.");
    }
}
