package org.example.models.enums;


public enum TreeSeedEnum {
    ACORN("Acorns", true),
    MAPLESEEDS("Maple Seeds", true),
    PINECONE("Pine Cones", true),
    MAHOGANYSEEDS("Mahogany Seeds", true),
    MUSHROOMTREESEEDS("Mushroom Tree Seeds", true),
    APRICOTSAPLING("Apricot Sapling", false),
    CHERRYSAPLING("Cherry Sapling", false),
    BANANASAPLING("Banana Sapling", false),
    MANGOSAPLING("Mango Sapling", false),
    ORANGESAPLING("Orange Sapling", false),
    PEACHSAPLING("Peach Sapling", false),
    APPLESAPLING("Apple Sapling", false),
    POMEGRANATESAPLING("Pomegranate Sapling", false),
    MYSTICTREESEEDS("Mystic Tree Seeds", false);


    private final String name;
    private final boolean isForaging;

    TreeSeedEnum(String name, boolean isForaging) {
        this.name = name;
        this.isForaging = isForaging;
    }

    public String getName() {
        return name;
    }

    public boolean isForaging() {
        return isForaging;
    }
}
