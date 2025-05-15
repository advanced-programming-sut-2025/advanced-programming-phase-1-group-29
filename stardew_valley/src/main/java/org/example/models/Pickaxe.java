package org.example.models;

import org.example.models.enums.ForagingMineral;
import org.example.models.enums.ToolType;

import java.util.ArrayList;

public class Pickaxe extends Tool{
    private ToolType type = ToolType.PRIMARY;

    public Pickaxe(String name, int price) {
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
        int ability = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getMiningLevel();
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

    private Result destroyStone(Stone stone) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        farm.getObjects().remove(stone);
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
        player.addMiningUnit(10);
        if (player.getInventory().getCapacity() > 0)
            player.getInventory().addInventoryItem("Stone", 1, 0);
        if (player.getInventory().getCapacity() > 0 && player.getMiningLevel() >= 2)
            player.getInventory().addInventoryItem("Stone", 1, 0);
        return new Result(true, "The stone is destroyed.");
    }

    private Result destroyMineral(Quarry quarry, Foraging mineral) {
        ForagingMineral foraging = mineral.getMineral();
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        boolean flag = false;
        if (type.equals(ToolType.PRIMARY)) {
            if (foraging.equals(ForagingMineral.COPPER)) flag = true;
        }
        else if (type.equals(ToolType.COPPER)) {
            if (foraging.equals(ForagingMineral.COPPER) || foraging.equals(ForagingMineral.IRON)) flag = true;
        }
        else if (type.equals(ToolType.IRON)) {
            if (!foraging.equals(ForagingMineral.IRIDIUM)) flag = true;
        }
        else {
            flag = true;
        }
        if (flag) {
            Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
            farm.decrementNumOfForagingMineral();
            quarry.getMinerals().remove(mineral);
            player.addMiningUnit(10);
            if (player.getInventory().getCapacity() > 0)
                player.getInventory().addInventoryItem(foraging.getName().replaceAll("\\s+", ""), 1, 0);
            if (player.getInventory().getCapacity() > 0 && player.getMiningLevel() >= 2)
                player.getInventory().addInventoryItem(foraging.getName().replaceAll("\\s+", ""), 1, 0);
            player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
            return new Result(true, "The mineral is destroyed.");
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(Math.max(0, this.getEnergyConsumption()-1)));
        return new Result(false, "You must upgrade your pickaxe.");
    }

    private Result destroyFurrow(Furrow furrow) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        farm.getObjects().remove(furrow);
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
        return new Result(true, "The furrow is destroyed.");
    }

    @Override
    public Result useTool(int x, int y) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Stone) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    return destroyStone(((Stone) object));
                }
            }
            else if (object instanceof Quarry quarry) {
                for (Foraging mineral : quarry.getMinerals()) {
                    if (mineral.getTiles().getFirst().getX() == x && mineral.getTiles().getFirst().getY() == y) {
                        return destroyMineral(quarry, mineral);
                    }
                }
            }
            else if (object instanceof Furrow) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    return destroyFurrow(((Furrow) object));
                }
            }
            //TODO destroy items that player has put on the tile
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(Math.max(0, this.getEnergyConsumption()-1)));
        return new Result(false, "The pickaxe can't be used in this direction.");
    }
}
