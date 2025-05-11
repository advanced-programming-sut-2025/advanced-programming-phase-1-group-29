package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum TreeEnum {
    ;
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
}
