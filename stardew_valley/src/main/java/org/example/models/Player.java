package org.example.models;

import org.example.models.enums.TrashCan;

public class Player {
    private int farmNumber;
    private int energy = 100;
    private int farmingLevel = 0;
    private int miningLevel = 0;
    private int foragingLevel = 0;
    private int fishingLevel = 0;
    int coins = 0;
    private Inventory inventory = new Inventory();
    private boolean isEnergyUnlimited = false;
    private Tool currentTool = null;
    private User user;
    TrashCan trashCan = TrashCan.PRIMARY;


    public int getFarmNumber() {
        return farmNumber;
    }

    public void setFarmNumber(int farmNumber) {
        this.farmNumber = farmNumber;
    }

    public int getFarmingLevel() {
        return farmingLevel;
    }

    public void setFarmingLevel(int farmingLevel) {
        this.farmingLevel = farmingLevel;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public int getForagingLevel() {
        return foragingLevel;
    }

    public void setForagingLevel(int foragingLevel) {
        this.foragingLevel = foragingLevel;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public void setFishingLevel(int fishingLevel) {
        this.fishingLevel = fishingLevel;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isEnergyUnlimited() {
        return isEnergyUnlimited;
    }

    public void setEnergyUnlimited(boolean energyUnlimited) {
        isEnergyUnlimited = energyUnlimited;
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public User getUser() {
        return user;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public TrashCan getTrashCan() {
        return trashCan;
    }

    public void setTrashCan(TrashCan trashCan) {
        this.trashCan = trashCan;
    }
}
