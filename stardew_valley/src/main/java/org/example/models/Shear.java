package org.example.models;

public class Shear extends Tool{

    public Shear() {
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
