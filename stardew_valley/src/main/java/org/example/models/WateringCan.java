package org.example.models;

import org.example.models.enums.ToolType;

public class WateringCan extends Tool {
    private ToolType type = ToolType.PRIMARY;

    public WateringCan(String name, int price) {
        super(name, price);
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    @Override
    public int getEnergyConsumption() {
        int ability = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getFarmingLevel();
        if (ability == 4) {
            ability = 1;
        }
        else {
            ability = 0;
        }
        if (type.equals(ToolType.COPPER)) return 4 - ability;
        if (type.equals(ToolType.IRON)) return 3 - ability;
        if (type.equals(ToolType.GOLD)) return 2 - ability;
        if (type.equals(ToolType.IRIDIUM)) return 1 - ability;
        return 5 - ability;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }
}
