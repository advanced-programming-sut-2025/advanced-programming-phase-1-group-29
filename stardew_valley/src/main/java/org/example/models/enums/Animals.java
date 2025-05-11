package org.example.models.enums;

public enum Animals {
    Chicken (800),
    Duck (1200),
    Rabbit (8000),
    Dinosaur (14000),
    Cow (1500),
    Goat (4000),
    sheep (8000),
    Pig (16000),
    ;

    private final int price;

    private Animals(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
