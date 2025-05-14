package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum AnimalEnum {
    Chicken (800,
            new ArrayList<>(List.of(AnimalProductEnum.Egg, AnimalProductEnum.BigEgg))),
    Duck (1200,
            new ArrayList<>(List.of(AnimalProductEnum.DuckEgg, AnimalProductEnum.DuckFeather))),
    Rabbit (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool, AnimalProductEnum.RabbitPie))),
    Dinosaur (14000,
            new ArrayList<>(List.of(AnimalProductEnum.DinosaurEgg))),
    Cow (1500,
            new ArrayList<>(List.of(AnimalProductEnum.Milk, AnimalProductEnum.BigMilk))),
    Goat (4000,
            new ArrayList<>(List.of(AnimalProductEnum.GoatMilk, AnimalProductEnum.BigGoatMilk))),
    sheep (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool))),
    Pig (16000,
            new ArrayList<>(List.of(AnimalProductEnum.Truffle))),
    ;

    private final int price;
    private final ArrayList<AnimalProductEnum> products;

    private AnimalEnum(int price, ArrayList<AnimalProductEnum> products) {
        this.price = price;
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<AnimalProductEnum> getProducts() {
        return products;
    }
}
