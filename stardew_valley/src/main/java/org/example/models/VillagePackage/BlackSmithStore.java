package org.example.models.VillagePackage;

import org.example.models.InventoryItem;
import org.example.models.Result;

public class BlackSmithStore extends Store {
    public BlackSmithStore() {
        super();
        super.addProduct(new InventoryItem("CopperOre", 75), 100000000);
        super.addProduct(new InventoryItem("IronOre", 150), 100000000);
        super.addProduct(new InventoryItem("Coal", 150), 100000000);
        super.addProduct(new InventoryItem("GoldOre", 400), 100000000);
    }
    @Override
    public void resetCapacity(){}
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Black Smith!");
    }
}
