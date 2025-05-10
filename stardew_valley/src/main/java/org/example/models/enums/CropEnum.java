package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum CropEnum {
    BLUE_JAZZ(
            "Blue Jazz", SeedEnum.JAZZ_SEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 50, true,
            45, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    CARROT(
            "Carrot", SeedEnum.CARROT_SEED, new ArrayList<>(List.of(1, 1, 1)), 3,
            true, null, 35, true,
            75, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    CAULIFLOWER(
            "Cauliflower", SeedEnum.CAULIFLOWER_SEED, new ArrayList<>(List.of(1, 2, 4, 4, 1)), 12,
            true, null, 175, true,
            75, new ArrayList<>(List.of(Season.SPRING)), true
    ),
    COFFEE_BEAN(
            "Coffee Bean", SeedEnum.COFFEE_BEAN, new ArrayList<>(List.of(1, 2, 2, 3, 2)), 10,
            false, 2, 15, false,
            null, new ArrayList<>(List.of(Season.SPRING, Season.SUMMER)), false
    ),
    GARLIC(
            "Garlic", SeedEnum.GARLIC_SEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 60, true,
            20, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    GREEN_BEAN(
            "Green Bean", SeedEnum.BEAN_STARTER, new ArrayList<>(List.of(1, 1, 1, 3, 4)), 10,
            false, 3, 40, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    KALE(
            "Kale", SeedEnum.KALE_SEED, new ArrayList<>(List.of(1, 2, 2, 1)), 6,
            true, null, 110, true,
            50, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    PARSNIP(
            "Parsnip", SeedEnum.PARSNIP_SEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 35, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    POTATO(
            "Potato", SeedEnum.POTATO_SEED, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            true, null, 80, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    RHUBARB(
            "Rhubarb", SeedEnum.RHUBARB_SEED, new ArrayList<>(List.of(2, 2, 2, 3, 4)), 13,
            true, null, 220, false,
            null, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    STRAWBERRY(
            "Strawberry", SeedEnum.STRAWBERRY_SEED, new ArrayList<>(List.of(1, 1, 2, 2, 2)), 8,
            false, 4, 120, true,
            50, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    TULIP(
            "Tulip", SeedEnum.TULIP_BULB, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 30, true,
            45, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    UNMILLED_RICE(
            "Unmilled Rice", SeedEnum.RICE_SHOOT, new ArrayList<>(List.of(1, 2, 2, 3)), 8,
            true, null, 30, true,
            3, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    BLUEBERRY(
            "Blueberry", SeedEnum.BLUEBERRY_SEED, new ArrayList<>(List.of(1, 3, 3, 4, 2)), 13,
            false, 4, 50, true,
            25, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    CORN(
            "Corn", SeedEnum.CORN_SEED, new ArrayList<>(List.of(2, 3, 3, 3, 3)), 14,
            false, 4, 50, true,
            25, new ArrayList<>(List.of(Season.SPRING, Season.AUTUMN)), false
    ),
    HOPS(
            "Hops", SeedEnum.HOPS_STARTER, new ArrayList<>(List.of(1, 1, 2, 3, 4)), 11,
            false, 1, 25, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    HOT_PEPPER(
            "Hot Pepper", SeedEnum.PEPPER_SEED, new ArrayList<>(List.of(1, 1, 1, 1, 1)), 5,
            false, 3, 40, true,
            13, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    MELON(
            "Melon", SeedEnum.MELON_SEED, new ArrayList<>(List.of(1, 2, 3, 3, 3)), 12,
            true, null, 250, true,
            113, new ArrayList<>(List.of(Season.SUMMER)), true
    ),
    POPPY(
            "Poppy", SeedEnum.POPPY_SEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 140, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    RADISH(
            "Radish", SeedEnum.RADISH_SEED, new ArrayList<>(List.of(2, 1, 2, 1)), 6,
            true, null, 90, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    RED_CABBAGE(
            "Red Cabbage", SeedEnum.RED_CABBAGE_SEED, new ArrayList<>(List.of(2, 1, 2, 2, 2)), 9,
            true, null, 260, true,
            75, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    STARFRUIT(
            "Starfruit", SeedEnum.STARFRUIT_SEED, new ArrayList<>(List.of(2, 3, 2, 3, 3)), 13,
            true, null, 750, true,
            125, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    SUMMER_SPANGLE(
            "Summer Spangle", SeedEnum.SPANGLE_SEED, new ArrayList<>(List.of(1, 2, 3, 1)), 7,
            true, null, 90, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    SUMMER_SQUASH(
            "Summer Squash", SeedEnum.SUMMER_SQUASH_SEED, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            false, 3, 45, true,
            63, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    SUNFLOWER(
            "Sunflower", SeedEnum.SUNFLOWER_SEED, new ArrayList<>(List.of(1, 2, 3, 2)), 8,
            true, null, 80, true,
            45, new ArrayList<>(List.of(Season.SUMMER, Season.AUTUMN)), false
    ),
    TOMATO(
            "Tomato", SeedEnum.TOMATO_SEED, new ArrayList<>(List.of(2, 2, 2, 2, 3)), 11,
            false, 4, 60, true,
            20, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    WHEAT(
            "Wheat", SeedEnum.WHEAT_SEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 25, false,
            null, new ArrayList<>(List.of(Season.SUMMER, Season.AUTUMN)), false
    ),
    AMARANTH(
            "Amaranth", SeedEnum.AMARANTH_SEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 150, true,
            50, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    ARTICHOKE(
            "Artichoke", SeedEnum.ARTICHOKE_SEED, new ArrayList<>(List.of(2, 2, 1, 2, 1)), 8,
            true, null, 160, true,
            30, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    BEET(
            "Beet", SeedEnum.BEET_SEED, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 100, true,
            30, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    BOK_CHOY(
            "Bok Choy", SeedEnum.BOK_CHOY_SEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 80, true,
            25, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    BROCCOLI(
            "Broccoli", SeedEnum.BROCCOLI_SEED, new ArrayList<>(List.of(2, 2, 2, 2)), 8,
            false, 4, 70, true,
            63, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
   CRANBERRY(
            "Cranberry", SeedEnum.CRANBERRY_SEED, new ArrayList<>(List.of(1, 2, 1, 1, 2)), 7,
            false, 5, 75, true,
            38, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    EGGPLANT(
            "Eggplant", SeedEnum.EGGPLANT_SEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            false, 5, 60, true,
            20, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    FAIRY_ROSE(
            "Fairy Rose", SeedEnum.FAIRY_SEED, new ArrayList<>(List.of(1, 4, 4, 3)), 12,
            true, null, 290, true,
            45, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    GRAPE(
            "Grape", SeedEnum.GRAPE_STARTER, new ArrayList<>(List.of(1, 1, 2, 3, 3)), 10,
            false, 3, 80, true,
            38, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    PUMPKIN(
            "Pumpkin", SeedEnum.PUMPKIN_SEED, new ArrayList<>(List.of(1, 2, 3, 4, 3)), 13,
            true, null, 320, false,
            null, new ArrayList<>(List.of(Season.AUTUMN)), true
    ),
    YAM(
            "Yam", SeedEnum.YAM_SEED, new ArrayList<>(List.of(1, 3, 3, 3)), 10,
            true, null, 160, true,
            45, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    SWEET_GEM_BERRY(
            "Sweet Gem Berry", SeedEnum.RARE_SEED, new ArrayList<>(List.of(2, 4, 6, 6, 6)), 24,
            true, null, 3000, false,
            null, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    POWDER_MELON(
            "Powder Melon", SeedEnum.POWDER_MELON_SEED, new ArrayList<>(List.of(1, 2, 1, 2, 1)), 7,
            true, null, 60, true,
            63, new ArrayList<>(List.of(Season.WINTER)), true
    ),
    ANCIENT_FRUIT(
            "Ancient Fruit", SeedEnum.ANCIENT_SEED, new ArrayList<>(List.of(2, 7, 7, 7, 5)), 28,
            false, 7, 550, false,
            null, new ArrayList<>(List.of(Season.SPRING, Season.SUMMER, Season.AUTUMN)), false
    );
    private final String name;
    private final SeedEnum source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final boolean oneTimeHarvest;
    private final Integer regrowthTime;
    private final int bestSellPrice;
    private final boolean isEdible;
    private final Integer energy;
    private final ArrayList<Season> seasons;
    private final boolean canBecomeGiant;

    CropEnum(
            String name, SeedEnum source, ArrayList<Integer> stages, int totalHarvestTime,
            boolean oneTimeHarvest, Integer regrowthTime, int bestSellPrice, boolean isEdible,
            Integer energy, ArrayList<Season> seasons, boolean canBecomeGiant
    ) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTimeHarvest = oneTimeHarvest;
        this.regrowthTime = regrowthTime;
        this.bestSellPrice = bestSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        this.seasons = seasons;
        this.canBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }

    public SeedEnum getSource() {
        return source;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public boolean isOneTimeHarvest() {
        return oneTimeHarvest;
    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public int getBestSellPrice() {
        return bestSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getEnergy() {
        return energy;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public boolean isCanBecomeGiant() {
        return canBecomeGiant;
    }
}
