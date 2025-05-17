package org.example.models.AnimalsPackage;

import org.example.models.InventoryItem;
import org.example.models.Objectt;
import org.example.models.enums.AnimalEnum;
import org.example.models.enums.AnimalProductEnum;

import java.util.ArrayList;
import java.util.Random;

public class Animal extends Objectt {

    private final AnimalEnum animalType;
    private final String name;
    private final int price;
    private int friendshipPoint = 0;
    private boolean isPetted = false;
    private boolean isFed = false;
    private final ArrayList<InventoryItem> products = new ArrayList<>();

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

    public  void reduceFriendshipPoint(int point) {
        this.friendshipPoint -= point;
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

    public ArrayList<InventoryItem> getProducts() {
        return products;
    }

    public void addProduct(){
        AnimalProductEnum productType;
        Random random = new Random();
        if(this.animalType.getProducts().size() == 2 && this.friendshipPoint >= 100){
            double chance = ((double) this.friendshipPoint + ((double) 150 * (0.5 + random.nextDouble(1)))) / 1500;
            if(chance >= 0.5){
                productType = this.animalType.getProducts().get(1);
            }
            else{
                productType = this.animalType.getProducts().get(0);
            }
        }
        else {
            productType = this.animalType.getProducts().get(0);
        }
        double quality = ((double) this.friendshipPoint / 1000) * (0.5 + 0.5 * random.nextDouble(1));
        int price = productType.getPrice();
        if(0.5 < quality && quality <= 0.7){
            price = (int)(price * 1.25);
        }
        else if(0.7 < quality && quality <= 0.9){
            price = (int)(price * 1.5);
        }
        else if(0.9 < quality){
            price = price * 2;
        }
        InventoryItem product = new InventoryItem(productType.getName(), price);
        product.setQuality(quality);
        this.products.add(product);
    }
}
