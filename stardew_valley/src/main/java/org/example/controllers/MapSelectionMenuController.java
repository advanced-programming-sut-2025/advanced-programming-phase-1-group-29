package org.example.controllers;

import org.example.models.App;
import org.example.models.FarmPackage.Farm;
import org.example.models.Game;
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
        if (map.getFarms().size() == App.getCurrentGame().players.size()){
            App.setCurrentMenu(Menu.GameMenu);
            Game game = App.getCurrentGame();
            App.getCurrentGame().getPlayers().get(0).setX(game.getMap().getFarms().get(0).getCottage().getTiles().get(5).getX());
            App.getCurrentGame().getPlayers().get(0).setY(game.getMap().getFarms().get(0).getCottage().getTiles().get(5).getY());
            App.getCurrentGame().getPlayers().get(1).setX(game.getMap().getFarms().get(1).getCottage().getTiles().get(4).getX());
            App.getCurrentGame().getPlayers().get(1).setY(game.getMap().getFarms().get(1).getCottage().getTiles().get(4).getY());
            App.getCurrentGame().getPlayers().get(2).setX(game.getMap().getFarms().get(2).getCottage().getTiles().get(3).getX());
            App.getCurrentGame().getPlayers().get(2).setY(game.getMap().getFarms().get(2).getCottage().getTiles().get(3).getY());
            App.getCurrentGame().getPlayers().get(3).setX(game.getMap().getFarms().get(3).getCottage().getTiles().get(2).getX());
            App.getCurrentGame().getPlayers().get(3).setY(game.getMap().getFarms().get(3).getCottage().getTiles().get(2).getY());
        }
        return new Result(true, "Farm" + number + " is assigned to you.");
    }
}
