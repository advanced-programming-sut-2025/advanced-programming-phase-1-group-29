package org.example.models;

import java.util.ArrayList;

public class SalesBucket extends Objectt{
    private final ArrayList<InventoryItem> items = new ArrayList<>();

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public void addItem(InventoryItem item) {
        items.add(item);
    }
}
