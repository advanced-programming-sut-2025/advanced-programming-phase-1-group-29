package org.example.models.ToolsPackage;

import org.example.models.*;
import org.example.models.FarmPackage.Farm;
import org.example.models.FarmPackage.Lake;
import org.example.models.enums.ToolType;

public class WateringCan extends UpgradableTool {
    private int water = 0;

    public WateringCan(String name, int price) {
        super(name, price);
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
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Plant plant) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    if (this.water > 0) {
                        plant.setWateredToday(true);
                        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                        return new Result(true, "The plant is watered.");
                    }
                    else {
                        return new Result(false, "You must fill in your watering can.");
                    }
                }
            }
            else if (object instanceof Lake) {
                for (Tile tile : object.getTiles()) {
                    if (tile.getX() == x && tile.getY() == y) {
                        if (type.equals(ToolType.PRIMARY)) {
                            water = 40;
                        }
                        else if (type.equals(ToolType.COPPER)) {
                            water = 55;
                        }
                        else if (type.equals(ToolType.IRON)) {
                            water = 70;
                        }
                        else if (type.equals(ToolType.GOLD)) {
                            water = 85;
                        }
                        else {
                            water = 100;
                        }
                        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                        return new Result(true, "Your watering can is filled in successfully.");
                    }
                }
            }
            //TODO green house
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(Math.max(0, this.getEnergyConsumption()-1)));
        return new Result(false, "The watering can can't be used in this direction.");
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
