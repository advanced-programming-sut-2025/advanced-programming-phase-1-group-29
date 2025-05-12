package org.example.models.enums;

public enum Weather {
    SUNNY (1.5),
    RAINY (1.2),
    STORMY (0.5),
    SNOWY (1),
    ;

    private final double fishingRate;

    private Weather(double fishingRate) {
        this.fishingRate = fishingRate;
    }

    public double getFishingRate() {
        return fishingRate;
    }
}
