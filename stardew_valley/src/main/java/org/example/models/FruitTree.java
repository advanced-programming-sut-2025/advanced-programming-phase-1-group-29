package org.example.models;

import org.example.models.enums.TreeEnum;

public class FruitTree extends Plant{
    private TreeEnum tree;

    public FruitTree(Seed seed) {
        super(seed);
        for (TreeEnum value : TreeEnum.values()) {
            if (value.getSource().equals(((TreeSeed) seed).getTreeSeedEnum())) {
                tree = value;
            }
        }
        name = tree.getName();
        stage = 0;
        remainingTime = tree.getTotalHarvestTime();
    }

    public TreeEnum getTree() {
        return tree;
    }

}
