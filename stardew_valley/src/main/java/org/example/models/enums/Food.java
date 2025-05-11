package org.example.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Food {
    FriedEgg ("Fried egg", 50, 35,
            new HashMap<>(Map.of("egg", 1))),
    BakedFish ("Baked Fish", 75, 100,
            new HashMap<>(Map.of(
                    "Sardine", 1,
                    "Salmon", 1,
                    "Wheat", 1
            ))),
    Salad ("Salad", 113, 110,
            new HashMap<>(Map.of(
                    "Leek", 1,
                    "Dandelion", 1
            ))),
    Omelet ("Omelet", 100, 125,
            new HashMap<>(Map.of(
                    "Egg", 1,
                    "Milk", 1
            ))),
    PumpkinPie ("pumpkin pie", 225, 385,
            new HashMap<>(Map.of(
                    "Pumpkin", 1,
                    "WheatFlour", 1,
                    "Milk", 1,
                    "Sugar", 1
            ))),
    Spaghetti ("spaghetti", 75, 120,
            new HashMap<>(Map.of(
                    "WheatFlour", 1,
                    "Tomato", 1
            ))),
    Pizza ("pizza", 150, 300,
            new HashMap<>(Map.of(
                    "WheatFlour", 1,
                    "Tomato", 1,
                    "Cheese", 1
            ))),
    Tortilla ("Tortilla", 50, 50,
            new HashMap<>(Map.of("Corn", 1))),
    MakiRoll ("Maki Roll", 100, 220,
            new HashMap<>(Map.of(
                    "AnyFish", 1,
                    "Rice", 1,
                    "Fiber", 1
            ))),
    TripleShotEspresso ("Triple Shot Espresso", 200, 450,
            new HashMap<>(Map.of("Coffee", 3))),
    Cookie ("Cookie", 90, 140,
            new HashMap<>(Map.of(
                    "WheatFlour", 1,
                    "Sugar", 1,
                    "Egg", 1
            ))),
    HashBrowns ("hash browns", 90, 120,
            new HashMap<>(Map.of(
                    "Potato", 1,
                    "Oil", 1
            ))),
    Pancakes ("pancakes", 90, 80,
            new HashMap<>(Map.of(
                    "WheatFlour", 1,
                    "Egg", 1
            ))),
    FruitSalad ("fruit salad", 263, 450,
            new HashMap<>(Map.of(
                    "Blueberry", 1,
                    "Melon", 1,
                    "Apricot", 1
            ))),
    RedPlate ("red plate", 240, 400,
            new HashMap<>(Map.of(
                    "RedCabbage", 1,
                    "Radish", 1
            ))),
    Bread ("bread", 50, 60,
            new HashMap<>(Map.of("WheatFlour", 1))),
    SalmonDinner ("salmon dinner", 125, 300,
            new HashMap<>(Map.of(
                    "Salmon", 1,
                    "Amaranth", 1,
                    "Kale", 1
            ))),
    VegetableMedley ("vegetable medley ", 165, 120,
            new HashMap<>(Map.of(
                    "Tomato", 1,
                    "Beet", 1
            ))),
    FarmersLunch ("farmer's lunch", 200, 150,
            new HashMap<>(Map.of(
                    "Omelet", 1,
                    "Parsnip", 1
            ))),
    SurvivalBurger ("survival burger", 125, 180,
            new HashMap<>(Map.of(
                    "Bread", 1,
                    "Carrot", 1,
                    "Eggplant", 1
            ))),

    DishOfTheSea ("dish O' the Sea", 150, 220,
            new HashMap<>(Map.of(
                    "Sardine", 2,
                    "HashBrowns", 1
            ))),
    SeaFormPudding ("seaform Pudding", 175, 300,
            new HashMap<>(Map.of(
                    "Flounder", 1,
                    "MidnightCarp", 1
            ))),
    MinersTreat ("miner's treat", 125, 200,
            new HashMap<>(Map.of(
                    "Carrot", 2,
                    "Sugar", 1,
                    "Milk", 1
            ))),
    ;

    private final String name;
    private final int energy;
    private final int sellPrice;
    private final HashMap<String, Integer> ingredients;


    Food(String  name, int energy, int sellPrice, HashMap<String, Integer> ingredients) {
        this.name = name;
        this.energy = energy;
        this.sellPrice = sellPrice;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public static Food getByName(String foodName) {
        for (Food food : Food.values()) {
            if(food.getName().equals(foodName)){
                return food;
            }
        }
        return null;
    }
}
