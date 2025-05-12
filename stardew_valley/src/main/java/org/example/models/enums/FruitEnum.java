package org.example.models.enums;

public enum FruitEnum {
    APRICOT("Apricot", 59, true, 38),
    CHERRY("Cherry", 80, true, 38),
    BANANA("Banana", 150, true, 75),
    MANGO("Mango", 130, true, 100),
    ORANGE("Orange", 100, true, 38),
    PEACH("Peach", 140, true, 38),
    APPLE("Apple", 100, true, 38),
    POMEGRANATE("Pomegranate", 140, true, 38),
    OAKRESIN("Oak Resin", 150, false, null),
    MAPLESYRUP("Maple Syrup", 200, false, null),
    PINETAR("Pine Tar", 100, false, null),
    SAP("Sap", 2, true, -2),
    COMMONMUSHROOM("Common Mushroom", 40, true, 38),
    MYSTICSYRUP("Mystic Syrup", 1000, true, 500);
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

    public String getName() {
        return name;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public Integer getEnergy() {
        return energy;
    }
}
