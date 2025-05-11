package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum TreeEnum {
    APRICOT_TREE(
            "Apricot Tree", TreeSeedEnum.APRICOT_SAPLING, FruitEnum.APRICOT,
            1, new ArrayList<>(List.of("Spring"))
    ),
    CHERRY_TREE(
            "Cherry Tree", TreeSeedEnum.CHERRY_SAPLING, FruitEnum.CHERRY,
            1, new ArrayList<>(List.of("Spring"))
    ),
    BANANA_TREE(
            "Banana Tree", TreeSeedEnum.BANANA_SAPLING, FruitEnum.BANANA,
            1, new ArrayList<>(List.of("Summer"))
    ),
    MANGO_TREE(
            "Mango Tree", TreeSeedEnum.MANGO_SAPLING, FruitEnum.MANGO,
            1, new ArrayList<>(List.of("Summer"))
    ),
    ORANGE_TREE(
            "Orange Tree", TreeSeedEnum.ORANGE_SAPLING, FruitEnum.ORANGE,
            1, new ArrayList<>(List.of("Summer"))
    ),
    PEACH_TREE(
            "Peach Tree", TreeSeedEnum.PEACH_SAPLING, FruitEnum.PEACH,
            1, new ArrayList<>(List.of("Summer"))
    ),
    APPLE_TREE(
            "Apple Tree", TreeSeedEnum.APPLE_SAPLING, FruitEnum.APPLE,
            1, new ArrayList<>(List.of("Fall"))
    ),
    POMEGRANATE_TREE(
            "Pomegranate Tree", TreeSeedEnum.POMEGRANATE_SAPLING, FruitEnum.POMEGRANATE,
            1, new ArrayList<>(List.of("Fall"))
    ),
    OAK_TREE(
            "Oak Tree", TreeSeedEnum.ACORN, FruitEnum.OAK_RESIN,
            7, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MAPLE_TREE(
            "Maple Tree", TreeSeedEnum.MAPLE_SEED, FruitEnum.MAPLE_SYRUP,
            9, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    PINE_TREE(
            "Pine Tree", TreeSeedEnum.PINE_CONE, FruitEnum.PINE_TAR,
            5, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MAHOGANY_TREE(
            "Mahogany Tree", TreeSeedEnum.MAHOGANY_SEED, FruitEnum.SAP,
            1, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MUSHROOM_TREE(
            "Mushroom Tree", TreeSeedEnum.MUSHROOM_TREE_SEED, FruitEnum.COMMON_MUSHROOM,
            1, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MYSTIC_TREE(
            "Mystic Tree", TreeSeedEnum.MYSTIC_TREE_SEED, FruitEnum.MYSTIC_SYRUP,
            7, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    );
    private final String name;
    private final TreeSeedEnum source;
    private final ArrayList<Integer> stages = new ArrayList<>(List.of(7, 7, 7, 7));
    private final int totalHarvestTime = 28;
    private final FruitEnum fruit;
    private final int fruitHarvestCycle;
    private final ArrayList<String> seasons;

    TreeEnum(String name, TreeSeedEnum source, FruitEnum fruit, int fruitHarvestCycle, ArrayList<String> seasons) {
        this.name = name;
        this.source = source;
        this.fruit = fruit;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.seasons = seasons;
    }

    public String getName() {
        return name;
    }

    public TreeSeedEnum getSource() {
        return source;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public FruitEnum getFruit() {
        return fruit;
    }

    public int getFruitHarvestCycle() {
        return fruitHarvestCycle;
    }

    public ArrayList<String> getSeasons() {
        return seasons;
    }
}
