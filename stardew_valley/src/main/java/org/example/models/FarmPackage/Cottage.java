package org.example.models.FarmPackage;

import org.example.models.Objectt;
import org.example.models.Refrigerator;

public class Cottage extends Objectt {

    private final Refrigerator refrigerator;

    {
        refrigerator = new Refrigerator();
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }
}
