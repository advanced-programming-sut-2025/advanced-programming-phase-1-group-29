package org.example.controllers;

import com.sun.source.tree.ReturnTree;
import org.example.models.*;
import org.example.models.Map;
import org.example.models.Objectt;
import org.example.models.VillagePackage.NPCHouse;
import org.example.models.VillagePackage.Store;
import org.example.models.enums.*;

import java.util.*;

import static java.lang.Math.abs;

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

    public Result cheatAddDollars(String amountString){
        int amount = Integer.parseInt(amountString);
        App.getCurrentGame().getCurrentPlayer().addCoins(amount);
        return new Result(true, "you now have " + App.getCurrentGame().getCurrentPlayer().getCoins() + " dollars.");
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
        App.getCurrentGame().getCurrentPlayer().setEnergy(value);
    }

    public void energyUnlimited() {
        App.getCurrentGame().getCurrentPlayer().setEnergyUnlimited(true);
    }

    public Result inventoryShow() {
        Inventory inventory = App.getCurrentGame().getCurrentPlayer().getInventory();
        StringBuilder result = new StringBuilder("Your inventory includes:\n");
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            result.append(inventoryItem.getName());
            result.append("\n");
        }
        return new Result(true, result.toString());
    }

    public Result toolsEquip(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
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
        Tool tool = App.getCurrentGame().getCurrentPlayer().getCurrentTool();
        if (tool != null)
            return new Result(true, "The current tool in your hand is " + tool.getName());
        return new Result(false, "There are no tools in your hand.");
    }

    public Result toolsShowAvailable() {
        Player player = App.getCurrentGame().getCurrentPlayer();
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


    public Result walk(String xString, String yString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if(player.getEnergy() == 0) {
            return new Result(false, "You are unconscious");
        }
        int x2 = Integer.parseInt(xString);
        int y2 = Integer.parseInt(yString);
        int x1 = player.getX();
        int y1 = player.getY();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] walkable = new boolean[Map.getXRange()][Map.getYRange()];
        //TODO
        // fill walkable
        int[][] distance = new int[Map.getXRange()][Map.getYRange()];
        for (int i = 0; i < Map.getXRange(); i++) {
            for (int j = 0; j < Map.getYRange(); j++) {
                walkable[i][j] = true;
                distance[i][j] = -1;
            }
        }
        distance[x1][y1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x1 * Map.getYRange() + y1);
        while(!queue.isEmpty()) {
            int top = queue.poll();
            int x = top / Map.getYRange();
            int y = top % Map.getYRange();
            for (int i = 0; i < 4; i ++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= Map.getXRange() || yy < 0 || yy >= Map.getYRange()) {
                    continue;
                }
                if(walkable[xx][yy] && (distance[xx][yy] == -1 || distance[xx][yy] < distance[x][y] + 1)) {
                    distance[xx][yy] = distance[x][y] + 1;
                    queue.add(xx * Map.getYRange() + yy);
                }
            }
        }
        if(distance[x2][y2] == -1) {
            return new Result(true, "there is no way to walk");
        }
        int energyNeeded = distance[x2][y2] / 20;
        //TODO
        // ask user
        if(energyNeeded > player.getEnergy()) {
            player.setEnergy(0);
            return new Result(true, "You are unconscious!");
        }
        player.reduceEnergy(energyNeeded);
        player.setX(x2);
        player.setY(y2);
        //TODO
        // check if the store is open before entering it (each instance of Store has a isOpen() function that returns a boolean
        // check not to be in the same place an npc is
        StringBuilder result = new StringBuilder();
        result.append("You are at " + x2 + ", " + y2 + ".");
        // in tike check mikone age vase avalin bar varede ye store shode bashe mige welcome
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                boolean check = false;
                for (Tile tile : ((Store) objectt).getTiles()) {
                    if (tile.getX() == x2 && tile.getY() == y2) {
                        check = true;
                    }
                }
                if (check) {
                    if (!((Store) objectt).isWelcome()){
                        result.append("\n");
                        result.append(((Store) objectt).welcomeMessage());
                    }
                    ((Store) objectt).setWelcome(true);
                }
            }
        }
        return new Result(true, result.toString());
    }


    public void printMap(String xString, String yString, String sizeString) {
        //TODO
        //print NPCs
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        int size = Integer.parseInt(sizeString);
        if (x < 0 || y < 0 || x + size >= Map.getXRange() || y + size >= Map.getYRange()) {
            System.out.println("Invalid Size");
            return;
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
        return;
    }


    public void nextTurn() {
        App.getCurrentGame().nextTurn();
    }

    public Result inventoryTrash(String name, String amount) {
        Player player = App.getCurrentGame().getCurrentPlayer();
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

    private ArrayList<Integer> getDirection(String direction) {
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
        if (!directions.containsKey(direction)) return null;
        return directions.get(direction);
    }

    public Result toolsUse(String direction) {
        ArrayList<Integer> directionConst = getDirection(direction);
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        if (directionConst == null)
            return new Result(false, "Invalid direction");
        int x = player.getX() + directionConst.get(0);
        int y = player.getY() + directionConst.get(1);
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
        //TODO
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
        for (FoodRecipe recipe : player.getFoodRecipeList()) {
            joiner.add(recipe.getFood().getName());
        }
        return new Result(true, joiner.toString());
    }

    public Result cookingPrepare(String recipeName){
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Farm farm = game.getMap().getFarms().get(game.getTurn());
        Cottage cottage = farm.getCottage();
        //TODO
//        if(!atHome){
//            return new Result(false, "You are not at the home");
//        }

        Refrigerator refrigerator = cottage.getRefrigerator();
        Inventory inventory = player.getInventory();

        FoodRecipe recipe = FoodRecipe.getRecipeByName(recipeName);

        if(recipe == null){
            return new Result(false, "This recipe doesn't exist");
        }
        if(!player.getFoodRecipeList().contains(recipe)){
            return new Result(false, "You don't have this recipe");
        }
        FoodEnum foodEnum = recipe.getFood();
        for (String itemName : foodEnum.getIngredients().keySet()) {
            int count = inventory.getNumberOfInventoryItem(itemName) + refrigerator.getQuantity(itemName);
            if(count < foodEnum.getIngredients().get(itemName)) {
                return new Result(false, "You don't have enough ingredients");
            }
        }
        if(inventory.getCapacity() == 0){
            return new Result(false, "Your inventory is full");
        }
        for (String itemName : foodEnum.getIngredients().keySet()) {
            int amount = foodEnum.getIngredients().get(itemName);
            int inventoryStock = inventory.getNumberOfInventoryItem(itemName);
            inventory.removeInventoryItem(foodEnum.getName(), Integer.min(inventoryStock, amount));
            if(amount > inventoryStock) {
                refrigerator.removeItem(itemName, amount - inventoryStock);
            }
        }
        inventory.addInventoryItem(foodEnum.getName(), 1, foodEnum.getSellPrice());
        player.reduceEnergy(3);
        return new Result(true, foodEnum.getName() + " is prepared");
    }

    public Result eat(String foodName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        //TODO
//        if(!atHome){
//            return new Result(false, "You are not at the home");
//        }
        FoodEnum foodEnum = FoodEnum.getByName(foodName);
        if(foodEnum == null){
            return new Result(false, "You can't eat this food");
        }
        Inventory inventory = player.getInventory();
        InventoryItem foodItem = inventory.findInventoryItem(foodEnum.getName());
        if(foodItem == null){
            return new Result(false, "You don't have this food in your inventory");
        }
        player.addEnergy(foodEnum.getEnergy());
        inventory.removeInventoryItem(foodEnum.getName(), 1);
        //TODO
        /// /// buff??
        inventory.getInventoryItems().remove(foodItem);
        return new Result(true, "Yum yum yum yum");
    }

    public Result fishing(String fishingPoleName) {
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        //TODO
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
        int amount = Math.min((int) (Math.ceil(rand.nextDouble(2) * game.getWeather().getFishingRate() * (player.getFishingLevel() + 2))), 6);
        double quality = rand.nextDouble(2) * (player.getFishingLevel() + 2) * fishingPoleType.getQuantityRate() / (7 - amount);
        amount = Math.min(amount, inventory.getCapacity());
        for (int i = 0; i < amount; i++) {
            FishEnum fishEnum = FishEnum.getRandomFish(game.getCurrentTime().getSeason(), player.getFishingLevel() == 4);
            InventoryItem fish = new InventoryItem(fishEnum.getName(), 0);
            fish.setQuality(quality);
            inventory.addInventoryItem(fish, 1);
        }
        return new Result(true, "You caught " + amount);
    }

    public Result plant(String seed, String direction) {
        ArrayList<Integer> directionConst = getDirection(direction);
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        if (directionConst == null)
            return new Result(false, "Invalid direction");
        int x = player.getX() + directionConst.get(0);
        int y = player.getY() + directionConst.get(1);
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        Objectt furrow = null;
        for (Objectt object : farm.getObjects()) {
            for (Tile tile : object.getTiles()) {
                if (tile.getX() == x && tile.getY() == y) {
                    if (object instanceof Furrow) {
                        furrow = object;
                        break;
                    }
                }
            }
        }
        if (furrow == null)
            return new Result(false, "You can't plant seed in this direction.");
        Seed item = null;
        for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
            if (inventoryItem instanceof Seed) {
                if (inventoryItem.getName().equalsIgnoreCase(seed)) {
                    item = (Seed) inventoryItem;
                    break;
                }
            }
        }
        if (item == null) return new Result(false, "Invalid seed.");
        farm.getObjects().remove(furrow);
        Plant plant;
        if (item instanceof CropSeed) {
            plant = new Crop(item);
        }
        else {
            plant = new FruitTree(item);
        }
        plant.setTiles(new ArrayList<Tile>(List.of(new Tile('p', x, y))));
        farm.getObjects().add(plant);
        player.getInventory().removeInventoryItem(seed, 1);
        for (String fertilizer : ((Furrow) furrow).getFertilizers()) {
            plant.fertilize(fertilizer);
        }
        return new Result(true, "Done!");
    }

    public Result showPlant(String xString, String yString) {
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        Objectt plant = null;
        for (Objectt object : farm.getObjects()) {
            for (Tile tile : object.getTiles()) {
                if (tile.getX() == x && tile.getY() == y) {
                    if (object instanceof Plant) {
                        plant = object;
                        break;
                    }
                }
            }
        }
        if (plant == null) return new Result(false, "No plant in this place");
        return new Result(true, plant.toString());
    }

    public Result howMuchWater() {
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
            if (inventoryItem instanceof WateringCan) {
                return new Result(true, String.valueOf(((WateringCan) inventoryItem).getWater()));
            }
        }
        return new Result(false, "You have no watering cans.");
    }

    public Result pet (String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        //TODO
//        if(!close){
//            return new Result(false, "You can't pet this animal.");
//        }
        animal.addFriendshipPoint(15);
        animal.setIsPetted(true);
        return new Result(true, "");
    }

    public Result cheatSetFriendship(String animalName, String amountString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int amount = Integer.parseInt(amountString);
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        animal.setFriendshipPoint(amount);
        return new Result(true, "");
    }

    public Result animals (){
        Player player = App.getCurrentGame().getCurrentPlayer();
        StringJoiner stringJoiner = new StringJoiner("\n");
        //TODO
//        for (Animal animal){
//            stringJoiner.add("Animal: " + animal.getName());
//            stringJoiner.add("   FriendshipPoint: " + animal.getFriendshipPoint());
//            stringJoiner.add("   IsFed? " + (animal.isFed() ? "Yes" : "No"));
//            stringJoiner.add("   IsPetted? " + (animal.isPetted() ? "Yes" : "No");
//        }

        return new Result(true, stringJoiner.toString());
    }

    public Result shepherdAnimals(String animalName, String xString, String yString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Game game = App.getCurrentGame();
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        //TODO
//        if(invalid destination){
//            return new Result(false, "Invalid destination");
//        }
        //TODO
//        if(movingOut && (game.getWeather() == Weather.SNOWY || game.getWeather() == Weather.RAINY || game.getWeather() == Weather.STORMY)){
//            return new Result(false, "You can't take the animals out in this weather.");
//        }
        //TODO
        // change animal's location
        return new Result(true, "");
    }

    public Result feedHay (String animalName){
        Player player = App.getCurrentGame().getCurrentPlayer();
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        animal.setIsFed(true);
        return new Result(true, "");
    }

    public Result produces(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        StringJoiner stringJoiner = new StringJoiner("\n");
        //TODO
//        for (Animal animal){
//            if(animal.getProducts().isEmpty()) continue;
//            stringJoiner.add(animal.getName() + ":");
//            for (InventoryItem product : animal.getProducts()) {
//                stringJoiner.add("    " + product.getName() + " " + product.getQuality());
//            }
//        }
        return new Result(true, stringJoiner.toString());
    }

    public Result collectProduce(String animalName){
        Player player = App.getCurrentGame().getCurrentPlayer();
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        //TODO
        // proper tools?
        for (InventoryItem product : animal.getProducts()) {
            player.getInventory().addInventoryItem(product, 1);
        }
        animal.getProducts().clear();
        return new Result(true, "");
    }

    public Result sellAnimal(String animalName){
        Player player = App.getCurrentGame().getCurrentPlayer();
        //TODO
        Animal animal = null;
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        int price = (int)(animal.getAnimalType().getPrice() * (((double) animal.getFriendshipPoint() / 1000) + 0.3));
        player.addCoins(price);
        //TODO
        // removeAnimal
        return new Result(true, animal.getName() + "is sold.");
    }
    
    public Result friendshipNPCList() {
        StringBuilder result = new StringBuilder();
        Player player = App.getCurrentGame().getCurrentPlayer();
        result.append("Sebastian: " + player.getSebastianFriendship() + " level " + player.getSebastianFriendship() / 200 + "\n");
        result.append("Abigail: " + player.getAbigailFriendship() + " level " + player.getAbigailFriendship() / 200 + "\n");
        result.append("Harvey: " + player.getHarveyFriendship() + " level " + player.getHarveyFriendship() / 200 + "\n");
        result.append("Lia: " + player.getLiaFriendship() + " level " + player.getLiaFriendship() / 200 + "\n");
        result.append("Robin: " + player.getRobinFriendship() + " level " + player.getRobinFriendship() / 200);
        return new Result(true, result.toString());
    }
    public Result giftNPC(String NPCName, String itemName){
        if (App.getCurrentGame().getCurrentPlayer().getInventory().getNumberOfInventoryItem(itemName) < 1) {
            return new Result(false, "You don't have this item.");
        }
        App.getCurrentGame().getCurrentPlayer().getInventory().removeInventoryItem(itemName, 1);
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof NPCHouse){
                if (((NPCHouse) objectt).getName().equalsIgnoreCase(NPCName)) {
                    return ((NPCHouse) objectt).gift(itemName);
                }
            }
        }
        return new Result(false, "Wrong NPC name");
    }
    public Result friendships(){
        StringBuilder result = new StringBuilder();
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            result.append(App.getCurrentGame().getPlayers().get(i).getUser().getUsername());
            result.append(": ");
            result.append("xp " +  player.getFriendship()[i]);
            result.append("level " + getFriendshipLevel(player.getFriendship()[i]));
            result.append("\n");
        }
        return new Result(true, result.toString());
    }
    public Result talk(String username, String message){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                Player player2 = App.getCurrentGame().getPlayers().get(i);
                if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
                    return new Result(false, "You are not next to " + username);
                }
                player.addFriendship(ind, 20);
                player2.addFriendship(App.getCurrentGame().getTurn(), 20);
                player.addTalk(message, ind);
                player2.addTalk(message, App.getCurrentGame().getTurn());
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        return new Result(true, "added 20 xp to your friendship with " + username);
    }
    public Result talkHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        StringBuilder result = new StringBuilder();
        ArrayList<String> talks = player.getTalkHistory(ind);
        for (int i = 0; i < talks.size(); i++) {
            result.append(talks.get(i) + "\n");
        }
        return new Result(true, result.toString());
    }
    public Result gift(String username, String itemName, String amountString){
        int amount = Integer.parseInt(amountString);
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (player.getInventory().getNumberOfInventoryItem(itemName) < amount) {
            return new Result(false, "You don't have enough items to gift.");
        }
        Player player2 = null;
        int ind = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }

    }

    private int getFriendshipLevel(int points){
        int level = 0;
        while(points > 100 * (level + 1)){
            points -= 100 * (level + 1);
            level++;
        }
        return level;
    }

    public Result fertilize(String fertilizer, String direction) {
        ArrayList<Integer> directionConst = getDirection(direction);
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        if (directionConst == null)
            return new Result(false, "Invalid direction");
        int x = player.getX() + directionConst.get(0);
        int y = player.getY() + directionConst.get(1);
        if (player.getInventory().findInventoryItem(fertilizer) == null)
            return new Result(false, "You don't have this fertilizer in your inventory.");
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        Objectt furrow = null;
        for (Objectt object : farm.getObjects()) {
            for (Tile tile : object.getTiles()) {
                if (tile.getX() == x && tile.getY() == y) {
                    if (object instanceof Furrow) {
                        furrow = object;
                        break;
                    }
                }
            }
        }
        if (furrow != null) {
            player.getInventory().removeInventoryItem(fertilizer, 1);
            ((Furrow) furrow).addFertilizer(fertilizer);
            return new Result(true, "The furrow is fertilized");
        }
        Plant plant= null;
        for (Objectt object : farm.getObjects()) {
            for (Tile tile : object.getTiles()) {
                if (tile.getX() == x && tile.getY() == y) {
                    if (object instanceof Plant) {
                        plant = (Plant) object;
                        break;
                    }
                }
            }
        }
        if (plant == null || plant.isForaging() || (plant.getRemainingTime() != plant.getTotalHarvestTime()))
            return new Result(false, "You can't use fertilizer in this direction.");
        plant.fertilize(fertilizer);
        return new Result(true, "The plant is fertilized");
    }
}
