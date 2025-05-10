package org.example.models;

public abstract class Tool extends InventoryItem{
    public abstract Result useTool(int x, int y);
    public abstract int getEnergyConsumption();
}
