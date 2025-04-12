package models.enums;

public enum FishingPoleTypes {
    Training(25, 8),
    Bamboo(500, 8),
    FiberGlass(1800, 6),
    Iridium(7500, 4);

    private final int price;
    private int energyConsumption;

    FishingPoleTypes(int price, int energyConsumption) {
        this.price = price;
        this.energyConsumption = energyConsumption;
    }
}
