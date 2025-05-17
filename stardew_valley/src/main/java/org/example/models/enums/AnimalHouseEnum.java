package org.example.models.enums;

public enum AnimalHouseEnum {
    Barn ("Barn", 4, 7, 4),
    BigBarn ("Big Barn", 8, 7, 4),
    DeluxeBarn ("Deluxe Barn", 12, 7, 4),
    Coop ("Coop", 4, 6, 3),
    BigCoop ("Big Coop", 8, 6, 3),
    DeluxeCoop ("Deluxe Coop", 12, 6, 3),
    ;

    private final String name;
    private final  int capacity;
    private final int xRange;
    private final int yRange;

    private AnimalHouseEnum(String name, int capacity, int xRange, int yRange) {
        this.name = name;
        this.capacity = capacity;
        this.xRange = xRange;
        this.yRange = yRange;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getXRange() {
        return xRange;
    }

    public int getYRange() {
        return yRange;
    }

    public static AnimalHouseEnum getByName(String animalHouseName) {
        for (AnimalHouseEnum animalHouseEnum : AnimalHouseEnum.values()) {
            if(animalHouseEnum.toString().equalsIgnoreCase(animalHouseName)) {
                return animalHouseEnum;
            }
        }
        return null;
    }
}
