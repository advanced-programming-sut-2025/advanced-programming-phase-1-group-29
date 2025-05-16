package org.example.models;

import org.example.models.enums.AnimalHouseEnum;

import java.util.ArrayList;

public class AnimalHouse extends Objectt{
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

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public AnimalHouseEnum getAnimalHouseEnum() {
        return animalHouseEnum;
    }
}
