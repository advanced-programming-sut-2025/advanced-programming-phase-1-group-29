package org.example.models.VillagePackage;

import org.example.models.Objectt;
import org.example.models.Result;

import java.util.ArrayList;

public abstract class NPCHouse extends Objectt {
    private int NPCPlaceX = 0;
    private int NPCPlaceY = 0;

    public abstract Result meetNPC();

    public int getNPCPlaceX() {
        return NPCPlaceX;
    }

    public int getNPCPlaceY() {
        return NPCPlaceY;
    }

    public void setNPCPlaceX(int NPCPlaceX) {
        this.NPCPlaceX = NPCPlaceX;
    }

    public void setNPCPlaceY(int NPCPlaceY) {
        this.NPCPlaceY = NPCPlaceY;
    }
}
