package org.example.models;

public class BlackSmithStore extends Store{
    public BlackSmithStore() {
        super.addProduct(new InventoryItem("CopperOre", 75), 100000000);
        super.addProduct(new InventoryItem("IronOre", 150), 100000000);
        super.addProduct(new InventoryItem("Coal", 150), 100000000);
        super.addProduct(new InventoryItem("GoldOre", 400), 100000000);
    }
    public void resetCapacity(){}
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Black Smith!");
    }
}
