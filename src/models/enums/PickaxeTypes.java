package models.enums;

public enum PickaxeTypes {
    Copper(4),
    Iron(3),
    Gold(2),
    Iridium(1);

    private final int energyConsumption;

    PickaxeTypes(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
