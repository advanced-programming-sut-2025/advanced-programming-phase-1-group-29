package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Player;
import org.example.models.Result;

public class CarpentersShop extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 20;
    private boolean open = false;
    private boolean welcome = false;
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
        super.addProduct(new InventoryItem("wood", 10), 100000000);
        super.addProduct(new InventoryItem("stone", 20), 100000000);
        super.addProduct(new InventoryItem("barn", 6000), 1);
        super.addProduct(new InventoryItem("bigBarn", 12000), 1);
        super.addProduct(new InventoryItem("deluxeBarn", 25000), 1);
        super.addProduct(new InventoryItem("coop", 4000), 1);
        super.addProduct(new InventoryItem("bigCoop", 10000), 1);
        super.addProduct(new InventoryItem("deluxeCoop", 20000), 1);
        super.addProduct(new InventoryItem("well", 1000), 1);
        super.addProduct(new InventoryItem("shippingBin", 250), 100000000);
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
    public boolean isOpen() {
        return open;
    }
    @Override
    public void openStore() {
        open = App.getCurrentGame().getCurrentTime().getTime() >= startWorkingHours && App.getCurrentGame().getCurrentTime().getTime() <= endWorkingHours;
    }
    @Override
    public Result purchase(String productName, int quantity) {
        if (productName.equalsIgnoreCase("barn")) {
            if (!enoughWoodStone(350, 150)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("bigBarn")) {
            if (!enoughWoodStone(540, 200)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("deluxeBarn")) {
            if (!enoughWoodStone(550, 300)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("coop")) {
            if (!enoughWoodStone(300, 100)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("bigCoop")) {
            if (!enoughWoodStone(400, 150)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("deluxeCoop")) {
            if (!enoughWoodStone(500, 200)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("well")) {
            if (!enoughWoodStone(75, 0)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        else if (productName.equalsIgnoreCase("shippingBin")) {
            if (!enoughWoodStone(150, 0)) return new Result(false, "You don't have enough wood or stone in your inventory.");
        }
        return super.purchase(productName, quantity);
    }
    private boolean enoughWoodStone(int wood, int stone) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (player.getInventory().getNumberOfInventoryItem("wood") < wood){
            return false;
        }
        if (player.getInventory().getNumberOfInventoryItem("stone") < stone){
            return false;
        }
        player.getInventory().removeInventoryItem("wood", wood);
        player.getInventory().removeInventoryItem("stone", stone);
        return true;
    }
}
