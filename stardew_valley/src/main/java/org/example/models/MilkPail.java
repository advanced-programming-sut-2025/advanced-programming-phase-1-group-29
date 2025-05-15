package org.example.models;

import java.util.ArrayList;

public class MilkPail extends Tool{

    public MilkPail(String name) {
        super(name, 1000);
    }

    @Override
    public int getEnergyConsumption() {
        return 4;
    }

    @Override
    public Result useTool(int x, int y) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Barn barn) {
                if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                    for (Animal animal : barn.getAnimals()) {
                        ArrayList<InventoryItem> toBeRemoved = new ArrayList<>();
                        for (int i = 0; i < Math.min(animal.getProducts().size(), player.getInventory().getCapacity()); i++) {
                            if (
                                    animal.getProducts().get(i).getName().equalsIgnoreCase("Milk") ||
                                    animal.getProducts().get(i).getName().equalsIgnoreCase("GoatMilk")
                            ) {
                                player.getInventory().addInventoryItem(animal.getProducts().get(i), 1);
                                player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                                toBeRemoved.add(animal.getProducts().get(i));
                            }
                        }
                        for (InventoryItem inventoryItem : toBeRemoved) {
                            animal.getProducts().remove(inventoryItem);
                        }
                    }
                    return new Result(true, "The milk pail is used successfully.");
                }
            }
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
        return new Result(false, "The milk pail can't be used in this direction.");
    }
}
