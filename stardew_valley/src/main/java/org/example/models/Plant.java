package org.example.models;

import java.util.Random;

public abstract class Plant extends Objectt{
    protected final Seed seed;
    protected String name;
    protected int stage;
    protected int totalHarvestTime;
    protected int remainingTime;
    protected boolean isWateredEveryDay = false;
    protected boolean isWateredToday = false;
    protected boolean isWateredYesterday = true;
    protected boolean isFertilizedBySpeedGro = false;
    protected boolean isFertilizedByRetainingSoil = false;
    protected boolean isReadyForHarvest = false;
    protected boolean isForaging = false;

    public Plant(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {

        return seed;
    }

    public boolean isWateredEveryDay() {
        return isWateredEveryDay;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public String getName() {
        return name;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void incrementStage() {
        stage++;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void decrementRemainingTime() {
        remainingTime--;
        if (remainingTime == 0) isReadyForHarvest = true;
    }

    public boolean isWateredToday() {
        return isWateredToday;
    }

    public void setWateredToday(boolean wateredToday) {
        isWateredToday = wateredToday;
    }

    public boolean isWateredYesterday() {
        return isWateredYesterday;
    }

    public void setWateredYesterday(boolean wateredYesterday) {
        isWateredYesterday = wateredYesterday;
    }

    public boolean isReadyForHarvest() {
        return isReadyForHarvest;
    }

    public void setReadyForHarvest(boolean readyForHarvest) {
        isReadyForHarvest = readyForHarvest;
    }

    public boolean isForaging() {
        return isForaging;
    }

    public void setForaging(boolean foraging) {
        isForaging = foraging;
    }

    public abstract void grow();

    public void fertilize(String fertilizer) {
        if (fertilizer.equalsIgnoreCase("Speed-Gro")) {
            isFertilizedBySpeedGro = true;
            this.grow();
        }
        else {
            isFertilizedByRetainingSoil = true;
            int random = (new Random()).nextInt(3);
            if (fertilizer.equalsIgnoreCase("BasicRetainingSoil")) {
                if (random == 0) isWateredEveryDay = true;
            }
            else if (fertilizer.equalsIgnoreCase("QualityRetainingSoil")) {
                if (random != 0) isWateredEveryDay = true;
            }
            else if (fertilizer.equalsIgnoreCase("DeluxeRetainingSoil")) {
                isWateredEveryDay = true;
            }
        }
    }

    public boolean isFertilizedBySpeedGro() {
        return isFertilizedBySpeedGro;
    }

    public void setFertilizedBySpeedGro(boolean fertilizedBySpeedGro) {
        isFertilizedBySpeedGro = fertilizedBySpeedGro;
    }

    public boolean isFertilizedByRetainingSoil() {
        return isFertilizedByRetainingSoil;
    }

    public void setFertilizedByRetainingSoil(boolean fertilizedByRetainingSoil) {
        isFertilizedByRetainingSoil = fertilizedByRetainingSoil;
    }

    @Override
    public String toString() {
        String water = "It isn't watered today.";
        String fertilize = "It isn't fertilized.";
        String foraging = "";
        if (isWateredToday) water = "It is watered today.";
        if (isFertilizedBySpeedGro || isFertilizedByRetainingSoil) fertilize = "It is fertilized.";
        if (isForaging) foraging = "\nThis is a foraging plant.";
        return
                "Name: " + name + "\nStage: " + stage +
                "\nRemaining Time Till Harvest: " + remainingTime + "\n" +
                water + "\n" + fertilize + foraging;
    }
}
