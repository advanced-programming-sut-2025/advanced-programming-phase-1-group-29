package models;

import models.enums.Season;

import java.lang.Object;

public class Crop extends Object {
    private String name;
    private Seed sourceSeed;
    private int stage = 1;
    private int germinationTime;
    private boolean isReusable;
    private int harvestIntervals;
    private int basicPrice;
    private boolean isEatable;
    private int energy;
    private Season season;
    private boolean doesGetGiant;

}
