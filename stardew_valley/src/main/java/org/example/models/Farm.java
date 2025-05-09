package org.example.models;

import java.util.ArrayList;

public class Farm extends Objectt {
    private static int xRange = 50;
    private static int yRange = 50;
    private ArrayList<Objectt> objects = new ArrayList<>();

    public static int getXRange() {
        return xRange;
    }

    public static int getYRange() {
        return yRange;
    }

    public ArrayList<Objectt> getObjects() {
        return objects;
    }

    public void addObject(Objectt object){
        objects.add(object);
    }
}
