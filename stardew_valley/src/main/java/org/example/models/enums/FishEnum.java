package org.example.models.enums;

import java.util.ArrayList;
import java.util.Random;

public enum FishEnum {
    Salmon ("Salmon", false, 75, Season.Fall),
    Sardine ("Sardine", false, 40, Season.Fall),
    Shad ("Shad", false, 60, Season.Fall),
    BlueDiscus ("Blue Discus", false, 120, Season.Fall),
    MidnightCarp ("Midnight Carp", false, 150, Season.Winter),
    Squid ("Squid", false, 80, Season.Winter),
    Tuna ("Tuna", false, 100, Season.Winter),
    Perch ("Perch", false, 55, Season.Winter),
    Flounder ("Flounder", false, 100, Season.Spring),
    Lionfish ("Lionfish", false, 100, Season.Spring),
    Herring ("Herring", false, 30, Season.Spring),
    Ghostfish ("Ghostfish", false, 45, Season.Spring),
    Tilapia ("Tilapia", false, 75, Season.Summer),
    Dorado ("Dorado", false, 100, Season.Summer),
    Sunfish ("Sunfish", false, 30, Season.Summer),
    RainbowTrout ("Rainbow Trout", false, 65, Season.Summer),
    Legend ("Legend", true, 5000, Season.Spring),
    Glacierfish ("Glacierfish", true, 1000, Season.Winter),
    Angler ("Angler", true, 900, Season.Fall),
    Crimsonfish ("Crimsonfish", true, 1500, Season.Summer),
    ;

    private final static int normalFishCount = 16;
    private final static int legendaryFishCount = 4;
    private final String name;
    private final Boolean legendary;
    private final int price;
    private final Season season;

    private FishEnum(String name, Boolean legendary, int price, Season season) {
        this.name = name;
        this.legendary = legendary;
        this.price = price;
        this.season = season;
    }

    public static FishEnum getRandomFish(Season season, Boolean isTalented) {
        ArrayList<FishEnum> fishEnums = new ArrayList<>();
        for (FishEnum fishEnum : FishEnum.values()) {
            if (fishEnum.season == season) {
                if(fishEnum.legendary){
                    if(isTalented){
                        fishEnums.add(fishEnum);
                    }
                }
                else {
                    fishEnums.add(fishEnum);
                }
            }
        }
        Random rand = new Random();
        int index = rand.nextInt(fishEnums.size());
        return fishEnums.get(index);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Season getSeason() {
        return season;
    }

    public static FishEnum getByName(String fishName) {
        for (FishEnum fishEnum : FishEnum.values()) {
            if(fishEnum.toString().equals(fishName)){
                return fishEnum;
            }
        }
        return null;
    }
}
