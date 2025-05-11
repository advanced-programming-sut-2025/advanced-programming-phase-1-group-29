package org.example.models;

public abstract class Tool extends InventoryItem{
    public Tool(String name, int price) {
        super(name, price);
    }

    public abstract Result useTool(int x, int y);
    public abstract int getEnergyConsumption();
}
