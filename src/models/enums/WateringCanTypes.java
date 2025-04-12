package models.enums;

public enum WateringCanTypes {
    Basic(40, 5),
    Copper(55, 4),
    Iron(70, 3),
    Gold(85, 2),
    Iridium(100, 1);

    private final int capacity;
    private int energyConsumption;

    WateringCanTypes(int capacity, int energyConsumption) {
        this.capacity = capacity;
        this.energyConsumption = energyConsumption;
    }
}
