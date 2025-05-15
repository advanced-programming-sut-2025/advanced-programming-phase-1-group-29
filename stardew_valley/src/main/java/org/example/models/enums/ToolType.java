package org.example.models.enums;

public enum ToolType {
    PRIMARY(0,5, null),
    COPPER(2000, 5, "CopperBar"),
    IRON(5000, 5, "IronBar"),
    GOLD(10000, 5, "GoldBar"),
    IRIDIUM(25000, 5, "IridiumBar");

    private final int coinForUpgrade;
    private final int barForUpgrade;
    private final String bar;

    ToolType(int coinForUpgrade, int barForUpgrade, String bar) {
        this.coinForUpgrade = coinForUpgrade;
        this.barForUpgrade = barForUpgrade;
        this.bar = bar;
    }

    public ToolType upgrade() {
        if (this.equals(ToolType.PRIMARY)) return ToolType.COPPER;
        if (this.equals(ToolType.COPPER)) return ToolType.IRON;
        if (this.equals(ToolType.IRON)) return ToolType.GOLD;
        return ToolType.IRIDIUM;
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
