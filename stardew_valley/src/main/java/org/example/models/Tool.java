package org.example.models;

import org.example.models.enums.ToolType;

public abstract class Tool extends InventoryItem{

    protected int level;
    protected ToolType type = ToolType.PRIMARY;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract int getEnergyConsumption();

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public abstract Result useTool(int x, int y);
}
