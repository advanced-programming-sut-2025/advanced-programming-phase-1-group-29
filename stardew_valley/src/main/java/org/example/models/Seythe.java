package org.example.models;

public class Seythe extends Tool{
    public Seythe(String name, int price) {
        super(name, price);
    }

    @Override
    public int getEnergyConsumption() {
        return 2;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }
}
