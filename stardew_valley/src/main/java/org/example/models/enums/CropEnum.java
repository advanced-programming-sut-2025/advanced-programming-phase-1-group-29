package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum CropEnum {
    BlueJazz(
            "Blue Jazz", SeedEnum.JazzSeed, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 50, true,
            45, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Carrot(
            "Carrot", SeedEnum.CarrotSeed, new ArrayList<>(List.of(1, 1, 1)), 3,
            true, null, 35, true,
            75, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Cauliflower(
            "Cauliflower", SeedEnum.CauliflowerSeed, new ArrayList<>(List.of(1, 2, 4, 4, 1)), 12,
            true, null, 175, true,
            75, new ArrayList<>(List.of(Season.SPRING)), true
    ),
    CoffeeBean(
            "Coffee Bean", SeedEnum.CoffeeBean, new ArrayList<>(List.of(1, 2, 2, 3, 2)), 10,
            false, 2, 15, false,
            null, new ArrayList<>(List.of(Season.SPRING, Season.SUMMER)), false
    ),
    Garlic(
            "Garlic", SeedEnum.GarlicSeed, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 60, true,
            20, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    GreenBean(
            "Green Bean", SeedEnum.BeanStarter, new ArrayList<>(List.of(1, 1, 1, 3, 4)), 10,
            false, 3, 40, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Kale(
            "Kale", SeedEnum.KaleSeed, new ArrayList<>(List.of(1, 2, 2, 1)), 6,
            true, null, 110, true,
            50, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Parsnip(
            "Parsnip", SeedEnum.ParsnipSeed, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 35, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Potato(
            "Potato", SeedEnum.PotatoSeed, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            true, null, 80, true,
            25, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Rhubarb(
            "Rhubarb", SeedEnum.RhubarbSeed, new ArrayList<>(List.of(2, 2, 2, 3, 4)), 13,
            true, null, 220, false,
            null, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Strawberry(
            "Strawberry", SeedEnum.StrawberrySeed, new ArrayList<>(List.of(1, 1, 2, 2, 2)), 8,
            false, 4, 120, true,
            50, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Tulip(
            "Tulip", SeedEnum.TulipBulb, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 30, true,
            45, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    UnmilledRice(
            "Unmilled Rice", SeedEnum.RiceShoot, new ArrayList<>(List.of(1, 2, 2, 3)), 8,
            true, null, 30, true,
            3, new ArrayList<>(List.of(Season.SPRING)), false
    ),
    Blueberry(
            "Blueberry", SeedEnum.BlueberrySeed, new ArrayList<>(List.of(1, 3, 3, 4, 2)), 13,
            false, 4, 50, true,
            25, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Corn(
            "Corn", SeedEnum.CornSeed, new ArrayList<>(List.of(2, 3, 3, 3, 3)), 14,
            false, 4, 50, true,
            25, new ArrayList<>(List.of(Season.SPRING, Season.AUTUMN)), false
    ),
    Hops(
            "Hops", SeedEnum.HopsStarter, new ArrayList<>(List.of(1, 1, 2, 3, 4)), 11,
            false, 1, 25, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    HotPepper(
            "Hot Pepper", SeedEnum.PepperSeed, new ArrayList<>(List.of(1, 1, 1, 1, 1)), 5,
            false, 3, 40, true,
            13, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Melon(
            "Melon", SeedEnum.MelonSeed, new ArrayList<>(List.of(1, 2, 3, 3, 3)), 12,
            true, null, 250, true,
            113, new ArrayList<>(List.of(Season.SUMMER)), true
    ),
    Poppy(
            "Poppy", SeedEnum.PoppySeed, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 140, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Radish(
            "Radish", SeedEnum.RadishSeed, new ArrayList<>(List.of(2, 1, 2, 1)), 6,
            true, null, 90, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    RedCabbage(
            "Red Cabbage", SeedEnum.RedCabbageSeed, new ArrayList<>(List.of(2, 1, 2, 2, 2)), 9,
            true, null, 260, true,
            75, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Starfruit(
            "Starfruit", SeedEnum.StarfruitSeed, new ArrayList<>(List.of(2, 3, 2, 3, 3)), 13,
            true, null, 750, true,
            125, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    SummerSpangle(
            "Summer Spangle", SeedEnum.SpangleSeed, new ArrayList<>(List.of(1, 2, 3, 1)), 7,
            true, null, 90, true,
            45, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    SummerSquash(
            "Summer Squash", SeedEnum.SummerSquashSeed, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            false, 3, 45, true,
            63, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Sunflower(
            "Sunflower", SeedEnum.SunflowerSeed, new ArrayList<>(List.of(1, 2, 3, 2)), 8,
            true, null, 80, true,
            45, new ArrayList<>(List.of(Season.SUMMER, Season.AUTUMN)), false
    ),
    Tomato(
            "Tomato", SeedEnum.TomatoSeed, new ArrayList<>(List.of(2, 2, 2, 2, 3)), 11,
            false, 4, 60, true,
            20, new ArrayList<>(List.of(Season.SUMMER)), false
    ),
    Wheat(
            "Wheat", SeedEnum.WheatSeed, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 25, false,
            null, new ArrayList<>(List.of(Season.SUMMER, Season.AUTUMN)), false
    ),
    Amaranth(
            "Amaranth", SeedEnum.AmaranthSeed, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 150, true,
            50, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Artichoke(
            "Artichoke", SeedEnum.ArtichokeSeed, new ArrayList<>(List.of(2, 2, 1, 2, 1)), 8,
            true, null, 160, true,
            30, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Beet(
            "Beet", SeedEnum.BeetSeed, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 100, true,
            30, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    BokChoy(
            "Bok Choy", SeedEnum.BokChoySeed, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 80, true,
            25, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Broccoli(
            "Broccoli", SeedEnum.BroccoliSeed, new ArrayList<>(List.of(2, 2, 2, 2)), 8,
            false, 4, 70, true,
            63, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
   Cranberry(
            "Cranberry", SeedEnum.CranberrySeed, new ArrayList<>(List.of(1, 2, 1, 1, 2)), 7,
            false, 5, 75, true,
            38, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Eggplant(
            "Eggplant", SeedEnum.EggplantSeed, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            false, 5, 60, true,
            20, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    FairyRose(
            "Fairy Rose", SeedEnum.FairySeed, new ArrayList<>(List.of(1, 4, 4, 3)), 12,
            true, null, 290, true,
            45, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Grape(
            "Grape", SeedEnum.GrapeStarter, new ArrayList<>(List.of(1, 1, 2, 3, 3)), 10,
            false, 3, 80, true,
            38, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    Pumpkin(
            "Pumpkin", SeedEnum.PumpkinSeed, new ArrayList<>(List.of(1, 2, 3, 4, 3)), 13,
            true, null, 320, false,
            null, new ArrayList<>(List.of(Season.AUTUMN)), true
    ),
    Yam(
            "Yam", SeedEnum.YamSeed, new ArrayList<>(List.of(1, 3, 3, 3)), 10,
            true, null, 160, true,
            45, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    SweetGemBerry(
            "Sweet Gem Berry", SeedEnum.RareSeed, new ArrayList<>(List.of(2, 4, 6, 6, 6)), 24,
            true, null, 3000, false,
            null, new ArrayList<>(List.of(Season.AUTUMN)), false
    ),
    PowderMelon(
            "Powder Melon", SeedEnum.PowderMelonSeed, new ArrayList<>(List.of(1, 2, 1, 2, 1)), 7,
            true, null, 60, true,
            63, new ArrayList<>(List.of(Season.WINTER)), true
    ),
    AncientFruit(
            "Ancient Fruit", SeedEnum.AncientSeed, new ArrayList<>(List.of(2, 7, 7, 7, 5)), 28,
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
