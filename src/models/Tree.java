package models;

import models.enums.Season;

public class Tree extends Object{
    private String name;
    private Seed sourceSeed;
    private int stage = 1;
    private int germinationTime;
    private int harvestIntervals;
    private int basicPrice;
    private boolean isEatable;
    private int energy;
    private Season season;
    private boolean doesGetGiant;
    private boolean isBurned;
}
