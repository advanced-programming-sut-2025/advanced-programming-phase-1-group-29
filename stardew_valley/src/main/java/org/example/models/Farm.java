package org.example.models;

import java.util.ArrayList;

public class Farm extends Object {
    private static int xRange = 50;
    private static int yRange = 50;
    private final int number;
    private ArrayList<Object> objects = new ArrayList<>();

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

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public void addObject(Object object){
        objects.add(object);
    }
}
