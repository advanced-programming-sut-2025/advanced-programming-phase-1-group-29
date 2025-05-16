package org.example.models;

import org.example.models.FarmPackage.Farm;
import org.example.models.VillagePackage.Village;

import java.util.ArrayList;

public class Map {
    private static final int xRange = 200;
    private static final int yRange = 200;
    private ArrayList<Farm> farms = new ArrayList<>();
    private ArrayList<Farm> createdFarms = new ArrayList<>();
    private ArrayList<Objectt> objects = new ArrayList<>();
    private Village village;

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public ArrayList<Farm> getCreatedFarms() {
        return createdFarms;
    }

    public void setCreatedFarms(ArrayList<Farm> createdFarms) {
        this.createdFarms = createdFarms;
    }

    public ArrayList<Objectt> getObjects() {
        return objects;
    }

    public void setFarms(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    public void setObjects(ArrayList<Objectt> objects) {
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

    public void addObject(Objectt object){
        objects.add(object);
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
