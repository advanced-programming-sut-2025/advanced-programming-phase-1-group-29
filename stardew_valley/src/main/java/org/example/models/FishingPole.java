package org.example.models;


import org.example.models.FarmPackage.Farm;
import org.example.models.FarmPackage.Lake;
import org.example.models.enums.FishEnum;
import org.example.models.enums.FishingPoleType;

import java.util.Random;

public class FishingPole extends Tool{
    private FishingPoleType type;

    public FishingPole(String name, int price, FishingPoleType type) {
        super(name, price);
        this.type = type;
        price = type.getPrice();
    }

    public void setType(FishingPoleType type) {
        this.type = type;
    }

    public FishingPoleType getType() {
        return type;
    }

    private boolean nearTheLake() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Farm farm = App.getCurrentGame().getCurrentFarm();
        for (Objectt objectt : farm.getObjects()) {
            if(objectt instanceof Lake lake) {
                int x = player.getX();
                int y = player.getY();
                for (Tile tile : lake.getTiles()) {
                    if (Math.abs(tile.getX() - x) <= 1 && Math.abs(tile.getY() - y) <= 1) return true;
                }
            }
        }
        return false;
    }

    @Override
    public Result useTool(int x, int y) {
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        if(!nearTheLake()){
            return new Result(false, "You are not near the lake");
        }
        Random rand = new Random();
        int amount = Math.min((int) (Math.ceil(rand.nextDouble(2) * game.getWeather().getFishingRate() * (player.getFishingLevel() + 2))), 6);
        double quality = rand.nextDouble(2) * (player.getFishingLevel() + 2) * type.getQuantityRate() / (7 - amount);
        amount = Math.min(amount, inventory.getCapacity());
        int actualAmount = 0;
        for (int i = 0; i < amount; i++) {
            if (player.getInventory().getCapacity() > 0) {
                FishEnum fishEnum = FishEnum.getRandomFish(game.getCurrentTime().getSeason(), player.getFishingLevel() == 4);
                InventoryItem fish = new InventoryItem(fishEnum.getName(), 0);
                player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                fish.setQuality(quality);
                inventory.addInventoryItem(fish, 1);
                actualAmount++;
            }
            else {
                break;
            }
        }
        return new Result(true, "You caught " + actualAmount);
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
