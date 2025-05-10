package org.example.models.enums;

import java.util.ArrayList;

public enum Food {
    FriedEgg ("Fried egg", 50, 35),
    BakedFish ("Baked Fish", 75, 100),
    Salad ("Salad", 113, 110),
    Omelet ("Omelet", 100, 125),
    PumpkinPie ("pumpkin pie", 225, 385),
    Spaghetti ("spaghetti", 75, 120),
    Pizza ("pizza", 150, 300),
    Tortilla ("Tortilla", 50, 50),
    MakiRoll ("Maki Roll", 100, 220),
    TripleShotEspresso ("Triple Shot Espresso", 200, 450),
    Cookie ("Cookie", 90, 140),
    HashBrowns ("hash browns", 90, 120),
    Pancakes ("pancakes", 90, 80),
    FruitSalad ("fruit salad", 263, 450),
    RedPlate ("red plate", 240, 400),
    Bread ("bread", 50, 60),
    SalmonDinner ("salmon dinner", 125, 300),
    VegetableMedley ("vegetable medley ", 165, 120),
    FarmersLunch ("farmer's lunch", 200, 150),
    SurvivalBurger ("survival burger", 125, 180),
    DishOfTheSea ("dish O' the Sea", 150, 220),
    SeaFormPudding ("seaform Pudding", 175, 300),
    minersTreat ("miner's treat", 125, 200),
    ;

    private final String name;
    private final int energy;
    private final int sellPrice;
    //private final ArrayList<Food> ingridients;


    Food(String  name, int energy, int sellPrice) {
        this.name = name;
        this.energy = energy;
        this.sellPrice = sellPrice;
    }
}
