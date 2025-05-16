package org.example.controllers;

import org.example.models.*;
import org.example.models.VillagePackage.Village;
import org.example.models.enums.Menu;
import org.example.models.enums.Season;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PreGameMenuController extends Controller{

    public Result menuEnter() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "Now you are in Main Menu.");
    }

    public Result gameNew(String username1, String username2, String username3) {
        Game game = new Game();
        App.setCurrentGame(game);
        User user1 = App.findUserByUsername(username1);
        User user2 = App.findUserByUsername(username2);
        User user3 = App.findUserByUsername(username3);
        if ((user1 == null && username1 != null) || (user2 == null && username2 != null) || (user3 == null && username3 != null)){
            return new Result(false, "Players not found");
        }
        Player player1 = new Player();
        player1.setUser(App.getLoggedInUser());
        game.addPlayer(player1);
        App.getLoggedInUser().setCurrentGame(game);
        if (user1 != null && user1.getCurrentGame() != null) {
            return new Result(true, "first user is already in a game");
        }
        if (user2 != null && user2.getCurrentGame() != null) {
            return new Result(true, "second user is already in a game");
        }
        if (user3 != null && user3.getCurrentGame() != null) {
            return new Result(true, "third user is already in a game");
        }
        if (user1 != null){
            Player player2 = new Player();
            player2.setUser(user1);
            game.addPlayer(player2);
            user1.setCurrentGame(game);
        }
        if (user2 != null){
            Player player3 = new Player();
            player3.setUser(user2);
            game.addPlayer(player3);
            user2.setCurrentGame(game);
        }
        if (user3 != null){
            Player player4 = new Player();
            player4.setUser(user3);
            game.addPlayer(player4);
            user3.setCurrentGame(game);
        }
        game.setMainPlayer(player1);
        game.setCurrentTime(new DateTime(Season.Spring, 1, 8, 0));
        createDefaultFarms();
        App.setCurrentMenu(Menu.MapSelectionMenu);
        game.getCurrentTime().incrementTime();
        return new Result(true, "You are now in a new game");
    }

    private void createDefaultFarms(){
        Map map = new Map();
        App.getCurrentGame().setMap(map);
        Farm farm1 = new Farm(1);
        Farm farm2 = new Farm(2);
        Farm farm3 = new Farm(3);
        Farm farm4 = new Farm(4);
        Cottage cottage1 = new Cottage();
        Cottage cottage2 = new Cottage();
        Cottage cottage3 = new Cottage();
        Cottage cottage4 = new Cottage();
        ArrayList<Tile> tilesCottage1 = new ArrayList<>();
        ArrayList<Tile> tilesCottage2 = new ArrayList<>();
        ArrayList<Tile> tilesCottage3 = new ArrayList<>();
        ArrayList<Tile> tilesCottage4 = new ArrayList<>();
        GreenHouse greenHouse1 = new GreenHouse();
        GreenHouse greenHouse2 = new GreenHouse();
        GreenHouse greenHouse3 = new GreenHouse();
        GreenHouse greenHouse4 = new GreenHouse();
        ArrayList<Tile> tilesGreenHouse1 = new ArrayList<>();
        ArrayList<Tile> tilesGreenHouse2 = new ArrayList<>();
        ArrayList<Tile> tilesGreenHouse3 = new ArrayList<>();
        ArrayList<Tile> tilesGreenHouse4 = new ArrayList<>();
        Lake lake1 = new Lake();
        Lake lake2 = new Lake();
        Lake lake3 = new Lake();
        Lake lake4 = new Lake();
        Lake lake5 = new Lake();
        Lake lake6 = new Lake();
        ArrayList<Tile> tilesLake1 = new ArrayList<>();
        ArrayList<Tile> tilesLake2 = new ArrayList<>();
        ArrayList<Tile> tilesLake3 = new ArrayList<>();
        ArrayList<Tile> tilesLake4 = new ArrayList<>();
        ArrayList<Tile> tilesLake5 = new ArrayList<>();
        ArrayList<Tile> tilesLake6 = new ArrayList<>();
        Quarry quarry1 = new Quarry();
        Quarry quarry2 = new Quarry();
        Quarry quarry3 = new Quarry();
        Quarry quarry4 = new Quarry();
        ArrayList<Tile> tilesQuarry1 = new ArrayList<>();
        ArrayList<Tile> tilesQuarry2 = new ArrayList<>();
        ArrayList<Tile> tilesQuarry3 = new ArrayList<>();
        ArrayList<Tile> tilesQuarry4 = new ArrayList<>();
        Village village = new Village();
        App.getCurrentGame().getMap().setVillage(village);
        for (int i = 40; i <= 45; i++){
            for (int j = 5; j <= 10; j++) {
                tilesCottage1.add(new Tile('C', i, j));
                tilesCottage2.add(new Tile('C', i, j));
                tilesGreenHouse3.add(new Tile('G', i, j));
                tilesGreenHouse4.add(new Tile('G', i, j));
            }
        }
        for (int i = 5; i <= 10; i++){
            for (int j = 5; j <= 10; j++) {
                tilesCottage3.add(new Tile('C', i, j));
                tilesCottage4.add(new Tile('C', i, j));
                tilesGreenHouse1.add(new Tile('G', i, j));
                tilesGreenHouse2.add(new Tile('G', i, j));
            }
        }
        for (int i = 20; i <= 26; i++){
            for (int j = 20; j <= 26; j++){
                tilesLake1.add(new Tile('L', i, j));
                tilesLake2.add(new Tile('L', i, j));
                tilesLake3.add(new Tile('L', i, j));
                tilesLake4.add(new Tile('L', i, j));
            }
        }
        for (int i  = 30; i <= 37; i++){
            for (int j = 15; j <= 20; j++){
                tilesLake5.add(new Tile('L', i, j));
                tilesLake6.add(new Tile('L', i, j));
            }
        }
        for (int i = 5; i <= 17; i++){
            for (int j = 33; j <= 42; j++){
                tilesQuarry3.add(new Tile('Q', i, j));
                tilesQuarry4.add(new Tile('Q', i, j));
            }
        }
        for (int i = 5; i <= 12; i++){
            for (int j = 33; j <= 39; j++){
                tilesQuarry1.add(new Tile('Q', i, j));
                tilesQuarry2.add(new Tile('Q', i, j));
            }
        }
        cottage1.setTiles(tilesCottage1);
        cottage2.setTiles(tilesCottage2);
        cottage3.setTiles(tilesCottage3);
        cottage4.setTiles(tilesCottage4);
        greenHouse1.setTiles(tilesGreenHouse1);
        greenHouse2.setTiles(tilesGreenHouse2);
        greenHouse3.setTiles(tilesGreenHouse3);
        greenHouse4.setTiles(tilesGreenHouse4);
        lake1.setTiles(tilesLake1);
        lake2.setTiles(tilesLake2);
        lake3.setTiles(tilesLake3);
        lake4.setTiles(tilesLake4);
        lake5.setTiles(tilesLake5);
        lake6.setTiles(tilesLake6);
        quarry1.setTiles(tilesQuarry1);
        quarry2.setTiles(tilesQuarry2);
        quarry3.setTiles(tilesQuarry3);
        quarry4.setTiles(tilesQuarry4);
        farm1.addObject(cottage1);
        farm2.addObject(cottage2);
        farm3.addObject(cottage3);
        farm4.addObject(cottage4);
        farm1.addObject(greenHouse1);
        farm2.addObject(greenHouse2);
        farm3.addObject(greenHouse3);
        farm4.addObject(greenHouse4);
        farm1.addObject(lake1);
        farm2.addObject(lake2);
        farm3.addObject(lake3);
        farm4.addObject(lake4);
        farm1.addObject(lake5);
        farm2.addObject(lake6);
        farm1.addObject(quarry1);
        farm2.addObject(quarry2);
        farm3.addObject(quarry3);
        farm4.addObject(quarry4);
        farm1.setXStart(0);
        farm1.setYStart(0);
        farm2.setXStart(150);
        farm2.setYStart(0);
        farm3.setXStart(0);
        farm3.setYStart(150);
        farm4.setXStart(150);
        farm4.setYStart(150);
        ArrayList<Farm> farms = new ArrayList<>(List.of(farm1, farm2, farm3, farm4));
        map.setCreatedFarms(farms);
        for (Farm farm : map.getCreatedFarms()) {
            for (Tile tile : farm.getTiles()) {
                tile.setX(tile.getX() + farm.getXStart());
                tile.setY(tile.getY() + farm.getYStart());
            }
            for (Objectt object : farm.getObjects()) {
                for (Tile tile : object.getTiles()) {
                    tile.setX(tile.getX() + farm.getXStart());
                    tile.setY(tile.getY() + farm.getYStart());
                }
            }
        }
        App.getCurrentGame().getPlayers().get(0).setX(tilesCottage1.get(5).getX());
        App.getCurrentGame().getPlayers().get(0).setY(tilesCottage1.get(5).getY());
        App.getCurrentGame().getPlayers().get(1).setX(tilesCottage2.get(4).getX());
        App.getCurrentGame().getPlayers().get(1).setY(tilesCottage2.get(4).getY());
        App.getCurrentGame().getPlayers().get(2).setX(tilesCottage3.get(3).getX());
        App.getCurrentGame().getPlayers().get(2).setY(tilesCottage3.get(3).getY());
        App.getCurrentGame().getPlayers().get(3).setX(tilesCottage4.get(2).getX());
        App.getCurrentGame().getPlayers().get(3).setY(tilesCottage4.get(2).getY());
        for (Farm farm : farms) {
            boolean flag = false;
            while (!flag) {
                int randomX = (new Random()).nextInt(Farm.getXRange()) + farm.getXStart();
                int randomY = (new Random()).nextInt(Farm.getYRange()) + farm.getYStart();
                boolean objectExists = false;
                for (Objectt object : farm.getObjects()) {
                    for (Tile tile : object.getTiles()) {
                        if (tile.getX() == randomX && tile.getY() == randomY) {
                            objectExists = true;
                            break;
                        }
                    }
                    if (objectExists) break;
                }
                if (!objectExists) {
                    flag = true;
                    SalesBucket bucket = new SalesBucket();
                    bucket.setTiles(new ArrayList<>(List.of(new Tile('k', randomX, randomY))));
                    farm.getObjects().add(bucket);
                }
            }
        }
    }

    public Result loadGame() {
        Game game = App.getLoggedInUser().getCurrentGame();
        if (game == null)
            return new Result(false, "You don't have an active game.");
        App.setCurrentGame(game);
        App.setCurrentMenu(Menu.GameMenu);
        for (Player player : game.players) {
            if (player.getUser().equals(App.getLoggedInUser()))
                game.setMainPlayer(player);
        }
        Map map = App.getCurrentGame().getMap();
        if (map.getFarms().size() < App.getCurrentGame().players.size()) App.setCurrentMenu(Menu.MapSelectionMenu);
        return new Result(true, "The game is loaded successfully.");
    }
}
