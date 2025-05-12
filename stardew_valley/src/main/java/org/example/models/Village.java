package org.example.models;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;

public class Village{
    private final static int xRange = 60;
    private final static int yRange = 60;
    private int xStart;
    private int yStart;
    private ArrayList<Objectt> objects = new ArrayList<>();

    public Village(){
        BlackSmithStore blackSmithStore = new BlackSmithStore();
        ArrayList<Tile> blackSmithTiles = new ArrayList<>();
        for (int i = 20; i < 30; i++){
            for (int j = 20; j < 30; j++){
                blackSmithTiles.add(new Tile('B', i, j));
            }
        }
        objects.add(blackSmithStore);
        CarpentersShop carpentersShop = new CarpentersShop();
        ArrayList<Tile> carpentersTiles = new ArrayList<>();
        for (int i = 5; i < 10; i++){
            for (int j = 35; j < 50; j++){
                carpentersTiles.add(new Tile('c', i, j));
            }
        }
        objects.add(carpentersShop);
        FishShop fishShop = new FishShop();
        ArrayList<Tile> fishTiles = new ArrayList<>();
        for (int i = 10; i < 20; i++){
            for (int j = 5; j < 10; j++){
                fishTiles.add(new Tile('f', i, j));
            }
        }
        objects.add(fishShop);
        JojaMartStore jojaMartStore = new JojaMartStore();
        ArrayList<Tile> jojaMartTiles = new ArrayList<>();
        for (int i = 35; i < 45; i++){
            for (int j = 5; j < 15; j++){
                jojaMartTiles.add(new Tile('J', i, j));
            }
        }
        objects.add(jojaMartStore);
        MarniesRanch marniesRanch = new MarniesRanch();
        ArrayList<Tile> marniesRanchTiles = new ArrayList<>();
        for (int i = 50; i < 55; i++){
            for (int j = 20; j < 35; j++){
                marniesRanchTiles.add(new Tile('M', i, j));
            }
        }
        objects.add(marniesRanch);
        PierresGeneralStore pierresGeneralStore = new PierresGeneralStore();
        ArrayList<Tile> pierresGeneralTiles = new ArrayList<>();
        for (int i = 30; i < 50; i++){
            for (int j = 40; j < 45; j++){
                pierresGeneralTiles.add(new Tile('P', i, j));
            }
        }
        objects.add(pierresGeneralStore);
        TheStardropSaloon stardropSaloon = new TheStardropSaloon();
        ArrayList<Tile> stardropSaloonTiles = new ArrayList<>();
        for (int i = 15; i < 25; i++){
            for (int j = 45; j < 55; j++){
                stardropSaloonTiles.add(new Tile('S', i, j));
            }
        }
        objects.add(stardropSaloon);
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
