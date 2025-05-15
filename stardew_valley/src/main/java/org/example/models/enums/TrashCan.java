package org.example.models.enums;

public enum TrashCan {
    PRIMARY(0, 0, 5, null),
    COPPER(15, 1000, 5, "CopperBar"),
    IRON(30, 2500, 5, "IronBar"),
    GOLD(45, 5000, 5, "GoldBar"),
    IRIDIUM(60, 12500, 5, "IridiumBar");

    private final int returnValuePercentage;
    private final int coinForUpgrade;
    private final int barForUpgrade;
    private final String bar;

    TrashCan(int returnValuePercentage, int coinForUpgrade, int barForUpgrade, String bar) {
        this.returnValuePercentage = returnValuePercentage;
        this.coinForUpgrade = coinForUpgrade;
        this.barForUpgrade = barForUpgrade;
        this.bar = bar;
    }

    public int getReturnValuePercentage() {
        return returnValuePercentage;
    }

    public TrashCan upgrade() {
        if (this.equals(TrashCan.PRIMARY)) return TrashCan.COPPER;
        if (this.equals(TrashCan.COPPER)) return TrashCan.IRON;
        if (this.equals(TrashCan.IRON)) return TrashCan.GOLD;
        return TrashCan.IRIDIUM;
    }

    public int getCoinForUpgrade() {
        return coinForUpgrade;
    }

    public int getBarForUpgrade() {
        return barForUpgrade;
    }

    public String getBar() {
        return bar;
    }
}
