package org.example.models;

import org.example.models.AnimalsPackage.Animal;
import org.example.models.AnimalsPackage.AnimalHouse;
import org.example.models.FarmPackage.Farm;

import java.util.ArrayList;

public class Shear extends Tool{

    public Shear(String name) {
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
            if (object instanceof AnimalHouse animalHouse) {
                for (Animal animal : animalHouse.getAnimals()) {
                    if (animal.getTiles().getFirst().getX() == x && animal.getTiles().getFirst().getY() == y) {
                        ArrayList<InventoryItem> toBeRemoved = new ArrayList<>();
                        for (int i = 0; i < Math.min(animal.getProducts().size(), player.getInventory().getCapacity()); i++) {
                            if (animal.getProducts().get(i).getName().equalsIgnoreCase("Wool")) {
                                player.getInventory().addInventoryItem(animal.getProducts().get(i), 1);
                                player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
                                toBeRemoved.add(animal.getProducts().get(i));
                            }
                        }
                        for (InventoryItem inventoryItem : toBeRemoved) {
                            animal.getProducts().remove(inventoryItem);
                        }
                        return new Result(true, "The shear is used successfully.");
                    }
                }
            }
        }
        player.setEnergy(player.getEnergy() - this.applyWeatherOnEnergyConsumption(this.getEnergyConsumption()));
        return new Result(false, "The shear can't be used in this direction.");
    }
}
