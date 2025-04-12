package models;

import models.enums.NPC;
import models.enums.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String username;
    private int farmingAbility;
    private int miningAbility;
    private int foragingAbility;
    private int fishingAbility;
    private Energy currentEnergy;
    private ArrayList<Recipe> recipes;
    private boolean ghash;
    private int currentX;
    private int currentY;
    private HashMap<NPC, Integer> friendshipPoints;

    public void setGhash(boolean ghash) {
        this.ghash = ghash;
    }
}
