package org.example.models;

import org.example.models.enums.ToolType;

import java.util.ArrayList;
import java.util.List;

public class Hoe extends Tool{

    private ToolType type = ToolType.PRIMARY;

    public Hoe(String name, int price) {
        super(name, price);
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }
    @Override
    public Result useTool(int x, int y) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        if ((!player.isEnergyUnlimited()) && player.getCurrentTool().getEnergyConsumption() > player.getEnergy())
            return new Result(false, "You don't have enough energy");
        player.setEnergy(player.getEnergy() - player.getCurrentTool().getEnergyConsumption());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        if (
                x < farm.getXStart() || x >= farm.getXStart() + Farm.getXRange() ||
                y < farm.getYStart() || y >= farm.getYStart() + Farm.getYRange()
        )
            return new Result(false, "The hoe can't be used in this direction");
        for (Objectt object : farm.getObjects()) {
            for (Tile tile : object.getTiles()) {
                if (tile.getX() == x && tile.getY() == y)
                    return new Result(false, "The hoe can't be used in this direction");
            }
        }
        Furrow furrow = new Furrow();
        furrow.setTiles(new ArrayList<>(List.of(new Tile('F', x, y))));
        farm.addObject(furrow);
        return new Result(true, name + " is used.");
    }

    @Override
    public int getEnergyConsumption() {
        if (type.equals(ToolType.COPPER)) return 4;
        if (type.equals(ToolType.IRON)) return 3;
        if (type.equals(ToolType.GOLD)) return 2;
        if (type.equals(ToolType.IRIDIUM)) return 1;
        return 5;
    }
}
