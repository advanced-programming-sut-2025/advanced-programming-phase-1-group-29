package org.example.controllers;

import org.example.models.App;
import org.example.models.FarmPackage.Farm;
import org.example.models.Map;
import org.example.models.Result;
import org.example.models.enums.Menu;

public class MapSelectionMenuController {
    public Result gameMap(String mapNumber) {
        int number = Integer.parseInt(mapNumber);
        if (number > 4 || number <= 0)
            return new Result(false, "Invalid farm number");
        Map map = App.getCurrentGame().getMap();
        for (Farm farm : map.getFarms()) {
            if (number == farm.getNumber()) return new Result(false, "The farm is already taken");
        }
        map.getFarms().add(map.getCreatedFarms().get(number - 1));
        if (map.getFarms().size() == App.getCurrentGame().players.size()) App.setCurrentMenu(Menu.GameMenu);
        return new Result(true, "Farm" + number + " is assigned to you.");
    }
}
