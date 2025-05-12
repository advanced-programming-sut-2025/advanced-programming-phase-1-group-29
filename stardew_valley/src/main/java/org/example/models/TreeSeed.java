package org.example.models;

import org.example.models.enums.SeedEnum;
import org.example.models.enums.TreeSeedEnum;

public class TreeSeed extends InventoryItem{
    private final TreeSeedEnum treeSeedEnum;

    public TreeSeed(String name, int price) {
        super(name, price);
        name = name.replaceAll("\\s+", "_").toUpperCase();
        treeSeedEnum = TreeSeedEnum.valueOf(name);
    }

    public TreeSeedEnum getTreeSeedEnum() {
        return treeSeedEnum;
    }
}
