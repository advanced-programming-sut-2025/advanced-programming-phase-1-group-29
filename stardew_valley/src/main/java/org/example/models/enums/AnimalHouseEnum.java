package org.example.models.enums;

public enum AnimalHouseEnum {
    Barn ("Barn", 4),
    BigBarn ("Big Barn", 8),
    DeluxeBarn ("Deluxe Barn", 12),
    Coop ("Coop", 4),
    BigCoop ("Big Coop", 8),
    DeluxeCoop ("Deluxe Coop", 12),
    ;

    private final String name;
    private final  int capacity;

    private AnimalHouseEnum(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
