package org.example.models.enums;

public enum ForagingMineral {
    QUARTZ("Quartz", 25),
    EARTHCRYSTAL("Earth Crystal", 50),
    FROZENTEAR("Frozen Tear", 75),
    FIREQUARTZ("Fire Quartz", 100),
    EMERALD("Emerald", 250),
    AQUAMARINE("Aquamarine", 180),
    RUBY("Ruby", 250),
    AMETHYST("Amethyst", 100),
    TOPAZ("Topaz", 80),
    JADE("Jade", 200),
    DIAMOND("Diamond", 750),
    PRISMATICSHARD("Prismatic Shard", 2000),
    COPPER("Copper", 5),
    IRON("Iron", 10),
    GOLD("Gold", 25),
    IRIDIUM("Iridium", 100),
    COAL("Coal", 15);

    private final String name;
    private final int sellPrice;

    ForagingMineral(String name, int sellPrice) {
        this.name = name;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
