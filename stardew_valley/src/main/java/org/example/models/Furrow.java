package org.example.models;

import java.util.ArrayList;

public class Furrow extends Objectt {
    private ArrayList<String> fertilizers = new ArrayList<>();

    public ArrayList<String> getFertilizers() {
        return fertilizers;
    }

    public void addFertilizer(String fertilizer){
        fertilizers.add(fertilizer);
    }
}
