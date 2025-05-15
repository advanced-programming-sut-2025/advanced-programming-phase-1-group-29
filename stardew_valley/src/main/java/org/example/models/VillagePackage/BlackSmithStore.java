package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Player;
import org.example.models.Result;

public class BlackSmithStore extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 16;
    private boolean open = false;
    private boolean welcome = false;

    public BlackSmithStore() {
        super();
        super.addProduct(new InventoryItem("copperOre", 75), 100000000);
        super.addProduct(new InventoryItem("ironOre", 150), 100000000);
        super.addProduct(new InventoryItem("coal", 150), 100000000);
        super.addProduct(new InventoryItem("goldOre", 400), 100000000);
        super.addProduct(new InventoryItem("copperTool", 2000), 1);
        super.addProduct(new InventoryItem("steelTool", 5000), 1);
        super.addProduct(new InventoryItem("goldTool", 10000), 1);
        super.addProduct(new InventoryItem("iridiumTool", 25000), 1);
        super.addProduct(new InventoryItem("copperTrashCan", 1000), 1);
        super.addProduct(new InventoryItem("steelTrashCan", 2500), 1);
        super.addProduct(new InventoryItem("goldTrashCan", 5000), 1);
        super.addProduct(new InventoryItem("iridiumTrashCan", 12500), 1);
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
    @Override
    public Result purchase(String productName, int quantity) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (productName.equalsIgnoreCase("CopperTool")) {
            if (player.getInventory().getNumberOfInventoryItem("copperBar") < 5){
                return new Result(false, "You don't have enough copper bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("copperBar", 5);
        }
        else if (productName.equalsIgnoreCase("SteelTool")) {
            if (player.getInventory().getNumberOfInventoryItem("ironBar") < 5){
                return new Result(false, "You don't have enough iron bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("ironBar", 5);
        }
        else if (productName.equalsIgnoreCase("GoldTool")) {
            if (player.getInventory().getNumberOfInventoryItem("goldBar") < 5){
                return new Result(false, "You don't have enough gold bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("goldBar", 5);
        }
        else if (productName.equalsIgnoreCase("IridiumTool")) {
            if (player.getInventory().getNumberOfInventoryItem("iridiumBar") < 5){
                return new Result(false, "You don't have enough iridium bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("iridiumBar", 5);
        }
        else if (productName.equalsIgnoreCase("CopperTrashCan")) {
            if (player.getInventory().getNumberOfInventoryItem("copperBar") < 5){
                return new Result(false, "You don't have enough copper bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("copperBar", 5);
        }
        else if (productName.equalsIgnoreCase("SteelTrashCan")) {
            if (player.getInventory().getNumberOfInventoryItem("ironBar") < 5){
                return new Result(false, "You don't have enough iron bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("ironBar", 5);
        }
        else if (productName.equalsIgnoreCase("GoldTrashCan")) {
            if (player.getInventory().getNumberOfInventoryItem("goldBar") < 5){
                return new Result(false, "You don't have enough gold bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("goldBar", 5);
        }
        else if (productName.equalsIgnoreCase("IridiumTrashCan")) {
            if (player.getInventory().getNumberOfInventoryItem("iridiumBar") < 5){
                return new Result(false, "You don't have enough iridium bar in your inventory.");
            }
            player.getInventory().removeInventoryItem("iridiumBar", 5);
        }
        return super.purchase(productName, quantity);
    }
}
