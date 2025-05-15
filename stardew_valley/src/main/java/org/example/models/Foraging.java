package org.example.models;

import org.example.models.enums.ForagingMineral;

public class Foraging extends Objectt {
    private final ForagingMineral mineral;

    public Foraging(ForagingMineral mineral) {
        this.mineral = mineral;
    }

    public ForagingMineral getMineral() {
        return mineral;
    }
}
