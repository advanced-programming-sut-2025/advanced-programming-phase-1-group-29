package org.example.models;

public abstract class Tool extends InventoryItem{
    public Tool(String name, int price) {
        super(name, price);
    }

    public abstract Result useTool(int x, int y);
    public abstract int getEnergyConsumption();
    public int applyWeatherOnEnergyConsumption(int energy) {
        return (int)(energy * App.getCurrentGame().getWeather().getEnergyConsumption());
    }
}
