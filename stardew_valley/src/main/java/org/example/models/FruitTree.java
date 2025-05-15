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
        totalHarvestTime = tree.getTotalHarvestTime();
        name = tree.getName();
        stage = 0;
        remainingTime = tree.getTotalHarvestTime();
    }

    @Override
    public void grow() {
        this.decrementRemainingTime();
        int sum = 0;
        for (int i = 0; i < tree.getStages().size() - 1; i++) {
            sum += tree.getStages().get(i);
            if (sum == tree.getTotalHarvestTime() - this.getRemainingTime())
                this.incrementStage();
        }
    }

    public TreeEnum getTree() {
        return tree;
    }

}
