package org.example.controllers;

import org.example.models.*;
import org.example.models.VillagePackage.Store;

public class StoreMenuController extends Controller {
    public Result showAllProducts() {
        Store store = currentStore();
        if (store == null){
            return new Result(false, "You are not in a store.");
        }
        return store.showAllProducts();
    }
    public Result showAllAvailableProducts() {
        Store store = currentStore();
        if (store == null){
            return new Result(false, "You are not in a store.");
        }
        return store.showAllAvailableProducts();
    }
    public Result purchase(String productName, String countString) {
        Store store = currentStore();
        if (store == null){
            return new Result(false, "You are not in a store.");
        }
        if (countString == null || countString.isEmpty()) {
            return store.purchase(productName, 1);
        }
        int count = Integer.parseInt(countString);
        return store.purchase(productName, count);
    }
    private Store currentStore(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                boolean check = false;
                for (Tile tile : objectt.getTiles()) {
                    if (player.getX() == tile.getX() && player.getY() == tile.getY()) {
                        check = true;
                    }
                }
                if (check) return ((Store) objectt);
            }
        }
        return null;
    }

}
