package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.InventoryItem;
import org.example.models.Result;

public class TheStardropSaloon extends Store {

    private final static int startWorkingHours = 12;
    private final static int endWorkingHours = 24;
    private boolean open = false;
    private boolean welcome = false;
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to The Stardrop Shop!");
    }
    public TheStardropSaloon() {
        super();
        addProducts();
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
    public void resetCapacity(){
        super.resetProducts();
        addProducts();
    }
    private void addProducts(){
        super.addProduct(new InventoryItem("Beer", 400), 100000000);
        super.addProduct(new InventoryItem("Salad", 220), 100000000);
        super.addProduct(new InventoryItem("Bread", 120), 100000000);
        super.addProduct(new InventoryItem("Spaghetti", 240), 100000000);
        super.addProduct(new InventoryItem("Pizza", 600), 100000000);
        super.addProduct(new InventoryItem("Coffee", 300), 100000000);
        super.addProduct(new InventoryItem("HashbrownsRecipe", 50), 1);
        super.addProduct(new InventoryItem("OmeletRecipe", 100), 1);
        super.addProduct(new InventoryItem("PancakesRecipe", 100), 1);
        super.addProduct(new InventoryItem("BreadRecipe", 100), 1);
        super.addProduct(new InventoryItem("TortillaRecipe", 100), 1);
        super.addProduct(new InventoryItem("PizzaRecipe", 150), 1);
        super.addProduct(new InventoryItem("MakiRollRecipe", 300), 1);
        super.addProduct(new InventoryItem("TripleShotEspressoRecipe", 5000), 1);
        super.addProduct(new InventoryItem("CookieRecipe", 300), 1);
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
