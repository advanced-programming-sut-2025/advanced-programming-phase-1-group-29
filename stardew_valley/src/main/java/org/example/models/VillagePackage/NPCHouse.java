package org.example.models.VillagePackage;

import org.example.models.Objectt;
import org.example.models.Result;

import java.util.ArrayList;

public abstract class NPCHouse extends Objectt {
    private int NPCPlaceX = 0;
    private int NPCPlaceY = 0;
    private boolean meetNPCToday = false;
    private boolean giftNPCToday = false;
    protected boolean quest1 = false;
    protected boolean quest2 = false;
    protected boolean quest3 = false;


    public abstract String getName();

    public abstract Result gift(String itemName);

    public abstract Result meetNPC();

    public abstract Result questsList();

    public void setMeetNPCToday(boolean meetNPCToday) {
        this.meetNPCToday = meetNPCToday;
    }

    public boolean getMeetNPCToday() {
        return meetNPCToday;
    }

    public boolean getGiftNPCToday() {
        return giftNPCToday;
    }

    public void setGiftNPCToday(boolean giftNPCToday) {
        this.giftNPCToday = giftNPCToday;
    }

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
