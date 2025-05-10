package org.example.models;

public class Axe extends Tool{
    @Override
    public int getEnergyConsumption() {
        return 0;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }
}
