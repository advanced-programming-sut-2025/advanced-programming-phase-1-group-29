package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum AnimalEnum {
    Chicken (800,
            new ArrayList<>(List.of(AnimalProductEnum.Egg, AnimalProductEnum.BigEgg)),
            AnimalHouse.COOP
    ),
    Duck (1200,
            new ArrayList<>(List.of(AnimalProductEnum.DuckEgg, AnimalProductEnum.DuckFeather)),
            AnimalHouse.COOP
    ),
    Rabbit (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool, AnimalProductEnum.RabbitPie)),
            AnimalHouse.COOP
    ),
    Dinosaur (14000,
            new ArrayList<>(List.of(AnimalProductEnum.DinosaurEgg)),
            AnimalHouse.COOP
    ),
    Cow (1500,
            new ArrayList<>(List.of(AnimalProductEnum.Milk, AnimalProductEnum.BigMilk)),
            AnimalHouse.BARN
    ),
    Goat (4000,
            new ArrayList<>(List.of(AnimalProductEnum.GoatMilk, AnimalProductEnum.BigGoatMilk)),
            AnimalHouse.BARN
    ),
    sheep (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool)),
            AnimalHouse.BARN
    ),
    Pig (16000,
            new ArrayList<>(List.of(AnimalProductEnum.Truffle)),
            AnimalHouse.BARN
    );

    private final int price;
    private final ArrayList<AnimalProductEnum> products;
    private final AnimalHouse houseType;

    AnimalEnum(int price, ArrayList<AnimalProductEnum> products, AnimalHouse houseType) {
        this.price = price;
        this.products = products;
        this.houseType = houseType;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<AnimalProductEnum> getProducts() {
        return products;
    }

    public AnimalHouse getHouseType() {
        return houseType;
    }
}
