package org.example.models.FarmPackage;

import org.example.models.Foraging;
import org.example.models.Objectt;

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
