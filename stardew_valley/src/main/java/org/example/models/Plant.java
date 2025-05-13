package org.example.models;

public abstract class Plant extends Objectt{
    protected final Seed seed;
    protected String name;
    protected int stage;
    protected int remainingTime;
    protected boolean isWateredToday = false;
    protected boolean isWateredYesterday = true;
    protected boolean isFertilized = false;
    protected boolean isReadyForHarvest = false;

    public Plant(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {

        return seed;
    }

    public String getName() {
        return name;
    }

    public int getStage() {
        return stage;
    }

    public void incrementStage() {
        stage++;
    }

    public int getRemainingTime() {
        return remainingTime;
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

    public boolean isFertilized() {
        return isFertilized;
    }

    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
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

    @Override
    public String toString() {
        String water = "It isn't watered today.";
        String fertilize = "It isn't fertilized.";
        if (isWateredToday) water = "It is watered today.";
        if (isFertilized) fertilize = "It is fertilized.";
        return
                "Name: " + name + "\nStage: " + stage +
                "\nRemaining Time Till Harvest: " + remainingTime + "\n" + water + "\n" + fertilize;
    }
}
