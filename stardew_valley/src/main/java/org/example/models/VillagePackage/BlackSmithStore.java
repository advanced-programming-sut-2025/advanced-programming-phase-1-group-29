package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;

public class BlackSmithStore extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 16;
    private boolean open = false;
    private boolean welcome = false;

    public BlackSmithStore() {
        super();
        super.addProduct(new InventoryItem("CopperOre", 75), 100000000);
        super.addProduct(new InventoryItem("IronOre", 150), 100000000);
        super.addProduct(new InventoryItem("Coal", 150), 100000000);
        super.addProduct(new InventoryItem("GoldOre", 400), 100000000);
    }
    @Override
    public boolean isWelcome() {
        return welcome;
    }
    @Override
    public void setWelcome(boolean welcome) {
        this.welcome = welcome;
    }
    @Override
    public Result welcomeMessage(){
        return new Result(true, "Welcome to the Black Smith Store!");
    }
    @Override
    public void resetCapacity(){}
    @Override
    public boolean isOpen() {
        return open;
    }
    @Override
    public void openStore() {
        open = App.getCurrentGame().getCurrentTime().getTime() >= startWorkingHours && App.getCurrentGame().getCurrentTime().getTime() <= endWorkingHours;
    }
}
