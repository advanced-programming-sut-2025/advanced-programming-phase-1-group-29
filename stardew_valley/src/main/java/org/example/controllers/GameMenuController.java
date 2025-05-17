package org.example.controllers;

import org.example.models.*;
import org.example.models.AnimalsPackage.AnimalHouse;
import org.example.models.AnimalsPackage.Animal;
import org.example.models.AnimalsPackage.FishingPole;
import org.example.models.FarmPackage.*;
import org.example.models.Map;
import org.example.models.Objectt;
import org.example.models.ToolsPackage.Tool;
import org.example.models.ToolsPackage.WateringCan;
import org.example.models.VillagePackage.*;
import org.example.models.enums.*;

import java.util.*;

import static java.lang.Math.*;

public class GameMenuController extends Controller{

    public Result isCollapsed(String input) {
        if(App.getCurrentGame().getCurrentPlayer().isEnergyUnlimited()){
            return new Result(true, "You are enforcing energy unlimited");
        }
        if (App.getCurrentGame().getCurrentPlayer().isCollapsed()) {
            if (GameMenuCommands.NextTurn.getMatcher(input) != null) {
                this.nextTurn();
                return new Result(false, "");
            }
            else {
                return new Result(false, "YOU ARE COLLAPSED!\n");
            }
        }
        return new Result(true, "");
    }

