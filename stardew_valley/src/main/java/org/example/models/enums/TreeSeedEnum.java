package org.example.models.enums;


public enum TreeSeedEnum {
    ACORN("Acorns", true),
    MAPLE_SEED("Maple Seeds", true),
    PINE_CONE("Pine Cones", true),
    MAHOGANY_SEED("Mahogany Seeds", true),
    MUSHROOM_TREE_SEED("Mushroom Tree Seeds", true),
    APRICOT_SAPLING("Apricot Sapling", false),
    CHERRY_SAPLING("Cherry Sapling", false),
    BANANA_SAPLING("Banana Sapling", false),
    MANGO_SAPLING("Mango Sapling", false),
    ORANGE_SAPLING("Orange Sapling", false),
    PEACH_SAPLING("Peach Sapling", false),
    APPLE_SAPLING("Apple Sapling", false),
    POMEGRANATE_SAPLING("Pomegranate Sapling", false),
    MYSTIC_TREE_SEED("Mystic Tree Seeds", false);


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
