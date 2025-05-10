package org.example.models;


import org.example.models.enums.FishingPoleType;

public class FishingPole extends Tool{
    private FishingPoleType type;

    public FishingPole(FishingPoleType type) {
        this.type = type;
        price = type.getPrice();
    }

    public void setType(FishingPoleType type) {
        this.type = type;
    }

    public FishingPoleType getType() {
        return type;
    }

    @Override
    public Result useTool(int x, int y) {
        return null;
    }

    @Override
    public int getEnergyConsumption() {
        int ability = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getFishingLevel();
        if (ability == 4) {
            ability = 1;
        }
        else {
            ability = 0;
        }
        if (type.equals(FishingPoleType.PRIMARY)) return 8 - ability;
        if (type.equals(FishingPoleType.BAMBOO)) return 8 - ability;
        if (type.equals(FishingPoleType.FIBER_GLASS)) return 6 - ability;
        return 4 - ability;
    }
}
