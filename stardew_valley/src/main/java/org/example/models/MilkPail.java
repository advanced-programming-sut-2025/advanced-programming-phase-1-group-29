package org.example.models;

public class MilkPail extends Tool{

    public MilkPail() {
        price = 1000;
    }

    @Override
    public int getEnergyConsumption() {
        return 4;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }
}
