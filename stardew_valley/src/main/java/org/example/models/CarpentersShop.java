package org.example.models;

public class CarpentersShop extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Carpenter's shop!");
    }
    public CarpentersShop() {
        super();
        addProducts();
    }
    public void resetCapacity(){
        super.resetProducts();
    }
    private void addProducts(){
        super.addProduct(new InventoryItem("Wood", 10), 100000000);
        super.addProduct(new InventoryItem("Stone", 20), 100000000);
    }

}
