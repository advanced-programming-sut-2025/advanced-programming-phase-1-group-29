package org.example.models;

import org.example.models.FarmPackage.Farm;
import org.example.models.enums.ToolType;

public class Axe extends UpgradableTool{

    public Axe(String name, int price) {
        super(name, price);
    }

    @Override
    public int getEnergyConsumption() {
        int ability = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getForagingLevel();
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

    private void addSeed(Objectt object) {
        if (object instanceof FruitTree tree) {
            if (tree.getTree().getSource().isForaging()) {
                Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
                player.addForagingUnit(10);
                if (player.getInventory().getCapacity() > 0)
                    player.getInventory().addInventoryItem(new TreeSeed(tree.getTree().getSource().getName().replaceAll("\\s+", ""),0), 1);
            }
        }
    }

    @Override
    public Result useTool(int x, int y) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        for (Objectt object : farm.getObjects()) {
            if ((object instanceof Tree) || (object instanceof FruitTree)) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    farm.getObjects().remove(object);
                    player.addForagingUnit(10);
                    player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                    if (player.getInventory().getCapacity() > 0)
                        player.getInventory().addInventoryItem("Wood", 1, 0);
                    addSeed(object);
                    return new Result(true, "The tree is destroyed.");
                }
            }
            //TODO branches
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(Math.max(0, this.getEnergyConsumption()-1)));
        return new Result(false, "The axe can't be used in this direction.");
    }
}
