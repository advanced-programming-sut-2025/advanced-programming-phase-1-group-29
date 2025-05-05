package org.example.controllers;

import org.example.models.*;
import org.example.models.enums.Menu;

public class GameMenuController extends Controller{

    public Result menuEnter() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "Now you are in Main Menu.");
    }

    public void exitGame(){
        App.setCurrentMenu(Menu.ExitMenu);
    }
    public Result time(){
        return new Result(true, "It's " + App.getCurrentGame().getCurrentTime().getTime() + " o'clock");
    }
    public Result date(){
        return new Result(true, "It's day " + App.getCurrentGame().getCurrentTime().getDay() + " of " + App.getCurrentGame().getCurrentTime().getSeason());
    }
    public Result dateTime(){
        return new Result(true, "It's " + App.getCurrentGame().getCurrentTime().getTime() + " o'clock on day " + App.getCurrentGame().getCurrentTime().getDay() + " of " + App.getCurrentGame().getCurrentTime().getSeason());
    }
    public Result dayOfTheWeek(){
        int day = App.getCurrentGame().getCurrentTime().getDay();
        return switch (day % 7) {
            case 1 -> new Result(true, "Saturday");
            case 2 -> new Result(true, "Sunday");
            case 3 -> new Result(true, "Monday");
            case 4 -> new Result(true, "Tuesday");
            case 5 -> new Result(true, "Wednesday");
            case 6 -> new Result(true, "Thursday");
            default -> new Result(true, "Friday");
        };
    }

    public Result season() {
        return new Result(
                true,
                "They current season is " + App.getCurrentGame().getCurrentTime().getSeason()
        );
    }

    public Result energyShow() {
        Game game = App.getCurrentGame();
        return new Result(true, "Energy: " + game.players.get(game.getTurn()).getEnergy());
    }

    public void energySet(String amount) {
        int value = Integer.parseInt(amount);
        App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).setEnergy(value);
    }

    public void energyUnlimited() {
        App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).setEnergyUnlimited(true);
    }

    public Result inventoryShow() {
        Inventory inventory = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getInventory();
        StringBuilder result = new StringBuilder("Your inventory includes:\n");
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            result.append(inventoryItem.toString());
            result.append("\n");
        }
        return new Result(true, result.toString());
    }
}
