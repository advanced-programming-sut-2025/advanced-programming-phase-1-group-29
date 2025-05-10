package org.example.models.enums;

public enum FishingPoleType {
    PRIMARY(25, 0),
    BAMBOO(500, 0),
    FIBER_GLASS(1800, 2),
    IRIDIUM(7500, 4);

    private final int price;
    private final int fishingLevelNeeded;

    FishingPoleType(int price, int fishingLevelNeeded) {
        this.price = price;
        this.fishingLevelNeeded = fishingLevelNeeded;
    }

    public int getPrice() {
        return price;
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
}
