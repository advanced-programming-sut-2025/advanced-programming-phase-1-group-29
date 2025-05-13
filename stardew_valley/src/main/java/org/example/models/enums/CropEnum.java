package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum CropEnum {
    BLUEJAZZ(
            "Blue Jazz", CropSeedEnum.JAZZSEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 50, true,
            45, new ArrayList<>(List.of("Spring")), false
    ),
    CARROT(
            "Carrot", CropSeedEnum.CARROTSEED, new ArrayList<>(List.of(1, 1, 1)), 3,
            true, null, 35, true,
            75, new ArrayList<>(List.of("Spring")), false
    ),
    CAULIFLOWER(
            "Cauliflower", CropSeedEnum.CAULIFLOWERSEED, new ArrayList<>(List.of(1, 2, 4, 4, 1)), 12,
            true, null, 175, true,
            75, new ArrayList<>(List.of("Spring")), true
    ),
    COFFEEBEAN(
            "Coffee Bean", CropSeedEnum.COFFEEBEAN, new ArrayList<>(List.of(1, 2, 2, 3, 2)), 10,
            false, 2, 15, false,
            null, new ArrayList<>(List.of("Spring", "Summer")), false
    ),
    GARLIC(
            "Garlic", CropSeedEnum.GARLICSEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 60, true,
            20, new ArrayList<>(List.of("Spring")), false
    ),
    GREENBEAN(
            "Green Bean", CropSeedEnum.BEANSTARTER, new ArrayList<>(List.of(1, 1, 1, 3, 4)), 10,
            false, 3, 40, true,
            25, new ArrayList<>(List.of("Spring")), false
    ),
    KALE(
            "Kale", CropSeedEnum.KALESEED, new ArrayList<>(List.of(1, 2, 2, 1)), 6,
            true, null, 110, true,
            50, new ArrayList<>(List.of("Spring")), false
    ),
    PARSNIP(
            "Parsnip", CropSeedEnum.PARSNIPSEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 35, true,
            25, new ArrayList<>(List.of("Spring")), false
    ),
    POTATO(
            "Potato", CropSeedEnum.POTATOSEED, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            true, null, 80, true,
            25, new ArrayList<>(List.of("Spring")), false
    ),
    RHUBARB(
            "Rhubarb", CropSeedEnum.RHUBARBSEED, new ArrayList<>(List.of(2, 2, 2, 3, 4)), 13,
            true, null, 220, false,
            null, new ArrayList<>(List.of("Spring")), false
    ),
    STRAWBERRY(
            "Strawberry", CropSeedEnum.STRAWBERRYSEED, new ArrayList<>(List.of(1, 1, 2, 2, 2)), 8,
            false, 4, 120, true,
            50, new ArrayList<>(List.of("Spring")), false
    ),
    TULIP(
            "Tulip", CropSeedEnum.TULIPBULB, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 30, true,
            45, new ArrayList<>(List.of("Spring")), false
    ),
    UNMILLEDRICE(
            "Unmilled Rice", CropSeedEnum.RICESHOOT, new ArrayList<>(List.of(1, 2, 2, 3)), 8,
            true, null, 30, true,
            3, new ArrayList<>(List.of("Spring")), false
    ),
    BLUEBERRY(
            "Blueberry", CropSeedEnum.BLUEBERRYSEED, new ArrayList<>(List.of(1, 3, 3, 4, 2)), 13,
            false, 4, 50, true,
            25, new ArrayList<>(List.of("Summer")), false
    ),
    CORN(
            "Corn", CropSeedEnum.CORNSEED, new ArrayList<>(List.of(2, 3, 3, 3, 3)), 14,
            false, 4, 50, true,
            25, new ArrayList<>(List.of("Summer", "Fall")), false
    ),
    HOPS(
            "Hops", CropSeedEnum.HOPSSTARTER, new ArrayList<>(List.of(1, 1, 2, 3, 4)), 11,
            false, 1, 25, true,
            45, new ArrayList<>(List.of("Summer")), false
    ),
    HOTPEPPER(
            "Hot Pepper", CropSeedEnum.PEPPERSEED, new ArrayList<>(List.of(1, 1, 1, 1, 1)), 5,
            false, 3, 40, true,
            13, new ArrayList<>(List.of("Summer")), false
    ),
    MELON(
            "Melon", CropSeedEnum.MELONSEED, new ArrayList<>(List.of(1, 2, 3, 3, 3)), 12,
            true, null, 250, true,
            113, new ArrayList<>(List.of("Summer")), true
    ),
    POPPY(
            "Poppy", CropSeedEnum.POPPYSEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 140, true,
            45, new ArrayList<>(List.of("Summer")), false
    ),
    RADISH(
            "Radish", CropSeedEnum.RADISHSEED, new ArrayList<>(List.of(2, 1, 2, 1)), 6,
            true, null, 90, true,
            45, new ArrayList<>(List.of("Summer")), false
    ),
    REDCABBAGE(
            "Red Cabbage", CropSeedEnum.REDCABBAGESEED, new ArrayList<>(List.of(2, 1, 2, 2, 2)), 9,
            true, null, 260, true,
            75, new ArrayList<>(List.of("Summer")), false
    ),
    STARFRUIT(
            "Starfruit", CropSeedEnum.STARFRUITSEED, new ArrayList<>(List.of(2, 3, 2, 3, 3)), 13,
            true, null, 750, true,
            125, new ArrayList<>(List.of("Summer")), false
    ),
    SUMMERSPANGLE(
            "Summer Spangle", CropSeedEnum.SPANGLESEED, new ArrayList<>(List.of(1, 2, 3, 1)), 7,
            true, null, 90, true,
            45, new ArrayList<>(List.of("Summer")), false
    ),
    SUMMERSQUASH(
            "Summer Squash", CropSeedEnum.SUMMERSQUASHSEED, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6,
            false, 3, 45, true,
            63, new ArrayList<>(List.of("Summer")), false
    ),
    SUNFLOWER(
            "Sunflower", CropSeedEnum.SUNFLOWERSEED, new ArrayList<>(List.of(1, 2, 3, 2)), 8,
            true, null, 80, true,
            45, new ArrayList<>(List.of("Summer", "Fall")), false
    ),
    TOMATO(
            "Tomato", CropSeedEnum.TOMATOSEED, new ArrayList<>(List.of(2, 2, 2, 2, 3)), 11,
            false, 4, 60, true,
            20, new ArrayList<>(List.of("Summer")), false
    ),
    WHEAT(
            "Wheat", CropSeedEnum.WHEATSEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 25, false,
            null, new ArrayList<>(List.of("Summer", "Fall")), false
    ),
    AMARANTH(
            "Amaranth", CropSeedEnum.AMARANTHSEED, new ArrayList<>(List.of(1, 2, 2, 2)), 7,
            true, null, 150, true,
            50, new ArrayList<>(List.of("Fall")), false
    ),
    ARTICHOKE(
            "Artichoke", CropSeedEnum.ARTICHOKESEED, new ArrayList<>(List.of(2, 2, 1, 2, 1)), 8,
            true, null, 160, true,
            30, new ArrayList<>(List.of("Fall")), false
    ),
    BEET(
            "Beet", CropSeedEnum.BEETSEED, new ArrayList<>(List.of(1, 1, 2, 2)), 6,
            true, null, 100, true,
            30, new ArrayList<>(List.of("Fall")), false
    ),
    BOKCHOY(
            "Bok Choy", CropSeedEnum.BOKCHOYSEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            true, null, 80, true,
            25, new ArrayList<>(List.of("Fall")), false
    ),
    BROCCOLI(
            "Broccoli", CropSeedEnum.BROCCOLISEED, new ArrayList<>(List.of(2, 2, 2, 2)), 8,
            false, 4, 70, true,
            63, new ArrayList<>(List.of("Fall")), false
    ),
   CRANBERRY(
            "Cranberry", CropSeedEnum.CRANBERRYSEED, new ArrayList<>(List.of(1, 2, 1, 1, 2)), 7,
            false, 5, 75, true,
            38, new ArrayList<>(List.of("Fall")), false
    ),
    EGGPLANT(
            "Eggplant", CropSeedEnum.EGGPLANTSEED, new ArrayList<>(List.of(1, 1, 1, 1)), 4,
            false, 5, 60, true,
            20, new ArrayList<>(List.of("Fall")), false
    ),
    FAIRYROSE(
            "Fairy Rose", CropSeedEnum.FAIRYSEED, new ArrayList<>(List.of(1, 4, 4, 3)), 12,
            true, null, 290, true,
            45, new ArrayList<>(List.of("Fall")), false
    ),
    GRAPE(
            "Grape", CropSeedEnum.GRAPESTARTER, new ArrayList<>(List.of(1, 1, 2, 3, 3)), 10,
            false, 3, 80, true,
            38, new ArrayList<>(List.of("Fall")), false
    ),
    PUMPKIN(
            "Pumpkin", CropSeedEnum.PUMPKINSEED, new ArrayList<>(List.of(1, 2, 3, 4, 3)), 13,
            true, null, 320, false,
            null, new ArrayList<>(List.of("Fall")), true
    ),
    YAM(
            "Yam", CropSeedEnum.YAMSEED, new ArrayList<>(List.of(1, 3, 3, 3)), 10,
            true, null, 160, true,
            45, new ArrayList<>(List.of("Fall")), false
    ),
    SWEETGEMBERRY(
            "Sweet Gem Berry", CropSeedEnum.RARESEED, new ArrayList<>(List.of(2, 4, 6, 6, 6)), 24,
            true, null, 3000, false,
            null, new ArrayList<>(List.of("Fall")), false
    ),
    POWDERMELON(
            "Powder Melon", CropSeedEnum.POWDERMELONSEED, new ArrayList<>(List.of(1, 2, 1, 2, 1)), 7,
            true, null, 60, true,
            63, new ArrayList<>(List.of("Winter")), true
    ),
    ANCIENTFRUIT(
            "Ancient Fruit", CropSeedEnum.ANCIENTSEED, new ArrayList<>(List.of(2, 7, 7, 7, 5)), 28,
            false, 7, 550, false,
            null, new ArrayList<>(List.of("Spring", "Summer", "Fall")), false
    );
    private final String name;
    private final CropSeedEnum source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final boolean oneTimeHarvest;
    private final Integer regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final Integer energy;
    private final ArrayList<String> seasons;
    private final boolean canBecomeGiant;

    CropEnum(
            String name, CropSeedEnum source, ArrayList<Integer> stages,
            int totalHarvestTime, boolean oneTimeHarvest, Integer regrowthTime,
            int baseSellPrice, boolean isEdible, Integer energy,
            ArrayList<String> seasons, boolean canBecomeGiant
    ) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTimeHarvest = oneTimeHarvest;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        this.seasons = seasons;
        this.canBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }

    public CropSeedEnum getSource() {
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

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getEnergy() {
        return energy;
    }

    public ArrayList<String> getSeasons() {
        return seasons;
    }

    public boolean isCanBecomeGiant() {
        return canBecomeGiant;
    }

    @Override
    public String toString() {
        StringBuilder stagesString = new StringBuilder();
        for (Integer stage : stages) {
            stagesString.append(stage);
            stagesString.append("-");
        }
        stagesString.deleteCharAt(stagesString.length()-1);
        StringBuilder seasonsString = new StringBuilder();
        for (String season : seasons) {
            seasonsString.append(season);
            seasonsString.append(", ");
        }
        seasonsString.deleteCharAt(seasonsString.length()-1);
        String regrowthTimeString = "";
        if (!oneTimeHarvest) regrowthTimeString = regrowthTime.toString();
        String energyString = "";
        if (isEdible) energyString = energy.toString();
        return
                "Name: " + name +
                "\nSource: " + source.getName() +
                "\nStages: " + stagesString +
                "\nTotal Harvest Time: " + totalHarvestTime +
                "\nOne Time: " + Boolean.toString(oneTimeHarvest).toUpperCase() +
                "\nRegrowth Time: " + regrowthTimeString +
                "\nBase Sell Price: " + baseSellPrice +
                "\nIs Edible: " + Boolean.toString(isEdible).toUpperCase() +
                "\nBase Energy: " + energyString +
                "\nSeasons: " + seasonsString +
                "\nCan Become Giant" + Boolean.toString(canBecomeGiant).toUpperCase();
    }
}
