package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;

public class FishShop extends Store {
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
    @Override
    public Result purchase(String productName, int quantity) {
        if (productName.equalsIgnoreCase("FiberglassRod")){
            if (App.getCurrentGame().getCurrentPlayer().getFishingLevel() < 2){
                return new Result(false, "your fishing skill must be at least 2");
            }
        }
        if (productName.equalsIgnoreCase("IridiumRod")){
            if (App.getCurrentGame().getCurrentPlayer().getFishingLevel() < 4){
                return new Result(false, "your fishing skill must be at least 4");
            }
        }
        return super.purchase(productName, quantity);
    }
}
