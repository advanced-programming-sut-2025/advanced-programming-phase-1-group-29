package org.example.models;

import org.example.models.VillagePackage.NPCHouse;
import org.example.models.VillagePackage.Store;
import org.example.models.enums.CropEnum;
import org.example.models.enums.Season;
import org.example.models.enums.TreeEnum;

import java.util.ArrayList;

public class DateTime {
    private Season season;
    private int day;
    private int time;

    public DateTime(Season season, int day, int time) {
        this.season = season;
        this.day = day;
        this.time = time;
    }

    public void incrementTime() {
        time++;
        if (time == 24) {
            time = 0;
            incrementDay();
        }
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                ((Store) objectt).openStore();
            }
        }
    }

    private void growCrop(Crop crop) {
        crop.decrementRemainingTime();
        CropEnum cropEnum = crop.getCrop();
        int sum = 0;
        for (int i = 0; i < cropEnum.getStages().size() - 1; i++) {
            sum += cropEnum.getStages().get(i);
            if (sum == cropEnum.getTotalHarvestTime() - crop.getRemainingTime())
                crop.incrementStage();
        }
    }

    private void growTree(FruitTree tree) {
        tree.decrementRemainingTime();
        TreeEnum treeEnum = tree.getTree();
        int sum = 0;
        for (int i = 0; i < treeEnum.getStages().size() - 1; i++) {
            sum += treeEnum.getStages().get(i);
            if (sum == treeEnum.getTotalHarvestTime() - tree.getRemainingTime())
                tree.incrementStage();
        }
    }

    public void incrementDay() {
        day++;
        if (day == 29) {
            day = 1;
            if (season.equals(Season.Spring)) setSeason(Season.Summer);
            else if (season.equals(Season.Summer)) setSeason(Season.Fall);
            else if (season.equals(Season.Fall)) setSeason(Season.Winter);
            else setSeason(Season.Spring);
        }
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                ((Store) objectt).resetCapacity();
            }
            else if (objectt instanceof NPCHouse){
                ((NPCHouse) objectt).setMeetNPCToday(false);
                ((NPCHouse) objectt).setGiftNPCToday(false);
            }
        }
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Objectt> toBeRemoved = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant plant) {
                    if ((!plant.isWateredToday()) && (!plant.isWateredYesterday())) {
                        toBeRemoved.add(object);
                    }
                    else {
                        plant.setWateredYesterday(plant.isWateredToday());
                        plant.setWateredToday(false);
                        if (!plant.isReadyForHarvest()) {
                            if (plant instanceof Crop) {
                                growCrop((Crop) plant);
                            }
                            else {
                                growTree((FruitTree) plant);
                            }
                        }
                    }
                }
            }
            for (Objectt object : toBeRemoved) {
                farm.getObjects().remove(object);
            }
        }
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
