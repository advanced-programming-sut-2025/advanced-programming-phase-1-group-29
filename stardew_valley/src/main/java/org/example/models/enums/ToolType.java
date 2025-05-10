package org.example.models.enums;

public enum ToolType {
    PRIMARY,
    COPPER,
    IRON,
    GOLD,
    IRIDIUM;

    public ToolType upgrade() {
        if (this.equals(ToolType.PRIMARY)) return ToolType.COPPER;
        if (this.equals(ToolType.COPPER)) return ToolType.IRON;
        if (this.equals(ToolType.IRON)) return ToolType.GOLD;
        if (this.equals(ToolType.GOLD)) return ToolType.IRIDIUM;
        return null;
    }
}
