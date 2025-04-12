package models.enums;

public enum HoeTypes {
    Copper(4),
    Iron(3),
    Gold(2),
    Iridium(1);

    private int energyConsumption;

    HoeTypes(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
