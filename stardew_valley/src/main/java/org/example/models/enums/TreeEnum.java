package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum TreeEnum {
    APRICOTTREE(
            "Apricot Tree", TreeSeedEnum.APRICOTSAPLING, FruitEnum.APRICOT,
            1, new ArrayList<>(List.of("Spring"))
    ),
    CHERRYTREE(
            "Cherry Tree", TreeSeedEnum.CHERRYSAPLING, FruitEnum.CHERRY,
            1, new ArrayList<>(List.of("Spring"))
    ),
    BANANATREE(
            "Banana Tree", TreeSeedEnum.BANANASAPLING, FruitEnum.BANANA,
            1, new ArrayList<>(List.of("Summer"))
    ),
    MANGOTREE(
            "Mango Tree", TreeSeedEnum.MANGOSAPLING, FruitEnum.MANGO,
            1, new ArrayList<>(List.of("Summer"))
    ),
    ORANGETREE(
            "Orange Tree", TreeSeedEnum.ORANGESAPLING, FruitEnum.ORANGE,
            1, new ArrayList<>(List.of("Summer"))
    ),
    PEACHTREE(
            "Peach Tree", TreeSeedEnum.PEACHSAPLING, FruitEnum.PEACH,
            1, new ArrayList<>(List.of("Summer"))
    ),
    APPLETREE(
            "Apple Tree", TreeSeedEnum.APPLESAPLING, FruitEnum.APPLE,
            1, new ArrayList<>(List.of("Fall"))
    ),
    POMEGRANATETREE(
            "Pomegranate Tree", TreeSeedEnum.POMEGRANATESAPLING, FruitEnum.POMEGRANATE,
            1, new ArrayList<>(List.of("Fall"))
    ),
    OAKTREE(
            "Oak Tree", TreeSeedEnum.ACORN, FruitEnum.OAKRESIN,
            7, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MAPLETREE(
            "Maple Tree", TreeSeedEnum.MAPLESEEDS, FruitEnum.MAPLESYRUP,
            9, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    PINETREE(
            "Pine Tree", TreeSeedEnum.PINECONE, FruitEnum.PINETAR,
            5, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MAHOGANYTREE(
            "Mahogany Tree", TreeSeedEnum.MAHOGANYSEEDS, FruitEnum.SAP,
            1, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MUSHROOMTREE(
            "Mushroom Tree", TreeSeedEnum.MUSHROOMTREESEEDS, FruitEnum.COMMONMUSHROOM,
            1, new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))
    ),
    MYSTICTREE(
            "Mystic Tree", TreeSeedEnum.MYSTICTREESEEDS, FruitEnum.MYSTICSYRUP,
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
