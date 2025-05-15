package org.example.models;

import java.util.ArrayList;

public class Farm extends Objectt {
    private static int xRange = 50;
    private static int yRange = 50;
    private int xStart;
    private int yStart;
    private final int number;
    private ArrayList<Objectt> objects = new ArrayList<>();
    int numOfForaging = 0;

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

    public void setObjects(ArrayList<Objectt> objects) {
        this.objects = objects;
    }

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

    public Cottage getCottage() {
        for (Objectt object : objects) {
            if (object instanceof Cottage) {
                return (Cottage) object;
            }
        }
        return null;
    }

    public int getNumOfForaging() {
        return numOfForaging;
    }

    public void incrementNumOfForaging() {
        numOfForaging++;
    }
    public void decrementNumOfForaging() {
        numOfForaging--;
    }
}
