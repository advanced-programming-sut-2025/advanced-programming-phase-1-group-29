package org.example.models;

import java.util.ArrayList;

public class Village{
    private final static int xRange = 60;
    private final static int yRange = 60;
    private int xStart;
    private int yStart;
    private ArrayList<Objectt> objects = new ArrayList<>();
    private BlackSmithStore blackSmithStore;
    private CarpentersShop carpentersShop;
    private FishShop fishShop;
    private JojaMartStore jojaMartStore;
    private MarniesRanch marniesRanch;
    private PierresGeneralStore pierresGeneralStore;
    private TheStardropSaloon stardropSaloon;

    public Village(){
        blackSmithStore = new BlackSmithStore();
        ArrayList<Tile> blackSmithTiles = new ArrayList<>();
        for (int i = 20; i < 30; i++){
            for (int j = 20; j < 30; j++){
                blackSmithTiles.add(new Tile('B', i, j));
            }
        }
        carpentersShop = new CarpentersShop();
        ArrayList<Tile> carpentersTiles = new ArrayList<>();
        for (int i = 5; i < 10; i++){
            for (int j = 35; j < 50; j++){
                carpentersTiles.add(new Tile('c', i, j));
            }
        }
        fishShop = new FishShop();
        ArrayList<Tile> fishTiles = new ArrayList<>();
        for (int i = 10; i < 20; i++){
            for (int j = 5; j < 10; j++){
                fishTiles.add(new Tile('f', i, j));
            }
        }
        jojaMartStore = new JojaMartStore();
        ArrayList<Tile> jojaMartTiles = new ArrayList<>();
        for (int i = 35; i < 45; i++){
            for (int j = 5; j < 15; j++){
                jojaMartTiles.add(new Tile('J', i, j));
            }
        }
        marniesRanch = new MarniesRanch();
        ArrayList<Tile> marniesRanchTiles = new ArrayList<>();
        for (int i = 50; i < 55; i++){
            for (int j = 20; j < 35; j++){
                marniesRanchTiles.add(new Tile('M', i, j));
            }
        }
        pierresGeneralStore = new PierresGeneralStore();
        ArrayList<Tile> pierresGeneralTiles = new ArrayList<>();
        for (int i = 30; i < 50; i++){
            for (int j = 40; j < 45; j++){
                pierresGeneralTiles.add(new Tile('P', i, j));
            }
        }
        stardropSaloon = new TheStardropSaloon();
        ArrayList<Tile> stardropSaloonTiles = new ArrayList<>();
        for (int i = 15; i < 25; i++){
            for (int j = 45; j < 55; j++){
                stardropSaloonTiles.add(new Tile('S', i, j));
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

    public BlackSmithStore getBlackSmithStore() {
        return blackSmithStore;
    }

    public CarpentersShop getCarpentersShop() {
        return carpentersShop;
    }

    public FishShop getFishShop() {
        return fishShop;
    }

    public JojaMartStore getJojaMartStore() {
        return jojaMartStore;
    }

    public MarniesRanch getMarniesRanch() {
        return marniesRanch;
    }

    public PierresGeneralStore getPierresGeneralStore() {
        return pierresGeneralStore;
    }

    public TheStardropSaloon getStardropSaloon() {
        return stardropSaloon;
    }
}
