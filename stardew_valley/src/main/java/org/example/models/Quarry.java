package org.example.models;

import java.util.ArrayList;

public class Quarry extends Objectt {
    private ArrayList<Foraging> minerals = new ArrayList<>();

    public ArrayList<Foraging> getMinerals() {
        return minerals;
    }

    public void addMineral(Foraging foraging) {
        this.minerals.add(foraging);
    }
}
