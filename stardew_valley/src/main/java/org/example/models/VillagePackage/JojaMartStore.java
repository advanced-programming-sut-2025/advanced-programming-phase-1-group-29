package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;
import org.example.models.enums.Season;

public class JojaMartStore extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 23;
    private boolean open = false;
    private boolean[] welcome = new boolean[5];
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Joja Mart!");
    }
    public JojaMartStore() {
        super();
        addProducts();
        for (int i = 0; i < 5; i++) {
            welcome[i] = false;
        }
    }
    @Override
    public boolean isWelcome(int index) {
        return welcome[index];
    }
    @Override
    public void setWelcome(boolean welcome, int index) {
        this.welcome[index] = welcome;
    }
    @Override
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
            super.addProduct(new InventoryItem("ParsnipSeeds", 25), 5);
            super.addProduct(new InventoryItem("BeanStarter", 75), 5);
            super.addProduct(new InventoryItem("CauliflowerSeeds", 100), 5);
            super.addProduct(new InventoryItem("PotatoSeeds", 62), 5);
            super.addProduct(new InventoryItem("StrawberrySeeds", 100), 5);
            super.addProduct(new InventoryItem("TulipBulb", 25), 5);
            super.addProduct(new InventoryItem("KaleSeeds", 87), 5);
            super.addProduct(new InventoryItem("CoffeeBeans", 200), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Summer)) {
            super.addProduct(new InventoryItem("TomatoSeeds", 62), 5);
            super.addProduct(new InventoryItem("PepperSeeds", 50), 5);
            super.addProduct(new InventoryItem("WheatSeeds", 12), 10);
            super.addProduct(new InventoryItem("SummerSquashSeeds", 10), 10);
            super.addProduct(new InventoryItem("RadishSeeds", 50), 5);
            super.addProduct(new InventoryItem("MelonSeeds", 100), 5);
            super.addProduct(new InventoryItem("HopsStarter", 75), 5);
            super.addProduct(new InventoryItem("PoppySeeds", 125), 5);
            super.addProduct(new InventoryItem("SpangleSeeds", 62), 5);
            super.addProduct(new InventoryItem("StarfruitSeeds", 400), 5);
            super.addProduct(new InventoryItem("CoffeeBeans", 200), 1);
            super.addProduct(new InventoryItem("SunflowerSeeds", 125), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Fall)) {
            super.addProduct(new InventoryItem("CornSeeds", 187), 5);
            super.addProduct(new InventoryItem("EggplantSeeds", 25), 5);
            super.addProduct(new InventoryItem("PumpkinSeeds", 125), 5);
            super.addProduct(new InventoryItem("BroccoliSeeds", 15), 5);
            super.addProduct(new InventoryItem("AmaranthSeeds", 87), 5);
            super.addProduct(new InventoryItem("GrapeStarter", 75), 5);
            super.addProduct(new InventoryItem("BeetSeeds", 20), 5);
            super.addProduct(new InventoryItem("YamSeeds", 75), 5);
            super.addProduct(new InventoryItem("BokChoySeeds", 62), 5);
            super.addProduct(new InventoryItem("CranberrySeeds", 300), 5);
            super.addProduct(new InventoryItem("SunflowerSeeds", 125), 5);
            super.addProduct(new InventoryItem("FairySeeds", 250), 5);
            super.addProduct(new InventoryItem("RareSeed", 1000), 1);
            super.addProduct(new InventoryItem("WheatSeeds", 12), 5);
        }

        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Winter)) {
            super.addProduct(new InventoryItem("PowdermelonSeeds", 20), 10);
        }
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
