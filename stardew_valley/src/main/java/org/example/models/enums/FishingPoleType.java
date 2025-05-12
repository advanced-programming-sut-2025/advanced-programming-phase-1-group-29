package org.example.models.enums;

public enum FishingPoleType {
    PRIMARY("Training Roⅾ", 25, 0, 0.1),
    BAMBOO("Baⅿboo Poⅼe", 500, 0, 0.5),
    FIBER_GLASS("Fibergⅼass Roⅾ", 1800, 2, 0.9),
    IRIDIUM("Iriⅾiuⅿ Roⅾ", 7500, 4, 1.2);

    private final String name;
    private final int price;
    private final int fishingLevelNeeded;
    private final double quantityRate;

    FishingPoleType(String name, int price, int fishingLevelNeeded, double quantityRate) {
        this.name = name;
        this.price = price;
        this.fishingLevelNeeded = fishingLevelNeeded;
        this.quantityRate = quantityRate;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getFishingLevelNeeded() {
        return fishingLevelNeeded;
    }

    public double getQuantityRate() {
        return quantityRate;
    }

    public FishingPoleType upgrade() {
        if (this.equals(FishingPoleType.PRIMARY)) return FishingPoleType.BAMBOO;
        if (this.equals(FishingPoleType.BAMBOO)) return FishingPoleType.FIBER_GLASS;
        if (this.equals(FishingPoleType.FIBER_GLASS)) return FishingPoleType.IRIDIUM;
        return null;
    }

    public static FishingPoleType getFishingPoleByName(String name) {
        for(FishingPoleType type : FishingPoleType.values()) {
            if(type.name.equals(name)) return type;
        }
        return null;
    }
}
