package org.example.models.enums;

public enum AnimalProductEnum {
    Egg ("Egg", 50),
    BigEgg ("Egg", 95),
    DuckEgg ("Duck egg", 95),
    DuckFeather ("Duck feather", 250),
    Wool ("Wool", 340),
    RabbitPie ("Rabbit pie", 565),
    DinosaurEgg ("Dinosaur egg", 350),
    Milk ("Milk", 125),
    BigMilk ("Milk", 190),
    GoatMilk ("Goat milk", 225),
    BigGoatMilk ("Goat milk", 345),
    Truffle ("Truffle", 625),
    ;

    private final String name;
    private final int price;

    private AnimalProductEnum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
