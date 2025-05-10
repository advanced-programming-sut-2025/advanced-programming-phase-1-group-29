package org.example.models;

public class Seythe extends Tool{
    @Override
    public int getEnergyConsumption() {
        return 2;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }
}
