package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Objectt;
import org.example.models.Player;
import org.example.models.Tile;

import java.util.ArrayList;

public class Village{
    private final static int xRange = 60;
    private final static int yRange = 60;
    private int xStart;
    private int yStart;
    private ArrayList<Objectt> objects = new ArrayList<>();

    public Village(){
        xStart = 70;
        yStart = 70;
        BlackSmithStore blackSmithStore = new BlackSmithStore();
        ArrayList<Tile> blackSmithTiles = new ArrayList<>();
        for (int i = 20; i < 30; i++){
            for (int j = 20; j < 30; j++){
                blackSmithTiles.add(new Tile('b', i, j));
            }
        }
        blackSmithStore.setTiles(blackSmithTiles);
        objects.add(blackSmithStore);
        CarpentersShop carpentersShop = new CarpentersShop();
        ArrayList<Tile> carpentersTiles = new ArrayList<>();
        for (int i = 5; i < 10; i++){
            for (int j = 35; j < 50; j++){
                carpentersTiles.add(new Tile('c', i, j));
            }
        }
        carpentersShop.setTiles(carpentersTiles);
        objects.add(carpentersShop);
        FishShop fishShop = new FishShop();
        ArrayList<Tile> fishTiles = new ArrayList<>();
        for (int i = 10; i < 20; i++){
            for (int j = 5; j < 10; j++){
                fishTiles.add(new Tile('f', i, j));
            }
        }
        fishShop.setTiles(fishTiles);
        objects.add(fishShop);
        JojaMartStore jojaMartStore = new JojaMartStore();
        ArrayList<Tile> jojaMartTiles = new ArrayList<>();
        for (int i = 35; i < 45; i++){
            for (int j = 5; j < 15; j++){
                jojaMartTiles.add(new Tile('J', i, j));
            }
        }
        jojaMartStore.setTiles(jojaMartTiles);
        objects.add(jojaMartStore);
        MarniesRanch marniesRanch = new MarniesRanch();
        ArrayList<Tile> marniesRanchTiles = new ArrayList<>();
        for (int i = 50; i < 55; i++){
            for (int j = 20; j < 35; j++){
                marniesRanchTiles.add(new Tile('M', i, j));
            }
        }
        marniesRanch.setTiles(marniesRanchTiles);
        objects.add(marniesRanch);
        PierresGeneralStore pierresGeneralStore = new PierresGeneralStore();
        ArrayList<Tile> pierresGeneralTiles = new ArrayList<>();
        for (int i = 30; i < 50; i++){
            for (int j = 40; j < 45; j++){
                pierresGeneralTiles.add(new Tile('P', i, j));
            }
        }
        pierresGeneralStore.setTiles(pierresGeneralTiles);
        objects.add(pierresGeneralStore);
        TheStardropSaloon stardropSaloon = new TheStardropSaloon();
        ArrayList<Tile> stardropSaloonTiles = new ArrayList<>();
        for (int i = 15; i < 25; i++){
            for (int j = 45; j < 55; j++){
                stardropSaloonTiles.add(new Tile('S', i, j));
            }
        }
        stardropSaloon.setTiles(stardropSaloonTiles);
        objects.add(stardropSaloon);
        SebastiansHouse sebastiansHouse = new SebastiansHouse();
        ArrayList<Tile> sebastiansHouseTiles = new ArrayList<>();
        for (int i = 5; i < 10; i++){
            for (int j = 15; j < 20; j++){
                sebastiansHouseTiles.add(new Tile('s', i, j));
            }
        }
        sebastiansHouse.setTiles(sebastiansHouseTiles);
        sebastiansHouse.setNPCPlaceX(6 + xStart);
        sebastiansHouse.setNPCPlaceY(16 + yStart);
        objects.add(sebastiansHouse);
        AbigailsHouse abigailsHouse = new AbigailsHouse();
        ArrayList<Tile> abigailsHouseTiles = new ArrayList<>();
        for (int i = 35; i < 40; i++){
            for (int j = 25; j < 30; j++){
                abigailsHouseTiles.add(new Tile('a', i, j));
            }
        }
        abigailsHouse.setTiles(abigailsHouseTiles);
        abigailsHouse.setNPCPlaceX(36 + xStart);
        abigailsHouse.setNPCPlaceY(26 + yStart);
        objects.add(abigailsHouse);
        HarveysHouse harveysHouse = new HarveysHouse();
        ArrayList<Tile> harveysHouseTiles = new ArrayList<>();
        for (int i = 25; i < 30; i++){
            for (int j = 10; j < 15; j++){
                harveysHouseTiles.add(new Tile('h', i, j));
            }
        }
        harveysHouse.setTiles(harveysHouseTiles);
        harveysHouse.setNPCPlaceX(26 + xStart);
        harveysHouse.setNPCPlaceY(11 + yStart);
        objects.add(harveysHouse);
        LiasHouse liasHouse = new LiasHouse();
        ArrayList<Tile> liasHouseTiles = new ArrayList<>();
        for (int i = 15; i < 25; i++){
            for (int j = 35; j < 40; j++){
                liasHouseTiles.add(new Tile('l', i, j));
            }
        }
        liasHouse.setTiles(liasHouseTiles);
        liasHouse.setNPCPlaceX(16 + xStart);
        liasHouse.setNPCPlaceY(36 + yStart);
        objects.add(liasHouse);
        RobinsHouse robinsHouse = new RobinsHouse();
        ArrayList<Tile> robinsHouseTiles = new ArrayList<>();
        for (int i = 40; i < 50; i++){
            for (int j = 50; j < 55; j++){
                robinsHouseTiles.add(new Tile('r', i, j));
            }
        }
        robinsHouse.setTiles(robinsHouseTiles);
        robinsHouse.setNPCPlaceX(41 + xStart);
        robinsHouse.setNPCPlaceY(51 + yStart);
        objects.add(robinsHouse);
        for (Objectt object : objects) {
            for (Tile tile : object.getTiles()) {
                tile.setX(tile.getX() + xStart);
                tile.setY(tile.getY() + yStart);
            }
        }
    }

    public static int getXRange() {
        return xRange;
    }

    public static int getYRange() {
        return yRange;
    }

    public int getXStart() {
        return xStart;
    }

    public int getYStart() {
        return yStart;
    }

    public void setXStart(int xStart) {
        this.xStart = xStart;
    }

    public void setYStart(int yStart) {
        this.yStart = yStart;
    }

    public ArrayList<Objectt> getObjects() {
        return objects;
    }

    public void addObject(Objectt object){
        this.objects.add(object);
    }

    public Objectt getCurrentPlace(){
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        for (Objectt object : objects){
            boolean check = false;
            for (Tile tile : object.getTiles()){
                if (tile.getX() == currentPlayer.getX() && tile.getY() == currentPlayer.getY()){
                    check = true;
                }
            }
            if (check){
                return object;
            }
        }
        return null;
    }
}
