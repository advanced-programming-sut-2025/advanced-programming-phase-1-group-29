package org.example.models.enums;

public enum Weather {
    SUNNY (1.5, 1),
    RAINY (1.2, 1.5),
    STORMY (0.5, 1.5),
    SNOWY (1, 2),
    ;

    private final double fishingRate;
    private final double energyConsumption;

    Weather(double fishingRate, double energyConsumption) {
        this.fishingRate = fishingRate;
        this.energyConsumption = energyConsumption;
    }

    public double getFishingRate() {
        return fishingRate;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }
}
