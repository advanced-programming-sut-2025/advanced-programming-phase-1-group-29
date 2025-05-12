package org.example.models;

import org.example.models.enums.SeedEnum;

public class Seed extends InventoryItem{
    private final SeedEnum seedEnum;

    public Seed(String name, int price) {
        super(name, price);
        name = name.replaceAll("\\s+", "_").toUpperCase();
        seedEnum = SeedEnum.valueOf(name);
    }

    public SeedEnum getSeedEnum() {
        return seedEnum;
    }
}
