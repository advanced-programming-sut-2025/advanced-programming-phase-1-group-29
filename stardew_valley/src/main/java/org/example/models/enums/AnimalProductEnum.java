package org.example.models.enums;

public enum AnimalProductEnum {
    Egg (50),
    BigEgg (95),
    DuckEgg (95),
    DuckFeather (250),
    Wool (340),
    RabbitPie (565),
    DinosaurEgg (350),
    Milk (125),
    BigMilk (190),
    GoatMilk (225),
    BigGoatMilk (345),
    Truffle (625),
    ;

    private final int price;

    private AnimalProductEnum(int price) {
        this.price = price;
    }
}
