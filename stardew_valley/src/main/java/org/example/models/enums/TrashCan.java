package org.example.models.enums;

public enum TrashCan {
    PRIMARY(0),
    COPPER(15),
    IRON(30),
    GOLD(45),
    IRIDIUM(60);

    private int returnValuePercentage;

    TrashCan(int returnValuePercentage) {
        this.returnValuePercentage = returnValuePercentage;
    }

    public int getReturnValuePercentage() {
        return returnValuePercentage;
    }

    public TrashCan upgrade() {
        if (this.equals(TrashCan.PRIMARY)) return TrashCan.COPPER;
        if (this.equals(TrashCan.COPPER)) return TrashCan.IRON;
        if (this.equals(TrashCan.IRON)) return TrashCan.GOLD;
        if (this.equals(TrashCan.GOLD)) return TrashCan.IRIDIUM;
        return null;
    }
}
