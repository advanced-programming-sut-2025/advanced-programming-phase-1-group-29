package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;

public class MarniesRanch extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 16;
    private boolean open = false;
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Marnies Ranch!");
    }
    public MarniesRanch(){
        super();
        addProducts();
    }
    @Override
    public void resetCapacity(){
        super.resetProducts();
        addProducts();
    }
    private void addProducts(){
        super.addProduct(new InventoryItem("Hay", 50), 100000000);
        super.addProduct(new InventoryItem("MilkPail", 1000), 1);
        super.addProduct(new InventoryItem("Shears", 1000), 1);
        super.addProduct(new InventoryItem("Chicken", 800), 2);
        super.addProduct(new InventoryItem("Cow", 1500), 2);
        super.addProduct(new InventoryItem("Goat", 4000), 2);
        super.addProduct(new InventoryItem("Duck", 1200), 2);
        super.addProduct(new InventoryItem("Sheep", 8000), 2);
        super.addProduct(new InventoryItem("Rabbit", 8000), 2);
        super.addProduct(new InventoryItem("Dinosaur", 14000), 2);
        super.addProduct(new InventoryItem("Pig", 16000), 2);
        //TODO
        //check barns
    }
    @Override
    public boolean isOpen() {
        return open;
    }
    @Override
    public void openStore() {
        open = App.getCurrentGame().getCurrentTime().getTime() >= startWorkingHours && App.getCurrentGame().getCurrentTime().getTime() <= endWorkingHours;
    }
}
