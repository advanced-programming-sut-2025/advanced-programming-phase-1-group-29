package org.example.models;

public class FishShop extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Fish Shop!");
    }
    public FishShop() {
        super();
        addProducts();
    }
    public void resetCapacity(){
        super.resetProducts();
        addProducts();
    }
    private void addProducts(){
        super.addProduct(new InventoryItem("FishSmoker", 10000), 1);
        super.addProduct(new InventoryItem("TroutSoup", 250), 1);
        super.addProduct(new InventoryItem("BambooPole", 500), 1);
        super.addProduct(new InventoryItem("TrainingRod", 25), 1);
        super.addProduct(new InventoryItem("FiberglassRod", 1800), 1);
        super.addProduct(new InventoryItem("IridiumRod", 7500), 1);
    }
}