    public Result menuEnter() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "Now you are in Main Menu.");
    }

    public Result exitGame(){
        if(!App.getCurrentGame().isMainPlayerPlaying()){
            return new Result(false, "Sorry, you cannot exit the game.");
        }
        for (Player player : App.getCurrentGame().getPlayers()) {
            player.getUser().setNumberOfGames(player.getUser().getNumberOfGames() + 1);
            if (player.getCoins() > player.getUser().getMaxCoins()) player.getUser().setMaxCoins(player.getCoins());
        }
        App.addGame(App.getCurrentGame());
        App.setCurrentGame(null);
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "You are now in Main Menu.");
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

    public Result weatherForecast() {
        if (App.getCurrentGame().getCheatWeather() != null) {
            return new Result(true, "Tomorrow, The weather will be " + App.getCurrentGame().getCheatWeather() + ".");
        }
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        if (App.getCurrentGame().getCurrentTime().getDay() == 28) {
            if (season.equals(Season.Spring)) season = Season.Summer;
            else if (season.equals(Season.Summer)) season = Season.Fall;
            else if (season.equals(Season.Fall)) season = Season.Winter;
            else season = Season.Spring;
        }
        int random = (new Random()).nextInt(season.getWeathers().size());
        return new Result(true, "Tomorrow, The weather will probably be " + season.getWeathers().get(random) + ".");
    }

    public Result cheatWeatherSet(String name) {
        try {
            Weather.valueOf(name.toUpperCase());
            App.getCurrentGame().setCheatWeather(Weather.valueOf(name.toUpperCase()));
            return new Result(true, "Tomorrow the weather will be " + name.toLowerCase());
        } catch (IllegalArgumentException _) {
            return new Result(false, "Invalid weather type.");
        }
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
        for (String item : inventory.getUniqueInventoryItems()) {
            result.append(item);
            result.append("\n");
        }
        return new Result(true, result.toString());
    }

    public Result toolsEquip(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (inventoryItem instanceof Tool) {
                if (inventoryItem.getName().equalsIgnoreCase(name.replaceAll("\\s+",""))) {
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
        int[][] distance = new int[Map.getXRange()][Map.getYRange()];
        for (int i = 0; i < Map.getXRange(); i++) {
            for (int j = 0; j < Map.getYRange(); j++) {
                walkable[i][j] = true;
                distance[i][j] = -1;
            }
        }
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof Lake lake) {
                    for (Tile tile : lake.getTiles()) {
                        walkable[tile.getX()][tile.getY()] = false;
                    }
                }
            }
        }
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof Item item) {
                    for (Tile tile : item.getTiles()) {
                        walkable[tile.getX()][tile.getY()] = false;
                    }
                }
            }
        }
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof Plant plant) {
                    for (Tile tile : plant.getTiles()) {
                        walkable[tile.getX()][tile.getY()] = false;
                    }
                }
            }
        }
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i ++) {
            if(i != App.getCurrentGame().getTurn() && !player.getMarried(i)){
                for (int xx = 0; xx < Farm.getXRange(); xx ++){
                    for (int yy = 0; yy < Farm.getYRange(); yy ++){
                        int x = App.getCurrentGame().getMap().getFarms().get(i).getXStart() + xx;
                        int y = App.getCurrentGame().getMap().getFarms().get(i).getYStart() + yy;
                        walkable[x][y] = false;
                    }
                }
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
                if(walkable[xx][yy] && (distance[xx][yy] == -1 || distance[xx][yy] > distance[x][y] + 1)) {
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
        Village village = App.getCurrentGame().getMap().getVillage();
        for (Objectt objectt : village.getObjects()) {
            if (objectt instanceof Store){
                boolean check = false;
                for (Tile tile : objectt.getTiles()) {
                    if (tile.getX() == x2 && tile.getY() == y2) {
                        check = true;
                    }
                }
                if (check) {
                    if (!((Store) objectt).isOpen()){
                        return new Result(true, "The store is closed and you can't enter it now");
                    }
                }
            }
        }
        player.reduceEnergy(energyNeeded);
        player.setX(x2);
        player.setY(y2);
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
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        int size = Integer.parseInt(sizeString);
        if (x < 0 || y < 0 || x + size > Map.getXRange() || y + size > Map.getYRange()) {
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
                if (object instanceof Quarry){
                    for (Objectt mineral : ((Quarry) object).getMinerals()) {
                        Tile mineralTile = mineral.getTiles().get(0);
                        mapToPrint[mineralTile.getX()][mineralTile.getY()] = mineralTile.getDisplay();
                    }
                }
            }
        }
        for (Objectt objectt : map.getVillage().getObjects()) {
            for (Tile tile : objectt.getTiles()) {
                mapToPrint[tile.getX()][tile.getY()] = tile.getDisplay();
            }
            if (objectt instanceof NPCHouse){
                mapToPrint[((NPCHouse) objectt).getNPCPlaceX()][((NPCHouse) objectt).getNPCPlaceY()] = '*';
            }
        }
        int playerCnt = 1;
        for (Player player : App.getCurrentGame().getPlayers()) {
            mapToPrint[player.getX()][player.getY()] = (char)('0' + playerCnt);
            playerCnt ++;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char tileChar = mapToPrint[y + j][x + i];
                String color = getColorForTile(tileChar);
                System.out.print(color + tileChar + AnsiColor.RESET + " ");
            }
            System.out.println();
        }
        return;
    }
    public String getColorForTile(char tile) {
        switch (tile) {
            // Buildings
            case 'C': return AnsiColor.YELLOW;         // Cottage
            case 'G': case 'g': return AnsiColor.GREEN; // Greenhouse (unbuilt/built)
            case 'Q': return AnsiColor.WHITE;          // Quarry
            case 'L': return AnsiColor.CYAN;           // Lake
            case 'F': return AnsiColor.YELLOW;         // Furrow
            case 'P': return AnsiColor.GREEN;          // Plant (Crop or Tree)
            case 'm': return AnsiColor.PURPLE;         // Foraging Mineral
            case 'B': return AnsiColor.RED;            // Burned Tree
            case 'k': return AnsiColor.BLUE;           // Sales bucket
            case '*': return AnsiColor.WHITE;          // NPC

            // 🟡 Houses (all yellow)
            case 's': // Sebastian’s house
            case 'a': // Abigail’s house
            case 'h': // Harvey’s house
            case 'l': // Lia’s house
            case 'r': // Robin’s house
            case 'p': // Pierre’s general store
                return AnsiColor.YELLOW;

            // 🔵 Shops (all cyan)
            case 'c': // Carpenter
            case 'f': // Fish shop
            case 'J': // JojaMart
            case 'M': // Marnie’s Ranch
            case 'S': // Stardrop Saloon
            case 'b': // Blacksmith (also used for Burned Tree — consider separating in logic)
                return AnsiColor.CYAN;

            // Animals
            case '#':
            case '^':
                return AnsiColor.WHITE;

            // Items
            case '-' :
                return AnsiColor.CYAN;

            // Players
            case '1':
            case '2':
            case '3':
            case '4':
                return AnsiColor.RED;

            default:
                return AnsiColor.BLACK; // Unknown or empty
        }
    }



    public void nextTurn() {
        App.getCurrentGame().nextTurn();
    }

    public Result inventoryTrash(String name, String amount) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        int number = 0;
        int sum = 0;
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                sum += inventory.getInventoryItems().get(inventoryItem);
            }
        }
        if (sum == 0)
            return new Result(false, "This item doesn't exist in your inventory");
        if (amount == null || amount.isEmpty()) number = sum;
        else number = Integer.parseInt(amount);
        if (number > sum)
            return new Result(false, "You don't have this amount of " + name);
        ArrayList<InventoryItem> toBeRemoved = new ArrayList<>();
        InventoryItem item = null;
        for (InventoryItem inventoryItem : inventory.getInventoryItems().keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                if (number >= inventory.getInventoryItems().get(inventoryItem)) {
                    toBeRemoved.add(inventoryItem);
                    int coins = player.getTrashCan().getReturnValuePercentage() * inventoryItem.getPrice() / 100;
                    player.addCoins(coins);
                    number -= inventory.getInventoryItems().get(inventoryItem);
                }
                else {
                    item = inventoryItem;
                }
                if (number == 0 || item != null) break;

            }
        }
        for (InventoryItem inventoryItem : toBeRemoved) {
            inventory.getInventoryItems().remove(inventoryItem);
        }
        if (item != null) {
            inventory.getInventoryItems().put(item, inventory.getInventoryItems().get(item) - number);
            int coins = player.getTrashCan().getReturnValuePercentage() * item.getPrice() / 100;
            player.addCoins(coins);
        }
        return new Result(true, amount + " of " + name + " deleted from your inventory. ");
    }

    public Result helpReadingMap() {
        StringBuilder result = new StringBuilder();
        result.append("🏡 Buildings:\n");
        result.append("  Cottage: C\n");
        result.append("  Greenhouse (unbuilt): G\n");
        result.append("  Greenhouse (built): g\n");
        result.append("  Quarry: Q\n");
        result.append("  Lake: L\n");
        result.append("  Furrow: F\n");
        result.append("  Plant (Crop or Tree): p\n");
        result.append("  Foraging Mineral: m\n");
        result.append("  Burned Tree: B\n");
        result.append("  Sales Bucket: k\n");

        result.append("\n🏪 Shops:\n");
        result.append("  Blacksmith: b\n");
        result.append("  Carpenter's Shop: c\n");
        result.append("  Fish Shop: f\n");
        result.append("  JojaMart: J\n");
        result.append("  Marnie’s Ranch: M\n");
        result.append("  Pierre’s General Store: P\n");
        result.append("  Stardrop Saloon: S\n");

        result.append("\n🏠 NPC Houses:\n");
        result.append("  Sebastian’s House: s\n");
        result.append("  Abigail’s House: a\n");
        result.append("  Harvey’s House: h\n");
        result.append("  Lia’s House: l\n");
        result.append("  Robin’s House: r\n");

        result.append("\n👤 NPC:\n");
        result.append("  NPC Character: *\n");

        result.append("\n\uD83E\uDD99 Animals:\n");
        result.append("  Animal House: #\n");
        result.append("  Animal: ^\n");

        return new Result(true, result.toString());
    }


    public Result cheatAdvanceTime(String timeString) {
        int h = Integer.parseInt(timeString);
        for (int i = 0; i < h * App.getCurrentGame().getPlayers().size(); i++){
            nextTurn();
        }
        return dateTime();
    }

    public Result cheatAdvanceDate(String dateString) {
        int h = Integer.parseInt(dateString);
        for (int i = 0; i < (22 - 9) * h * App.getCurrentGame().getPlayers().size(); i++){
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
        if ((!player.isEnergyUnlimited()) && player.getCurrentTool().applyWeatherOnEnergyConsumption(player.getCurrentTool().getEnergyConsumption()) > player.getEnergy())
            return new Result(false, "You don't have enough energy");
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        if (
                x < farm.getXStart() || x >= farm.getXStart() + Farm.getXRange() ||
                y < farm.getYStart() || y >= farm.getYStart() + Farm.getYRange()
        )
            return new Result(false, "The tool can't be used in this direction");
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

    public Result craftingShowRecipes(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Your crafting recipes are: ");
        for (CraftingItemEnum item : player.getCraftingRecipeList()) {
            joiner.add(item.getName());
        }
        return new Result(true, joiner.toString());
    }

    public Result craftingCraft(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
        CraftingItemEnum craftingItem = CraftingItemEnum.getCraftingItemByName(itemName);
        if(craftingItem == null){
            return new Result(false, "Invalid crafting item name");
        }
        if(!player.getCraftingRecipeList().contains(craftingItem)) {
            return new Result(false, "You don't have this crafting Item's recipe");
        }
        for (String ingredient: craftingItem.getIngredients().keySet()){
            if(player.getInventory().getNumberOfInventoryItem(ingredient) < craftingItem.getIngredients().get(ingredient)){
                return new Result(false, "You don't have this crafting Item's ingredients");
            }
        }
        if(player.getInventory().getCapacity() == 0){
            return new Result(false, "Your inventory is full");
        }
        for (String ingredient: craftingItem.getIngredients().keySet()){
            player.getInventory().removeInventoryItem(ingredient, craftingItem.getIngredients().get(ingredient));
        }
        App.getCurrentGame().getCurrentPlayer().getInventory().addInventoryItem(craftingItem.getName(), 1, 0);
        player.reduceEnergy(2);
        return new Result(true, "");
    }

    public Boolean isOccupied(int x, int y){
        //Todo
        for (Objectt object : App.getCurrentGame().getMap().getObjects()) {
            for (Tile tile : object.getTiles()) {
                if(tile.getX() == x && tile.getY() == y){
                    return true;
                }
            }
        }
        return false;
    }

    public Result placeItem(String itemName, String direction) {
        ArrayList<Integer> directionConst = getDirection(direction);
        if(directionConst == null){
            return new Result(false, "Invalid direction");
        }
        Player player = App.getCurrentGame().getCurrentPlayer();
        int x = player.getX() + directionConst.get(0);
        int y = player.getY() + directionConst.get(1);
        if(isOccupied(x, y)){
            return new Result(false, "You can't place an item in this direction");
        }
        InventoryItem inventoryItem = player.getInventory().findInventoryItem(itemName);
        if(inventoryItem == null){
            return new Result(false, "You don't have this item");
        }
        Item item = new Item(itemName);
        item.getTiles().add(new Tile('-', x, y));
        App.getCurrentGame().getCurrentFarm().getObjects().add(item);
        player.getInventory().removeInventoryItem(inventoryItem.getName(), 1);
        return new Result(true, "");
    }

    public Result cheatAddItem(String itemName, String countString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int count = Integer.parseInt(countString);
        if(count == 0){
            return new Result(false, "zero ? are you ok?");
        }
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
        CraftingItemEnum craftingItem = CraftingItemEnum.getCraftingItemByName(itemName);
        if(craftingItem == null){
            return new Result(false, "Invalid crafting item name");
        }
        if(player.getInventory().getCapacity() < count){
            return new Result(false, "Your inventory is full");
        }
        App.getCurrentGame().getCurrentPlayer().getInventory().addInventoryItem(craftingItem.getName(), count, 0);
        return new Result(true, "");
    }

    private boolean inCottage() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Cottage cottage = App.getCurrentGame().getCurrentFarm().getCottage();
        int x = player.getX();
        int y = player.getY();
        for (Tile tile : cottage.getTiles()) {
            if (tile.getX() == x && tile.getY() == y) return true;
        }
        return false;
    }

    public Boolean isEdible(String itemName) {
        if(FoodEnum.getByName(itemName) != null){
            return true;
        }
        if(FishEnum.getByName(itemName) == null){
            return true;
        }
        if(FruitEnum.getByName(itemName) == null){
            return true;
        }
        return false;
    }

    public Result cookingRefrigerator(String action, String item){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
        if(!isEdible(item)){
            return new Result(false, "Not eatable!");
        }
        Game game = App.getCurrentGame();
        Farm farm = game.getCurrentFarm();
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
            if(inventory.getCapacity() < refrigerator.getQuantity(item)){
                return new Result(false, "There is not enough space in inventory");
            }
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
        Cottage cottage = game.getCurrentFarm().getCottage();
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
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
        if(inventory.getCapacity() - 1 + foodEnum.getIngredients().size() < 0) {
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
        if(!inCottage()){
            return new Result(false, "You are not in your cottage");
        }
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

    private boolean nearTheLake() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Farm farm = App.getCurrentGame().getCurrentFarm();
        for (Objectt objectt : farm.getObjects()) {
            if(objectt instanceof Lake lake) {
                int x = player.getX();
                int y = player.getY();
                for (Tile tile : lake.getTiles()) {
                    if (Math.abs(tile.getX() - x) <= 1 && Math.abs(tile.getY() - y) <= 1) return true;
                }
            }
        }
        return false;
    }

    public Result fishing(String fishingPoleName) {
        Game game = App.getCurrentGame();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Inventory inventory = player.getInventory();
        if(!nearTheLake()){
            return new Result(false, "You are not near the lake");
        }
        FishingPoleType fishingPoleType = FishingPoleType.getFishingPoleByName(fishingPoleName);
        if(fishingPoleType == null){
            return new Result(false, "This fishing pole doesn't exist");
        }
        FishingPole fishingPole = null;
        for(InventoryItem inventoryItem : inventory.getInventoryItems().keySet()){
            if(inventoryItem.getName().equalsIgnoreCase(fishingPoleType.getName())){
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
            //TODO energy consumption
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
        Farm farm = App.getCurrentGame().getCurrentFarm();
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
        Farm farm = App.getCurrentGame().getCurrentFarm();
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
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
            if (inventoryItem instanceof WateringCan) {
                return new Result(true, String.valueOf(((WateringCan) inventoryItem).getWater()));
            }
        }
        return new Result(false, "You have no watering cans.");
    }

    public Result build(String buildingName, String xString, String yString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        AnimalHouseEnum animalHouseEnum = AnimalHouseEnum.getByName(buildingName);
        if(animalHouseEnum == null) {
            return new Result(false, "Invalid animal house type");
        }
        InventoryItem inventoryItem = player.getInventory().findInventoryItem(animalHouseEnum.getName());
        if(inventoryItem == null) {
            return new Result(false, "You can't build this building");
        }
        for (int i = 0; i < animalHouseEnum.getXRange(); i ++){
            for (int j = 0; j < animalHouseEnum.getYRange(); j++){
                if(isOccupied(x + i, y + j)) {
                    return new Result(false, "You can't build this building in this place.");
                }
            }
        }
        AnimalHouse animalHouse = new AnimalHouse(animalHouseEnum);
        for (int i = 0; i < animalHouseEnum.getXRange(); i ++){
            for (int j = 0; j < animalHouseEnum.getYRange(); j++){
                animalHouse.getTiles().add(new Tile('#', i, j));
            }
        }
        Farm farm = App.getCurrentGame().getCurrentFarm();
        farm.getObjects().add(animalHouse);
        player.getInventory().removeInventoryItem(animalHouseEnum.getName(), 1);
        return new Result(true, "You build " + buildingName);
    }

    public Animal getAnimal(String name) {
        Farm farm = App.getCurrentGame().getCurrentFarm();
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof AnimalHouse animalHouse) {
                for (Animal candidate : animalHouse.getAnimals()) {
                    if (candidate.getName().equalsIgnoreCase(name)) {
                        return candidate;
                    }
                }
            }
        }
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof Animal animal) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    return animal;
                }
            }
        }
        return null;
    }

    public Result pet (String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Animal animal = getAnimal(name);
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        int animalX = animal.getTiles().get(0).getX();
        int animalY = animal.getTiles().get(0).getY();
        if(!(Math.abs(player.getX() - animalX) <= 1 && Math.abs(player.getY() - animalY) <= 1)){
            return new Result(false, "You can't pet this animal. You are not close enough.");
        }
        animal.addFriendshipPoint(15);
        animal.setIsPetted(true);
        return new Result(true, "");
    }

    public Result cheatSetFriendship(String animalName, String amountString) {
        int amount = Integer.parseInt(amountString);
        Animal animal = getAnimal(animalName);
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        animal.setFriendshipPoint(amount);
        return new Result(true, "");
    }

    public Result animals (){
        Farm farm = App.getCurrentGame().getCurrentFarm();
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof AnimalHouse animalHouse) {
                for (Animal animal : animalHouse.getAnimals()) {
                    stringJoiner.add("Animal: " + animal.getName());
                    stringJoiner.add("   FriendshipPoint: " + animal.getFriendshipPoint());
                    stringJoiner.add("   IsFed? " + (animal.isFed() ? "Yes" : "No"));
                    stringJoiner.add("   IsPetted? " + (animal.isPetted() ? "Yes" : "No"));
                }
            }
        }
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof Animal animal) {
                stringJoiner.add("Animal: " + animal.getName());
                stringJoiner.add("   FriendshipPoint: " + animal.getFriendshipPoint());
                stringJoiner.add("   IsFed? " + (animal.isFed() ? "Yes" : "No"));
                stringJoiner.add("   IsPetted? " + (animal.isPetted() ? "Yes" : "No"));
            }
        }
        return new Result(true, stringJoiner.toString());
    }

    public Result shepherdAnimals(String animalName, String xString, String yString) {
        Farm farm = App.getCurrentGame().getCurrentFarm();
        Game game = App.getCurrentGame();
        Animal animal = getAnimal(animalName);
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        if(isOccupied(x, y) || !(farm.getXStart() <= x && x <= farm.getXStart() + Farm.getXRange() && farm.getYStart() <= y && y <= farm.getYStart() + Farm.getYRange())){
            return new Result(false, "Invalid destination");
        }
        //moving in
        if(farm.getObjects().contains(animal)){
            farm.getObjects().remove(animal);
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof AnimalHouse animalHouse) {
                    if(animalHouse.hasTile(x,y)){
                        if(animalHouse.getAnimals().size() == animalHouse.getAnimalHouseEnum().getCapacity()){
                            return new Result(false, "This place is full");
                        }
                        animalHouse.getAnimals().add(animal);
                        break;
                    }
                }
            }
        }
        //moving out
        else{
            if((game.getWeather() == Weather.SNOWY || game.getWeather() == Weather.RAINY || game.getWeather() == Weather.STORMY)) {
                return new Result(false, "You can't take the animals out in this weather.");
            }
            farm.getObjects().add(animal);
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof AnimalHouse animalHouse) {
                    if(animalHouse.getAnimals().contains(animal)){
                        animalHouse.getAnimals().remove(animal);
                    }
                }
            }
        }
        animal.getTiles().clear();
        animal.getTiles().add(new Tile('^', x, y));
        return new Result(true, "");
    }

    public Result feedHay (String animalName){
        Animal animal = getAnimal(animalName);
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        animal.setIsFed(true);
        return new Result(true, "");
    }

    public Result produces(){
        Farm farm = App.getCurrentGame().getCurrentFarm();
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof AnimalHouse animalHouse) {
                for (Animal animal : animalHouse.getAnimals()) {
                    if (animal.getProducts().isEmpty()) continue;
                    stringJoiner.add(animal.getName() + ":");
                    for (InventoryItem product : animal.getProducts()) {
                        stringJoiner.add("    " + product.getName() + " " + product.getQuality());
                    }
                }
            }
        }
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof Animal animal) {
                if (animal.getProducts().isEmpty()) continue;
                stringJoiner.add(animal.getName() + ":");
                for (InventoryItem product : animal.getProducts()) {
                    stringJoiner.add("    " + product.getName() + " " + product.getQuality());
                }
            }
        }
        return new Result(true, stringJoiner.toString());
    }

    public Result collectProduce(String animalName){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Animal animal = getAnimal(animalName);
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
        Farm farm = App.getCurrentGame().getCurrentFarm();
        Animal animal = getAnimal(animalName);
        if(animal == null){
            return new Result(false, "You don't have this animal.");
        }
        int price = (int)(animal.getAnimalType().getPrice() * (((double) animal.getFriendshipPoint() / 1000) + 0.3));
        player.addCoins(price);
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof AnimalHouse animalHouse) {
                for (Animal candidate : animalHouse.getAnimals()) {
                    if(candidate == animal){
                        animalHouse.getAnimals().remove(candidate);
                    }
                }
            }
        }
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof Animal candidate) {
                if(candidate == animal){
                    farm.getObjects().remove(candidate);
                }
            }
        }
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
            if (i == App.getCurrentGame().getTurn()) continue;
            int level = getFriendshipLevel(player.getFriendship()[i]);
            if (level > 2 && !player.getFlower(i)) level = 2;
            if (level > 3 && !player.getMarried(i)) level = 3;
            if (player.getMarried(i)) level = 4;
            result.append(App.getCurrentGame().getPlayers().get(i).getUser().getUsername());
            result.append(": ");
            result.append("xp " +  player.getFriendship()[i]);
            result.append(" level " + getFriendshipLevel(player.getFriendship()[i]));
            result.append("\n");
        }
        return new Result(true, result.toString());
    }

    public Result talk (String username, String message){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                Player player2 = App.getCurrentGame().getPlayers().get(i);
                if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
                    return new Result(false, "You are not next to " + username);
                }
                ind = i;
                player.addFriendship(ind, 20);
                player2.addFriendship(App.getCurrentGame().getTurn(), 20);
                player.addTalk(message, ind);
                player2.addTalk(message, App.getCurrentGame().getTurn());
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
                if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
                    return new Result(false, "You are not next to " + username);
                }
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        if (ind == App.getCurrentGame().getTurn()) {
            return new Result(false, "you can't gift yourself");
        }
        if (getFriendshipLevel(player.getFriendship()[ind]) < 1) {
            return new Result(false, "You don't have enough friendship to gift.");
        }
        player2.getInventory().addInventoryItem(itemName, amount, 0);
        player2.addGift(itemName, amount, App.getCurrentGame().getTurn());
        return new Result(true, player2.getUser().getUsername() + " recieved " + amount + " of " + itemName + "\n");
    }

    public Result rateGift(String giftNumberString, String rateString){
        int giftNumber = Integer.parseInt(giftNumberString);
        int rate = Integer.parseInt(rateString);
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (giftNumber < 0 || giftNumber >= player.getGiftPlayersIndex().size()) {
            return new Result(false, "Gift number out of bounds");
        }
        Player player2 = App.getCurrentGame().getPlayers().get(player.getGiftPlayersIndex().get(giftNumber));
        player.addFriendship(player.getGiftPlayersIndex().get(giftNumber), (rate - 3) * 30 + 15);
        player2.addFriendship(App.getCurrentGame().getTurn(), (rate - 3) * 30 + 15);
        return new Result(true, "your rate has been received");
    }

    public Result giftList(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        ArrayList<String> items = player.getGiftItems();
        ArrayList<Integer> giftNumbers = player.getGiftNumbers();
        ArrayList<Integer> giftPlayersIndex = player.getGiftPlayersIndex();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            result.append(giftNumbers.get(i) + " " + items.get(i) + " from " + App.getCurrentGame().getPlayers().get(giftPlayersIndex.get(i)) + "\n");
        }
        return new Result(true, result.toString());
    }

    public Result giftHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
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
        StringBuilder result = new StringBuilder();
        result.append("received gifts: \n");
        ArrayList<String> items = player.getGiftItems();
        ArrayList<Integer> giftNumbers = player.getGiftNumbers();
        ArrayList<Integer> giftPlayersIndex = player.getGiftPlayersIndex();
        for (int i = 0; i < items.size(); i++) {
            if (giftPlayersIndex.get(i) == ind) {
                result.append(giftNumbers.get(i) + " " + items.get(i) + "\n");
            }
        }
        result.append("sent gifts: \n");
        ArrayList<String> items2 = player2.getGiftItems();
        ArrayList<Integer> giftNumbers2 = player2.getGiftNumbers();
        ArrayList<Integer> giftPlayersIndex2 = player2.getGiftPlayersIndex();
        for (int i = 0; i < items2.size(); i++) {
            if (giftPlayersIndex2.get(i) == App.getCurrentGame().getTurn()) {
                result.append(giftNumbers2.get(i) + " " + items2.get(i) + "\n");
            }
        }
        return new Result(true, result.toString());
    }

    private int getFriendshipLevel(int points){
        int level = 0;
        while(points >= 100 * (level + 1)){
            points -= 100 * (level + 1);
            level++;
        }
        return level;
    }

    public Result hug(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        Player player2 = null;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
            return new Result(false, "You are too far away");
        }
        if (getFriendshipLevel(player.getFriendship()[ind]) < 2) {
            return new Result(false, "You are not friends enough to hug");
        }
        player.addFriendship(ind, 60);
        player2.addFriendship(App.getCurrentGame().getTurn(), 60);
        return new Result(true, "you received 60 friendship xp from hugging");
    }

    public Result flower(String username){
        int ind = -1;
        Player player = App.getCurrentGame().getCurrentPlayer();
        Player player2 = null;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
            return new Result(false, "You are too far away");
        }
        if (player.getFriendship()[ind] < 600) {
            return new Result(false, "You are not friends enough to send flower (you need to have 600 friendship xp)");
        }
        if (player.getInventory().getNumberOfInventoryItem("bouquet") < 1) {
            return new Result(false, "You don't have any fairy rose to gift");
        }
        player.getInventory().removeInventoryItem("bouquet", 1);
        player2.getInventory().addInventoryItem("bouquet", 1, 0);
        player.setFlower(ind);
        player2.setFlower(App.getCurrentGame().getTurn());
        return new Result(true, "sent successfully");
    }

    public Result askMarriage(String username, String ring){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (player.getUser().getGender().equals(Gender.FEMALE)) {
            return new Result(false, "A woman can't propose!!");
        }
        int ind = -1;
        Player player2 = null;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        if (player.getInventory().getNumberOfInventoryItem(ring) < 1) {
            return new Result(false, "You don't have a ring to propose");
        }
        if (player2.getUser().getGender().equals(Gender.MALE)) {
            return new Result(false, "Are you gay?!!!");
        }
        if (abs(player.getX() - player2.getX()) + abs(player.getY() - player2.getY()) > 1) {
            return new Result(false, "You are too far away");
        }
        if (!player.getFlower(ind)) {
            return new Result(false, "You are not friends enough to propose");
        }
        player2.setAskMarriage(App.getCurrentGame().getTurn());
        player2.setRing(App.getCurrentGame().getTurn(), ring);
        return new Result(true, player.getUser().getUsername() + " proposed to " + username);
    }
    public Result respond(String respond, String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        Player player2 = null;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1) {
            return new Result(false, "Incorrect username");
        }
        if (!player.getAskMarriage(ind)){
            return new Result(false, username + " has not proposed!");
        }
        if (respond.equalsIgnoreCase("reject") || respond.equalsIgnoreCase("-reject")) {
            player2.setRejected();
            return new Result(true, "You have rejected the proposal");
        }
        player.setMarried(ind);
        player2.setMarried(App.getCurrentGame().getTurn());
        player2.getInventory().removeInventoryItem(player2.getRing().get(App.getCurrentGame().getTurn()), 1);
        return new Result(true, "congratulations!");
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

    public Result cheatThor(String xInString, String yInString) {
        int x = Integer.parseInt(xInString);
        int y = Integer.parseInt(yInString);
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant plant) {
                    if (plant.getTiles().getFirst().getX() == x && plant.getTiles().getFirst().getY() == y) {
                        farm.getObjects().remove(plant);
                        if (plant instanceof FruitTree) {
                            BurnedTree burnedTree = new BurnedTree();
                            burnedTree.setTiles(plant.getTiles());
                            burnedTree.getTiles().getFirst().setDisplay('b');
                            farm.getObjects().add(new BurnedTree());
                        }
                        return new Result(true, "Done!");
                    }
                }
            }
        }
        return new Result(false, "Nothing happened.");
    }

    private Result upgrade(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (name.equalsIgnoreCase("TrashCan")) {
            TrashCan newTrashCan = player.getTrashCan().upgrade();
            int sum = 0;
            for (InventoryItem item : player.getInventory().getInventoryItems().keySet()) {
                if (item.getName().equalsIgnoreCase(newTrashCan.getBar())) {
                    sum += player.getInventory().getInventoryItems().get(item);
                }
            }
            if (newTrashCan.getCoinForUpgrade() > player.getCoins() || newTrashCan.getBarForUpgrade() > sum) {
                return new Result(false, "You don't have enough coins or bars.");
            }
            player.setTrashCan(newTrashCan);
            useResources(player, newTrashCan.getCoinForUpgrade(), newTrashCan.getBarForUpgrade(), newTrashCan.getBar());
            return new Result(true, "Trash Can is upgraded successfully.");
        }
        for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
            if (inventoryItem instanceof UpgradableTool tool) {
                ToolType newType = tool.getType().upgrade();
                int sum = 0;
                for (InventoryItem item : player.getInventory().getInventoryItems().keySet()) {
                    if (item.getName().equalsIgnoreCase(newType.getBar())) {
                        sum += player.getInventory().getInventoryItems().get(item);
                    }
                }
                if (newType.getCoinForUpgrade() > player.getCoins() || newType.getBarForUpgrade() > sum) {
                    return new Result(false, "You don't have enough coins or bars.");
                }
                tool.setType(newType);
                useResources(player, newType.getCoinForUpgrade(), newType.getBarForUpgrade(), newType.getBar());
                return new Result(true, "Tool is upgraded successfully.");
            }
        }
        return new Result(false, "You can't upgrade " + name);
    }

    private static void useResources(Player player, int coins, int bars, String bar) {
        player.addCoins((-1) * coins);
        ArrayList<InventoryItem> toBeRemoved = new ArrayList<>();
        InventoryItem item = null;
        int number = bars;
        for (InventoryItem item2 : player.getInventory().getInventoryItems().keySet()) {
            if (item2.getName().equalsIgnoreCase(bar)) {
                if (number >= player.getInventory().getInventoryItems().get(item2)) {
                    toBeRemoved.add(item2);
                    number -= player.getInventory().getInventoryItems().get(item2);
                }
                else {
                    item = item2;
                }
                if (number == 0 || item != null) break;

            }
        }
        for (InventoryItem item2 : toBeRemoved) {
            player.getInventory().getInventoryItems().remove(item2);
        }
        if (item != null) {
            player.getInventory().getInventoryItems().put(item, player.getInventory().getInventoryItems().get(item) - number);
        }
    }

    public Result toolsUpgrade(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof BlackSmithStore){
                for (Tile tile : objectt.getTiles()) {
                    if (player.getX() == tile.getX() && player.getY() == tile.getY()) {
                        return upgrade(name.replaceAll("\\s+", ""));
                    }
                }
            }
        }
        return new Result(false, "You must be in Black Smith Store");
    }
    public Result greenhouseBuild(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        for (Objectt objectt : farm.getObjects()) {
            if (objectt instanceof GreenHouse) {
                if (((GreenHouse) objectt).getHasBeenBuilt()){
                    return new Result(true, "Greenhouse has already been built!");
                }
                if (player.getInventory().getNumberOfInventoryItem("wood") < 500 || player.getCoins() < 1000){
                    return new Result(false, "You don't have enough coins or wood.");
                }
                player.getInventory().removeInventoryItem("wood", 500);
                player.addCoins(-1000);
                ((GreenHouse) objectt).setHasBeenBuilt(true);
                for (Tile tile : objectt.getTiles()) {
                    tile.setDisplay('g');
                }
            }
        }
        return new Result(true, "greenhouse was built successfully!");
    }

    public Result sell(String name, String count) {
        Farm farm = App.getCurrentGame().getMap().getFarms().get(App.getCurrentGame().getTurn());
        Player player = App.getCurrentGame().players.get(App.getCurrentGame().getTurn());
        ArrayList<String> directions = new ArrayList<>(List.of("u","l","r","l","ur","ul","dr","dl"));
        ShippingBin bin = null;
        for (String direction : directions) {
            ArrayList<Integer> directionConst = getDirection(direction);
            int x = player.getX() + directionConst.get(0);
            int y = player.getY() + directionConst.get(1);
            for (Objectt object : farm.getObjects()) {
                if (object instanceof ShippingBin) {
                    if (object.getTiles().getFirst().getX() == x && object.getTiles().getFirst().getY() == y) {
                        bin = (ShippingBin) object;
                        break;
                    }
                }
            }
            if (bin != null) break;
        }
        if (bin == null) return new Result(false, "No shipping bins near you.");
        int sum = 0;
        for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
            if (inventoryItem.getName().equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                sum += player.getInventory().getInventoryItems().get(inventoryItem);
            }
        }
        if (sum == 0) return new Result(false, "You don't have this item i your inventory");
        int amount;
        if (count == null || count.isEmpty()) {
            amount = sum;
        }
        else {
            amount = Integer.parseInt(count);
        }
        if (amount > sum) return new Result(false, "Not enough items in your inventory.");
        for (int i = 0; i < amount; i++) {
            for (InventoryItem inventoryItem : player.getInventory().getInventoryItems().keySet()) {
                if (inventoryItem.getName().equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                    bin.addItem(inventoryItem);
                    player.getInventory().getInventoryItems().remove(inventoryItem);
                    break;
                }
            }
        }
        return new Result(true, "You put items in the shipping bin successfully.");
    }
}
