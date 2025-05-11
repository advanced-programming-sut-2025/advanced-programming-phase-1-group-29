package org.example.models;

public class TheStardropSaloon extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to The Stardrop Shop!");
    }
    public TheStardropSaloon() {
        addProducts();
    }
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
        super.addProduct(new InventoryItem("Hashbrowns Recipe", 50), 1);
        super.addProduct(new InventoryItem("Omelet Recipe", 100), 1);
        super.addProduct(new InventoryItem("Pancakes Recipe", 100), 1);
        super.addProduct(new InventoryItem("Bread Recipe", 100), 1);
        super.addProduct(new InventoryItem("Tortilla Recipe", 100), 1);
        super.addProduct(new InventoryItem("Pizza Recipe", 150), 1);
        super.addProduct(new InventoryItem("Maki Roll Recipe", 300), 1);
        super.addProduct(new InventoryItem("Triple Shot Espresso Recipe", 5000), 1);
        super.addProduct(new InventoryItem("Cookie Recipe", 300), 1);
    }
}
