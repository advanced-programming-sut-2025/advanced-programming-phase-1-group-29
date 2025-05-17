package org.example.models.AnimalsPackage;

import org.example.models.Objectt;
import org.example.models.Tile;
import org.example.models.enums.AnimalEnum;
import org.example.models.enums.AnimalHouseEnum;

import java.util.ArrayList;

public class AnimalHouse extends Objectt {
    private final AnimalHouseEnum animalHouseEnum;
    private ArrayList<Animal> animals = new ArrayList<>();

    public AnimalHouse(AnimalHouseEnum animalHouseEnum) {
        this.animalHouseEnum = animalHouseEnum;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public AnimalHouseEnum getAnimalHouseEnum() {
        return animalHouseEnum;
    }

    public void  addAnimal(Animal animal) {
        for (Tile tile : animal.getTiles()) {
            boolean empty = true;
            for (Animal anAnimal : animals) {
                if(animal.getTiles().get(0).getX() == tile.getX() && animal.getTiles().get(0).getY() == tile.getY()) {
                    empty = false;
                }
            }
            if(empty) {
                animal.getTiles().add(new Tile('^', tile.getX(), tile.getY()));
                break;
            }
        }
        animals.add(animal);
    }
}
