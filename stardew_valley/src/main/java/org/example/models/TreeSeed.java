package org.example.models;

import org.example.models.enums.TreeSeedEnum;

public class TreeSeed extends Seed{
    private final TreeSeedEnum treeSeedEnum;

    public TreeSeed(String name, int price) {
        super(name, price);
        name = name.toUpperCase();
        treeSeedEnum = TreeSeedEnum.valueOf(name);
    }

    public TreeSeedEnum getTreeSeedEnum() {
        return treeSeedEnum;
    }
}
