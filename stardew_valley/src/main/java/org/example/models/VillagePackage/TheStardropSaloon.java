package org.example.models.VillagePackage;

import org.example.models.InventoryItem;
import org.example.models.Result;

public class TheStardropSaloon extends Store {
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to The Stardrop Shop!");
    }
    public TheStardropSaloon() {
        super();
        addProducts();
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
}
