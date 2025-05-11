package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private ArrayList<InventoryItem> products = new ArrayList<>();
    private final HashMap<InventoryItem, Integer> productNumbers = new HashMap<>();


    public Result welcomeMessage(){
        return new Result(true, "Welcome");
    }
    public Result
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
    public Result purchase(InventoryItem product, int quantity) {
        if (productNumbers.containsKey(product)) {
            int currentQuantity = productNumbers.get(product);
            int newQuantity = currentQuantity - quantity;
            if (newQuantity < 0) {
                return new Result(false, "not enough products in store");
            }
            productNumbers.put(product, newQuantity);
            App.getCurrentGame().getCurrentPlayer().getInventory().
        }
        else{
            return new Result(false, "Product not in store");
        }
    }
}
