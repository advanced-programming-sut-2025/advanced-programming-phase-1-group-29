package org.example.models;

import java.util.HashMap;

public class Cottage extends Objectt {

    private final Refrigerator refrigerator;

    {
        refrigerator = new Refrigerator();
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }
}
