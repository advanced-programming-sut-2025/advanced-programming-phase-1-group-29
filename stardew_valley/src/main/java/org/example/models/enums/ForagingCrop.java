package org.example.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ForagingCrop {
    COMMONMUSHROOM("Common Mushroom", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter")), 40, 38),
    DAFFODIL("Daffodil", new ArrayList<>(List.of("Spring")), 30, 0),
    DANDELION("Dandelion", new ArrayList<>(List.of("Spring")), 40, 25),
    LEEK("Leek", new ArrayList<>(List.of("Spring")), 60, 40),
    MOREL("Morel", new ArrayList<>(List.of("Spring")), 150, 20),
    SALMONBERRY("Salmonberry", new ArrayList<>(List.of("Spring")), 5, 25),
    SPRINGONION("Spring Onion", new ArrayList<>(List.of("Spring")), 8, 13),
    WILDHORSERADISH("Wild Horseradish", new ArrayList<>(List.of("Spring")), 50, 13),
    FIDDLEHEADFERN("Fiddlehead Fern", new ArrayList<>(List.of("Summer")), 90, 25),
    GRAPE("Grape", new ArrayList<>(List.of("Summer")), 80, 38),
    RED_MUSHROOM("Red Mushroom", new ArrayList<>(List.of("Summer")), 75, -50),
    SPICEBERRY("Spice Berry", new ArrayList<>(List.of("Summer")), 80, 25),
    SWEETPEA("Sweet Pea", new ArrayList<>(List.of("Summer")), 50, 0),
    BLACKBERRY("Blackberry", new ArrayList<>(List.of("Fall")), 25, 25),
    CHANTERELLE("Chanterelle", new ArrayList<>(List.of("Fall")), 160, 75),
    HAZELNUT("Hazelnut", new ArrayList<>(List.of("Fall")), 40, 38),
    PURPLEMUSHROOM("Purple Mushroom", new ArrayList<>(List.of("Fall")), 90, 30),
    WILDPLUM("Wild Plum", new ArrayList<>(List.of("Fall")), 80, 25),
    CROCUS("Crocus", new ArrayList<>(List.of("Winter")), 60, 0),
    CRYSTALFRUIT("Crystal Fruit", new ArrayList<>(List.of("Winter")), 150, 63),
    HOLLY("Holly", new ArrayList<>(List.of("Winter")), 80, -37),
    SNOWYAM("Snow Yam", new ArrayList<>(List.of("Winter")), 100, 30),
    WINTERROOT("Winter Root", new ArrayList<>(List.of("Winter")), 70, 25);

    private final String name;
    private final ArrayList<String> seasons;
    private final int baseSellPrice;
    private final int energy;

    ForagingCrop(String name, ArrayList<String> seasons, int baseSellPrice, int energy) {
        this.name = name;
        this.seasons = seasons;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSeasons() {
        return seasons;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public int getEnergy() {
        return energy;
    }
}
