package org.example.models;

import org.example.models.enums.CropEnum;
import org.example.models.enums.ForagingCrop;
import org.example.models.enums.FruitEnum;

public class Seythe extends Tool{
    public Seythe(String name, int price) {
        super(name, price);
    }

    @Override
    public int getEnergyConsumption() {
        return 2;
    }

    private Result harvestCrop(Crop crop) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        InventoryItem item;
        if (!crop.isForaging()) {
            CropEnum cropEnum = crop.getCrop();
            item = new InventoryItem(cropEnum.getName().replaceAll("\\s+", ""), cropEnum.getBaseSellPrice());
            if (cropEnum.isOneTimeHarvest()) {
                farm.getObjects().remove(crop);
            }
            else {
                crop.setReadyForHarvest(false);
                crop.setInHarvestCycle(true);
                crop.setRemainingHarvestCycle(cropEnum.getRegrowthTime());
            }
        }
        else {
            ForagingCrop foragingCrop = crop.getForagingCrop();
            item = new InventoryItem(foragingCrop.getName().replaceAll("\\s+", ""), foragingCrop.getBaseSellPrice());
            farm.getObjects().remove(crop);
        }
        player.getInventory().addInventoryItem(item, 1);
        //TODO item.setQuality();
        return new Result(true, "The crop is harvested.");
    }

    private Result harvestTree(FruitTree tree) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        FruitEnum fruit = tree.getTree().getFruit();
        InventoryItem item = new InventoryItem(fruit.getName().replaceAll("\\s+",""), fruit.getBaseSellPrice());
        player.getInventory().addInventoryItem(item, 1);
        //TODO item.setQuality();
        tree.setReadyForHarvest(false);
        tree.setInHarvestCycle(true);
        tree.setRemainingHarvestCycle(tree.getTree().getFruitHarvestCycle());
        return new Result(true, "The tree is harvested.");
    }

    @Override
    public Result useTool(int x, int y) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Plant plant) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    if (plant.isReadyForHarvest() && player.getInventory().getCapacity() > 0) {
                        player.addFarmingUnit(5);
                        if (plant instanceof Crop) return harvestCrop((Crop) plant);
                        else if (plant instanceof FruitTree) return harvestTree((FruitTree) plant);
                    }
                }
            }
            //TODO grass
        }
        return new Result(false, "The seythe can't be used in this direction.");
    }
}
