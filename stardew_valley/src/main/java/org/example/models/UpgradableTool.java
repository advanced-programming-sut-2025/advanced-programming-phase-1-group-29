package org.example.models;

import org.example.models.enums.ToolType;

public abstract class UpgradableTool extends Tool{
    protected ToolType type = ToolType.PRIMARY;
    public UpgradableTool(String name, int price) {
        super(name, price);
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }
}
