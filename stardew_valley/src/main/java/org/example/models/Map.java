package org.example.models;

import java.util.ArrayList;

public class Map {
    private static final int xRange = 120;
    private static final int yRange = 120;
    private ArrayList<Farm> farms;
    private ArrayList<Object> objects;

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public void setFarms(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public static int getXRange(){
        return xRange;
    }
    public static int getYRange(){
        return yRange;
    }

    public void addFarm(Farm farm){
        farms.add(farm);
    }
    public void addObject(Object object){
        objects.add(object);
    }


}
