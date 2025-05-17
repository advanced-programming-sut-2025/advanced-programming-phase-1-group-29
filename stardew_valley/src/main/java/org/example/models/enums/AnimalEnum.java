package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum AnimalEnum {
    Chicken (800,
            new ArrayList<>(List.of(AnimalProductEnum.Egg, AnimalProductEnum.BigEgg)),
            new ArrayList<>(List.of(AnimalHouseEnum.Coop, AnimalHouseEnum.BigCoop, AnimalHouseEnum.DeluxeCoop))
    ),
    Duck (1200,
            new ArrayList<>(List.of(AnimalProductEnum.DuckEgg, AnimalProductEnum.DuckFeather)),
            new ArrayList<>(List.of(AnimalHouseEnum.BigCoop, AnimalHouseEnum.DeluxeCoop))
    ),
    Rabbit (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool, AnimalProductEnum.RabbitPie)),
            new ArrayList<>(List.of(AnimalHouseEnum.DeluxeCoop))
    ),
    Dinosaur (14000,
            new ArrayList<>(List.of(AnimalProductEnum.DinosaurEgg)),
            new ArrayList<>(List.of(AnimalHouseEnum.BigCoop, AnimalHouseEnum.DeluxeCoop))
    ),
    Cow (1500,
            new ArrayList<>(List.of(AnimalProductEnum.Milk, AnimalProductEnum.BigMilk)),
            new ArrayList<>(List.of(AnimalHouseEnum.Barn, AnimalHouseEnum.BigBarn, AnimalHouseEnum.DeluxeBarn))
    ),
    Goat (4000,
            new ArrayList<>(List.of(AnimalProductEnum.GoatMilk, AnimalProductEnum.BigGoatMilk)),
            new ArrayList<>(List.of(AnimalHouseEnum.BigBarn, AnimalHouseEnum.DeluxeBarn))
    ),
    sheep (8000,
            new ArrayList<>(List.of(AnimalProductEnum.Wool)),
            new ArrayList<>(List.of(AnimalHouseEnum.DeluxeBarn))
    ),
    Pig (16000,
            new ArrayList<>(List.of(AnimalProductEnum.Truffle)),
            new ArrayList<>(List.of(AnimalHouseEnum.DeluxeBarn))
    );

    private final int price;
    private final ArrayList<AnimalProductEnum> products;
    private final ArrayList<AnimalHouseEnum> houseTypes;

    AnimalEnum(int price, ArrayList<AnimalProductEnum> products, ArrayList<AnimalHouseEnum> houseType) {
        this.price = price;
        this.products = products;
        this.houseTypes = houseType;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<AnimalProductEnum> getProducts() {
        return products;
    }

    public static AnimalEnum getByName(String animalName) {
        for (AnimalEnum animalEnum : AnimalEnum.values()) {
            if(animalEnum.toString().equalsIgnoreCase(animalName)) {
                return animalEnum;
            }
        }
        return null;
    }

    public ArrayList<AnimalHouseEnum> getHouseTypes() {
        return houseTypes;
    }
}
