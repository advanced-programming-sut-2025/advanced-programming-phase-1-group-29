package org.example.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum CraftingItemEnum {
    CherryBomb("",
            new HashMap<>(Map.of(
                    "CopperOre", 4,
                    "Coal", 1))),
    Bomb("",
            new HashMap<>(Map.of(
                    "IronOre", 4,
                    "Coal", 1))),
    MegaBomb("",
            new HashMap<>(Map.of(
                    "GoldOre", 4,
                    "Coal", 1))),
    Sprinkler("",
            new HashMap<>(Map.of(
                    "CopperBar", 1,
                    "IronBar", 1))),
    QualitySprinkler("",
            new HashMap<>(Map.of(
                    "IronBar", 1,
                    "GoldBar", 1))),
    IridiumSprinkler("",
            new HashMap<>(Map.of(
                    "GoldBar", 1,
                    "IridiumBar", 1))),
    CharcoalKlin("",
            new HashMap<>(Map.of(
                    "Wood", 20,
                    "CopperBar", 2))),
    Furnace("",
            new HashMap<>(Map.of(
                    "CopperOre", 20,
                    "Stone", 25))),
    Scarecrow("",
            new HashMap<>(Map.of(
                    "Wood", 50,
                    "Coal", 1,
                    "Fiber", 20))),
    DeluxeScarecrow("",
            new HashMap<>(Map.of(
                    "Wood", 50,
                    "Coal", 1,
                    "Fiber", 20,
                    "IridiumOre", 1))),
    BeeHouse("",
            new HashMap<>(Map.of(
                    "Wood", 40,
                    "Coal", 8,
                    "IronBar", 1))),
    CheesePress("",
            new HashMap<>(Map.of(
                    "Wood", 45,
                    "Stone", 45,
                    "CopperBar", 1))),
    Keg("",
            new HashMap<>(Map.of(
                    "Wood", 30,
                    "CopperBar", 1,
                    "IronBar", 1))),
    Loom("",
            new HashMap<>(Map.of(
                    "Wood", 60,
                    "Fiber", 30))),
    MayonnaiseMachine("",
            new HashMap<>(Map.of(
                    "Wood", 15,
                    "Stone", 15,
                    "CopperBar", 1))),
    OilMaker("",
            new HashMap<>(Map.of(
                    "Wood", 100,
                    "GoldBar", 1,
                    "IronBar", 1))),
    PreservesJar("",
            new HashMap<>(Map.of(
                    "Wood", 50,
                    "Stone", 40,
                    "Coal", 8))),
    Dehydrator("",
            new HashMap<>(Map.of(
                    "Wood", 30,
                    "Stone", 20,
                    "Fiber", 30))),
    GrassStarter("",
            new HashMap<>(Map.of(
                    "Wood", 1,
                    "Fiber", 1))),
    FishSmoker("",
            new HashMap<>(Map.of(
                    "Wood", 50,
                    "IronBar", 3,
                    "Coal", 10))),
    MysticTreeSeed("",
            new HashMap<>(Map.of(
                    "Acorn", 5,
                    "MapleSeed", 5,
                    "PineCone", 5,
                    "MahoganySeed", 5)))
    ;

    private final String name;
    private final HashMap<String, Integer> ingredients;

    private CraftingItemEnum(String name, HashMap<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public static CraftingItemEnum getByName(String craftingItemName) {
        for (CraftingItemEnum item : CraftingItemEnum.values()) {
            if (item.toString().equalsIgnoreCase(craftingItemName)) {
                return item;
            }
        }
        return null;
    }
}
