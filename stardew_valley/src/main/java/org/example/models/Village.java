package org.example.models;

import java.util.ArrayList;

public class Village{
    private static int xRange = 60;
    private static int yRange = 60;
    private int xStart;
    private int yStart;
    private ArrayList<Objectt> objects = new ArrayList<>();

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

    public static void setXRange(int xRange) {
        Village.xRange = xRange;
    }

    public static void setYRange(int yRange) {
        Village.yRange = yRange;
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
}
