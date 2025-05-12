package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;

public class CarpentersShop extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 20;
    private boolean open = false;
    public CarpentersShop() {
        super();
        addProducts();
    }
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Carpenter's shop!");
    }
    @Override
    public void resetCapacity(){
        super.resetProducts();
        addProducts();
    }
    private void addProducts(){
        super.addProduct(new InventoryItem("Wood", 10), 100000000);
        super.addProduct(new InventoryItem("Stone", 20), 100000000);
    }
    @Override
    public boolean isOpen() {
        return open;
    }
    @Override
    public void openStore() {
        if (App.getCurrentGame().getCurrentTime().getTime() >= startWorkingHours && App.getCurrentGame().getCurrentTime().getTime() <= endWorkingHours) {
            open = true;
        }
    }
}
