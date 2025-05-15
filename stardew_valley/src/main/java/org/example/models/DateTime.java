package org.example.models;

import org.example.models.VillagePackage.NPCHouse;
import org.example.models.VillagePackage.Store;
import org.example.models.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DateTime {
    private Season season;
    private int day;
    private int time;
    private int year;

    public DateTime(Season season, int day, int time, int year) {
        this.season = season;
        this.day = day;
        this.time = time;
        this.year = year;
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

    private void putForagingSeed(Farm farm, int i, int j) {
        Object remove = null;
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Furrow) {
                if (
                        object.getTiles().getFirst().getX() == i &&
                                object.getTiles().getFirst().getY() == j
                ) {
                    int seedNumber = (new Random()).nextInt(CropSeedEnum.values().length);
                    CropSeedEnum seedEnum = CropSeedEnum.values()[seedNumber];
                    if (seedEnum.getSeasons().contains(season.toString())) {
                        remove = object;
                        if (seedEnum.equals(CropSeedEnum.MIXEDSEED)) {
                            seedNumber = (new Random()).nextInt(
                                    season.getMixedSeedPossibleCrops().size()
                            );
                            seedEnum = season.getMixedSeedPossibleCrops().get(seedNumber).getSource();
                        }
                        Seed seed = new Seed(seedEnum.getName(), 0);
                        Crop crop = new Crop(seed);
                        crop.setTiles(new ArrayList<Tile>(List.of(new Tile('p', i, j))));
                        farm.getObjects().add(crop);
                        crop.setForaging(true);
                    }
                }
            }
        }
        if (remove != null) farm.getObjects().remove(remove);
    }

    private void putForagingCrop(Farm farm, int i, int j) {
        for (Objectt farmObject : farm.getObjects()) {
            for (Tile tile : farmObject.getTiles()) {
                if (tile.getX() == i && tile.getY() == j) {
                    return;
                }
            }
        }
        int cropNumber = (new Random()).nextInt(ForagingCrop.values().length);
        ForagingCrop foragingCrop = ForagingCrop.values()[cropNumber];
        if (foragingCrop.getSeasons().contains(season.toString())) {
            Crop crop = new Crop(ForagingCrop.values()[cropNumber]);
            crop.setTiles(new ArrayList<Tile>(List.of(new Tile('p', i, j))));
            farm.getObjects().add(crop);
            crop.setForaging(true);
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
            if (season.equals(Season.Spring)) year++;
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
        removePlantsOutOfSeason();
        plantGrowth();
        putForaging();
        putForagingMineral();
        setEnergy();
    }

    private void setEnergy() {
        for (Player player : App.getCurrentGame().players) {
            player.setEnergy(200);
            if (player.isCollapsed()) {
                player.setEnergy(150);
                player.setCollapsed(false);
            }
        }
    }

    private void putForagingMineral() {

    }

    private void plantGrowth() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Objectt> toBeRemoved = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant plant) {
                    if ((!plant.isWateredEveryDay()) && (!plant.isWateredToday()) && (!plant.isWateredYesterday())) {
                        toBeRemoved.add(object);
                    }
                    else {
                        plant.setWateredYesterday(plant.isWateredToday());
                        plant.setWateredToday(false);
                        if (!plant.isReadyForHarvest()) {
                            plant.grow();
                        }
                    }
                }
            }
            for (Objectt object : toBeRemoved) {
                farm.getObjects().remove(object);
            }
        }
    }

    private void putForaging() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (int i = farm.getXStart(); i < farm.getXStart() + Farm.getXRange(); i++) {
                for (int j = farm.getYStart(); j < farm.getYStart() + Farm.getYRange(); j++) {
                    int randomNumber = (new Random()).nextInt(100);
                    if (randomNumber == 0) {
                        if (farm.getNumOfForaging() < 5) {
                            int model = (new Random()).nextInt(2);
                            if (model == 0) { //foraging seed
                                putForagingSeed(farm, i, j);
                            }
                            else { //foraging crop
                                putForagingCrop(farm, i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    private void removePlantsOutOfSeason() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Objectt> toBeRemoved = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Crop crop) {
                    if (crop.isForaging()) {
                        if (!crop.getForagingCrop().getSeasons().contains(season.toString())) {
                            toBeRemoved.add(crop);
                        }
                    }
                    else {
                        if (!crop.getCrop().getSeasons().contains(season.toString())) {
                            toBeRemoved.add(crop);
                        }
                    }
                }
                else if (object instanceof FruitTree) {
                    //TODO
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

    public int getYear() {
        return year;
    }
}
