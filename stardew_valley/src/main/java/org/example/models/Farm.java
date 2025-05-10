package org.example.models;

import java.util.ArrayList;

public class Farm extends Objectt {
    private static int xRange = 50;
    private static int yRange = 50;
    private final int number;
    private ArrayList<Objectt> objects = new ArrayList<>();

    public Farm(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

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
