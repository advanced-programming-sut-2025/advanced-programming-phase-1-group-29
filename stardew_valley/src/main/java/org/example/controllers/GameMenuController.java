package org.example.controllers;

import org.example.models.*;
import org.example.models.Map;
import org.example.models.Objectt;
import org.example.models.enums.*;

import java.util.*;

public class GameMenuController extends Controller{

    public Result menuEnter() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "Now you are in Main Menu.");
    }

    public Result exitGame(){
        if(!App.getCurrentGame().isMainPlayerPlaying()){
            return new Result(false, "Sorry, you cannot exit the game.");
        }
        App.setCurrentMenu(Menu.ExitMenu);
        return new Result(true, "");
    }

    public Result walk(){
        //TODO

    }

    public Result time(){
        return new Result(
                true,
                "It's " + App.getCurrentGame().getCurrentTime().getTime() + " o'clock");
    }

    public Result date(){
        return new Result(
                true,
                "It's day " + App.getCurrentGame().getCurrentTime().getDay() +
                        " of " + App.getCurrentGame().getCurrentTime().getSeason());
    }

    public Result dateTime(){
        return new Result(
                true,
                "It's " + App.getCurrentGame().getCurrentTime().getTime() +
                        " o'clock on day " + App.getCurrentGame().getCurrentTime().getDay() +
                        " of " + App.getCurrentGame().getCurrentTime().getSeason());
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
                "The current season is " + App.getCurrentGame().getCurrentTime().getSeason()
        );
    }

    public Result weather() {
        return new Result(
                true,
                "It is " + App.getCurrentGame().getWeather()
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
            result.append(inventoryItem.getName());
            result.append("\n");
        }
        return new Result(true, result.toString());
    }

    public Result toolsEquip(String name) {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Inventory inventory = player.getInventory();
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (inventoryItem instanceof Tool) {
                if (inventoryItem.getName().equals(name)) {
                    player.setCurrentTool((Tool) inventoryItem);
                    return new Result(true, "Now you are equipped with " + name);
                }
            }
        }
        return new Result(false, "Invalid tool");
    }

    public Result toolsShowCurrent() {
        Tool tool = App.getCurrentGame().players.get(App.getCurrentGame().getTurn()).getCurrentTool();
        if (tool != null)
            return new Result(true, "The current tool in your hand is " + tool.getName());
        return new Result(false, "There are no tools in your hand.");
    }

    public Result toolsShowAvailable() {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        Inventory inventory = player.getInventory();
        StringBuilder result = new StringBuilder("Available tools in your backpack:\n");
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (inventoryItem instanceof Tool) {
                result.append(inventoryItem.getName());
                result.append("\n");
            }
        }
        return new Result(true, result.toString());
    }


    public Result printMap(String xString, String yString, String sizeString) {
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        int size = Integer.parseInt(sizeString);
        if (x < 0 || y < 0 || x + size >= Map.getXRange() || y + size >= Map.getYRange()) {
            return new Result(false, "Invalid size");
        }
        Map map = App.getCurrentGame().getMap();
        char[][] mapToPrint = new char[Map.getXRange()][Map.getYRange()];
        for (Farm farm : map.getFarms()) {
            for (Objectt object : farm.getObjects()) {
                for (Tile tile : object.getTiles()) {
                    mapToPrint[tile.getX()][tile.getY()] = tile.getDisplay();
                }
            }
        }
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int xx = x; xx <= x + size; xx++) {
            StringBuilder line = new StringBuilder();
            for (int yy = y; yy <= y + size; yy++) {
                line.append(mapToPrint[xx][yy]);
            }
            stringJoiner.add(line.toString());
        }
        return new Result(true, stringJoiner.toString());
    }


    public void nextTurn() {
        App.getCurrentGame().nextTurn();
    }

    public Result inventoryTrash(String name, String amount) {
        Player player = App.getCurrentGame().getPlayers().get(App.getCurrentGame().getTurn());
        Inventory inventory = player.getInventory();
        InventoryItem item = null;
        int number = 0;
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (name.equals(inventoryItem.getName())) {
                if (amount.isEmpty()) number = inventory.getInventoryItems().get(inventoryItem);
                else number = Integer.parseInt(amount);
                if (number > inventory.getInventoryItems().get(inventoryItem))
                    return new Result(false, "You don't have this amount of " + name);
                item = inventoryItem;
                break;
            }
        }
        if (item != null) {
            inventory.getInventoryItems().put(item, inventory.getInventoryItems().get(item) - number);
            int coins = player.getTrashCan().getReturnValuePercentage() * item.getPrice() / 100;
            player.addCoins(coins);
            return new Result(true, number + " of " + name + " deleted from your inventory. " + coins + " coins returned.");
        }
        return new Result(false, "This item doesn't exist in your inventory");
    }

    public Result helpReadingMap(){
        StringBuilder result = new StringBuilder();
        result.append("Cottage: C\n");
        result.append("Greenhouse: G\n");
        result.append("Quarry : Q\n");
        result.append("Lake : L\n");
        return new Result(true, result.toString());
    }

    public Result cheatAdvanceTime(String timeString) {
        int h = Integer.parseInt(timeString);
        for (int i = 0; i < h; i++){
            nextTurn();
        }
        return dateTime();
    }

    public Result cheatAdvanceDate(String dateString) {
        int h = Integer.parseInt(dateString);
        for (int i = 0; i < 24 * h; i++){
            nextTurn();
        }
        return dateTime();
    }

    public Result toolsUse(String direction) {
        HashMap<String, ArrayList<Integer>> directions = new HashMap<>() {{
            put("u", new ArrayList<>(List.of(0, 1)));
            put("d", new ArrayList<>(List.of(0, -1)));
            put("r", new ArrayList<>(List.of(1, 0)));
            put("l", new ArrayList<>(List.of(-1, 0)));
            put("ur", new ArrayList<>(List.of(1, 1)));
            put("ul", new ArrayList<>(List.of(-1, 1)));
            put("dr", new ArrayList<>(List.of(1, -1)));
            put("dl", new ArrayList<>(List.of(-1, -1)));
        }};
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        if (!directions.containsKey(direction))
            return new Result(false, "Invalid direction");
        int x = player.getX() + directions.get(direction).get(0);
        int y = player.getY() + directions.get(direction).get(1);
        return player.getCurrentTool().useTool(x, y);
    }

    public Result craftInfo(String name) {
        name = name.replaceAll("\\s+", "_").toUpperCase();
        try {
            return new Result(true, CropEnum.valueOf(name).toString());
        } catch (IllegalArgumentException e) {
            return new Result(false, "Invalid crop name");
        }
    }

    public Result cookingRefrigerator(String action, String item){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
//        if(!atHome){
//            return new Result(false, "You are not at the home");
//        }
//        if(!food){
//            return new Result(false, "Not eatable!");
//        }

        Game game = App.getCurrentGame();
        Farm farm = game.getMap().getFarms().get(game.getTurn());
        Cottage cottage = farm.getCottage();
        Refrigerator refrigerator = cottage.getRefrigerator();
        if(action.equals("put")){
            InventoryItem inventoryItem = inventory.findInventoryItem(item);
            if(inventoryItem == null){
                return new Result(false, "You don't have this item in your inventory");
            }
            refrigerator.addItem(inventoryItem, inventory.getInventoryItems().get(inventoryItem));
            inventory.getInventoryItems().remove(inventoryItem);
        }
        if(action.equals("pick")){
            if(refrigerator.getQuantity(item) == 0){
                return new Result(false, "You don't have this item in your refrigerator");
            }
            InventoryItem inventoryItem = refrigerator.findItem(item);
            inventory.addInventoryItem(item, refrigerator.getQuantity(item), inventoryItem.getPrice());
            refrigerator.removeItem(item, refrigerator.getQuantity(item));
        }
        return new Result(true, "moved successfully");
    }

    public Result cookingShowRecipes(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Your cooking recipes are: ");
//        for (FoodRecipe recipe : "?") {
//            joiner.add(recipe.getFood().getName());
//        }
        return new Result(true, joiner.toString());
    }

    public Result cookingPrepare(String recipeName){
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Farm farm = game.getMap().getFarms().get(game.getTurn());
        Cottage cottage = farm.getCottage();

//        if(!atHome){
//            return new Result(false, "You are not at the home");
//        }

        Refrigerator refrigerator = cottage.getRefrigerator();
        Inventory inventory = player.getInventory();

        FoodRecipe recipe = FoodRecipe.getRecipeByName(recipeName);

        if(recipe == null){
            return new Result(false, "This recipe doesn't exist");
        }
//        if(balad nabood){
//            return new Result(false, "You don't have this recipe");
//        }
        Food food = recipe.getFood();
        for (String itemName : food.getIngredients().keySet()) {
            int count = inventory.getNumberOfInventoryItem(itemName) + refrigerator.getQuantity(itemName);
            if(count < food.getIngredients().get(itemName)) {
                return new Result(false, "You don't have enough ingredients");
            }
        }
        if(inventory.isFull()){
            return new Result(false, "Your inventory is full");
        }
        for (String itemName : food.getIngredients().keySet()) {
            int amount = food.getIngredients().get(itemName);
            int inventoryStock = inventory.getNumberOfInventoryItem(itemName);
            inventory.removeInventoryItem(food.getName(), Integer.min(inventoryStock, amount));
            if(amount > inventoryStock) {
                refrigerator.removeItem(itemName, amount - inventoryStock);
            }
        }
        inventory.addInventoryItem(food.getName(), 1, food.getSellPrice());
        player.reduceEnergy(3);
        return new Result(true, food.getName() + " is prepared");
    }

    public Result eat(String foodName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
//        if(!atHome){
//            return new Result(false, "You are not at the home");
//        }
        Food food = Food.getByName(foodName);
        if(food == null){
            return new Result(false, "You can't eat this food");
        }
        Inventory inventory = player.getInventory();
        InventoryItem foodItem = inventory.findInventoryItem(food.getName());
        if(foodItem == null){
            return new Result(false, "You don't have this food in your inventory");
        }
        player.addEnergy(food.getEnergy());
        inventory.removeInventoryItem(food.getName(), 1);
        /// /// buff??
        inventory.getInventoryItems().remove(foodItem);
        return new Result(true, "Yum yum yum yum");
    }

    public Result fishing(String fishingPoleName) {
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
//       if(!atLake){
//            return new Result(false, "You are not near the beach");
//        }
        FishingPoleType fishingPoleType = FishingPoleType.getFishingPoleByName(fishingPoleName);
        if(fishingPoleType == null){
            return new Result(false, "This fishing pole doesn't exist");
        }
        FishingPole fishingPole = null;
        for(InventoryItem inventoryItem : inventory.getInventoryItems().keySet()){
            if(inventoryItem.getName().equals(fishingPoleType.getName())){
                fishingPole = (FishingPole) inventoryItem;
            }
        }
        if(fishingPole == null){
            return new Result(false, "You don't have this fishing pole");
        }
        Random rand = new Random();
        //int amount = Double.rand.nextInt(2) * game.getWeather().getFishingRate() * (player.getFishingLevel() + 2);
        return new Result(true, "");
    }
}
