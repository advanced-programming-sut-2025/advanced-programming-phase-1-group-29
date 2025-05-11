package org.example.models;

import org.example.models.enums.Season;

public class JojaMartStore extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Joja Mart!");
    }
    public JojaMartStore() {
        super();
        addProducts();
    }
    public void resetCapacity(){
        super.resetProducts();
        addProducts();
    }

    private void addProducts(){
        super.addProduct(new InventoryItem("JojaCola", 75), 100000000);
        super.addProduct(new InventoryItem("AncientSeed", 500), 1);
        super.addProduct(new InventoryItem("GrassStarter", 125), 100000000);
        super.addProduct(new InventoryItem("Sugar", 125), 100000000);
        super.addProduct(new InventoryItem("WheatFlour", 125), 100000000);
        super.addProduct(new InventoryItem("Rice", 250), 100000000);

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Spring)) {
            super.addProduct(new InventoryItem("Parsnip Seeds", 25), 5);
            super.addProduct(new InventoryItem("Bean Starter", 75), 5);
            super.addProduct(new InventoryItem("Cauliflower Seeds", 100), 5);
            super.addProduct(new InventoryItem("Potato Seeds", 62), 5);
            super.addProduct(new InventoryItem("Strawberry Seeds", 100), 5);
            super.addProduct(new InventoryItem("Tulip Bulb", 25), 5);
            super.addProduct(new InventoryItem("Kale Seeds", 87), 5);
            super.addProduct(new InventoryItem("Coffee Beans", 200), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Summer)) {
            super.addProduct(new InventoryItem("Tomato Seeds", 62), 5);
            super.addProduct(new InventoryItem("Pepper Seeds", 50), 5);
            super.addProduct(new InventoryItem("Wheat Seeds", 12), 10);
            super.addProduct(new InventoryItem("Summer Squash Seeds", 10), 10);
            super.addProduct(new InventoryItem("Radish Seeds", 50), 5);
            super.addProduct(new InventoryItem("Melon Seeds", 100), 5);
            super.addProduct(new InventoryItem("Hops Starter", 75), 5);
            super.addProduct(new InventoryItem("Poppy Seeds", 125), 5);
            super.addProduct(new InventoryItem("Spangle Seeds", 62), 5);
            super.addProduct(new InventoryItem("Starfruit Seeds", 400), 5);
            super.addProduct(new InventoryItem("Coffee Beans", 200), 1);
            super.addProduct(new InventoryItem("Sunflower Seeds", 125), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Fall)) {
            super.addProduct(new InventoryItem("Corn Seeds", 187), 5);
            super.addProduct(new InventoryItem("Eggplant Seeds", 25), 5);
            super.addProduct(new InventoryItem("Pumpkin Seeds", 125), 5);
            super.addProduct(new InventoryItem("Broccoli Seeds", 15), 5);
            super.addProduct(new InventoryItem("Amaranth Seeds", 87), 5);
            super.addProduct(new InventoryItem("Grape Starter", 75), 5);
            super.addProduct(new InventoryItem("Beet Seeds", 20), 5);
            super.addProduct(new InventoryItem("Yam Seeds", 75), 5);
            super.addProduct(new InventoryItem("Bok Choy Seeds", 62), 5);
            super.addProduct(new InventoryItem("Cranberry Seeds", 300), 5);
            super.addProduct(new InventoryItem("Sunflower Seeds", 125), 5);
            super.addProduct(new InventoryItem("Fairy Seeds", 250), 5);
            super.addProduct(new InventoryItem("Rare Seed", 1000), 1);
            super.addProduct(new InventoryItem("Wheat Seeds", 12), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Winter)) {
            super.addProduct(new InventoryItem("Powdermelon Seeds", 20), 10);
        }
    }
}
