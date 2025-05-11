package org.example.models.enums;

public enum FruitEnum {
    ;
    private final String name;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final Integer energy;

    FruitEnum(String name, int baseSellPrice, boolean isEdible, Integer energy) {
        this.name = name;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
    }
}
