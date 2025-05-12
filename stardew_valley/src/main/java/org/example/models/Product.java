package org.example.models;

public class Product extends InventoryItem{

    private double quantity;

    public Product(String name, int price, double quality) {
        super(name, price);
        this.quantity = quality;
    }

    public double getQuantity() {
        return quantity;
    }
}
