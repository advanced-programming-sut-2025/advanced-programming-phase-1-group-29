package org.example.models.enums;

public enum FishingPoleType {
    PRIMARY("Training Roⅾ", 25, 0),
    BAMBOO("Baⅿboo Poⅼe", 500, 0),
    FIBER_GLASS("Fibergⅼass Roⅾ", 1800, 2),
    IRIDIUM("Iriⅾiuⅿ Roⅾ", 7500, 4);

    private final String name;
    private final int price;
    private final int fishingLevelNeeded;

    FishingPoleType(String name, int price, int fishingLevelNeeded) {
        this.name = name;
        this.price = price;
        this.fishingLevelNeeded = fishingLevelNeeded;
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
