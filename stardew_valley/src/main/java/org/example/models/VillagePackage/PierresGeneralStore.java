package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;
import org.example.models.enums.InventoryType;
import org.example.models.enums.Season;

public class PierresGeneralStore extends Store {
    private final static int startWorkingHours = 9;
    private final static int endWorkingHours = 17;
    private boolean open = false;
    private boolean[] welcome = new boolean[5];
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Pierre's General!");
    }
    public PierresGeneralStore() {
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
    private void addProducts() {
        super.addProduct(new InventoryItem("Rice", 200), 100000000);
        super.addProduct(new InventoryItem("WheatFlour", 100), 100000000);
        super.addProduct(new InventoryItem("Sugar", 100), 100000000);
        super.addProduct(new InventoryItem("Oil", 200), 100000000);
        super.addProduct(new InventoryItem("Vinegar", 200), 100000000);
        super.addProduct(new InventoryItem("DeluxeRetainingSoil", 150), 100000000);
        super.addProduct(new InventoryItem("GrassStarter", 100), 100000000);
        super.addProduct(new InventoryItem("SpeedGro", 100), 100000000);
        super.addProduct(new InventoryItem("AppleSapling", 4000), 100000000);
        super.addProduct(new InventoryItem("ApricotSapling", 2000), 100000000);
        super.addProduct(new InventoryItem("CherrySapling", 3400), 100000000);
        super.addProduct(new InventoryItem("OrangeSapling", 4000), 100000000);
        super.addProduct(new InventoryItem("PeachSapling", 6000), 100000000);
        super.addProduct(new InventoryItem("PomegranateSapling", 6000), 100000000);
        super.addProduct(new InventoryItem("BasicRetainingSoil", 100), 100000000);
        super.addProduct(new InventoryItem("QualityRetainingSoil", 150), 100000000);
        super.addProduct(new InventoryItem("Bouquet", 1000), 2);
        super.addProduct(new InventoryItem("WeddingRing", 10000), 2);
        super.addProduct(new InventoryItem("Dehydrator", 10000), 1);
        super.addProduct(new InventoryItem("GrassStarter", 1000), 1);
        super.addProduct(new InventoryItem("LargePack", 2000), 1);
        super.addProduct(new InventoryItem("DeluxePack", 10000), 1);
        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Spring)) {
            super.addProduct(new InventoryItem("ParsnipSeeds", 30), 5);
            super.addProduct(new InventoryItem("BeanStarter", 90), 5);
            super.addProduct(new InventoryItem("CauliflowerSeeds", 120), 5);
            super.addProduct(new InventoryItem("PotatoSeeds", 75), 5);
            super.addProduct(new InventoryItem("TulipBulb", 30), 5);
            super.addProduct(new InventoryItem("KaleSeeds", 105), 5);
            super.addProduct(new InventoryItem("JazzSeeds", 45), 5);
            super.addProduct(new InventoryItem("GarlicSeeds", 60), 5);
            super.addProduct(new InventoryItem("RiceShoot", 60), 5);
        }
        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Summer)) {
            super.addProduct(new InventoryItem("MelonSeeds", 120), 5);
            super.addProduct(new InventoryItem("TomatoSeeds", 75), 5);
            super.addProduct(new InventoryItem("BlueberrySeeds", 120), 5);
            super.addProduct(new InventoryItem("PepperSeeds", 60), 5);
            super.addProduct(new InventoryItem("WheatSeeds", 15), 5);
            super.addProduct(new InventoryItem("RadishSeeds", 60), 5);
            super.addProduct(new InventoryItem("PoppySeeds", 150), 5);
            super.addProduct(new InventoryItem("SpangleSeeds", 75), 5);
            super.addProduct(new InventoryItem("HopsStarter", 90), 5);
            super.addProduct(new InventoryItem("CornSeeds", 225), 5);
            super.addProduct(new InventoryItem("SunflowerSeeds", 300), 5);
            super.addProduct(new InventoryItem("RedCabbageSeeds", 150), 5);
        }
        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.Fall)) {
            super.addProduct(new InventoryItem("EggplantSeeds", 30), 5);
            super.addProduct(new InventoryItem("CornSeeds", 225), 5);
            super.addProduct(new InventoryItem("PumpkinSeeds", 150), 5);
            super.addProduct(new InventoryItem("BokChoySeeds", 75), 5);
            super.addProduct(new InventoryItem("YamSeeds", 90), 5);
            super.addProduct(new InventoryItem("CranberrySeeds", 360), 5);
            super.addProduct(new InventoryItem("SunflowerSeeds", 300), 5);
            super.addProduct(new InventoryItem("FairySeeds", 300), 5);
            super.addProduct(new InventoryItem("AmaranthSeeds", 105), 5);
            super.addProduct(new InventoryItem("GrapeStarter", 90), 5);
            super.addProduct(new InventoryItem("WheatSeeds", 15), 5);
            super.addProduct(new InventoryItem("ArtichokeSeeds", 45), 5);
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
