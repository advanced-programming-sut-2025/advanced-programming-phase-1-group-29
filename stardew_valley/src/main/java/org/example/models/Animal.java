package org.example.models;

import org.example.models.enums.AnimalEnum;

public class Animal {

    private AnimalEnum animalType;
    private String name;
    private int price;
    private int friendshipPoint = 0;
    private boolean isPetted = false;
    private boolean isFed = false;

    public Animal(AnimalEnum animalType, String name, int price) {
        this.name = name;
        this.animalType = animalType;
        this.price = price;
    }

    public AnimalEnum getAnimalType() {
        return animalType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getFriendshipPoint() {
        return friendshipPoint;
    }

    public void setFriendshipPoint(int friendshipPoint) {
        this.friendshipPoint = friendshipPoint;
    }

    public void addFriendshipPoint(int point) {
        this.friendshipPoint += point;
    }

    public boolean isPetted() {
        return isPetted;
    }

    public void setIsPetted(boolean isPetted) {
        this.isPetted = isPetted;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setIsFed(boolean isFed) {
        this.isFed = isFed;
    }
}
