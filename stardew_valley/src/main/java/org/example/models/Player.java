package org.example.models;

import org.example.models.VillagePackage.NPCMissionList;
import org.example.models.enums.FoodRecipe;
import org.example.models.enums.TrashCan;

import java.util.ArrayList;

public class Player {
    private int energy = 200;
    private int farmingLevel = 0;
    private int farmingUnit = 0;
    private int miningLevel = 0;
    private int miningUnit = 0;
    private int foragingLevel = 0;
    private int foragingUnit = 0;
    private int fishingLevel = 0;
    private int fishingUnit = 0;
    int coins = 0;
    private Inventory inventory = new Inventory();
    private final ArrayList<FoodRecipe> foodRecipeList = new ArrayList<>();
    private boolean isEnergyUnlimited = false;
    private Tool currentTool = null;
    private User user;
    private TrashCan trashCan = TrashCan.PRIMARY;
    private int x;
    private int y;
    private int sebastianFriendship = 0;
    private int abigailFriendship = 0;
    private int harveyFriendship = 0;
    private int liaFriendship = 0;
    private int robinFriendship = 0;
    private NPCMissionList npcMissionList = new NPCMissionList();
    private int[] friendship = new int[5];
    private ArrayList<String>[] talkHistory = new ArrayList[5];


    public void addTalk(String message, int index){
        talkHistory[index].add(message);
    }
    public ArrayList<String> getTalkHistory(int ind){
        return talkHistory[ind];
    }
    public int[] getFriendship() {
        return friendship;
    }
    public void addFriendship(int ind, int value) {
        friendship[ind] += value;
    }

    public NPCMissionList getNPCMissionList() {
        return npcMissionList;
    }

    public int getFarmingLevel() {
        return farmingLevel;
    }

    public void addFarmingUnit(int amount) {
        farmingUnit += amount;
        if (farmingUnit >= 100 * farmingLevel + 150)
            farmingLevel++;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void addMiningUnit(int amount) {
        miningUnit += amount;
        if (miningUnit >= 100 * miningLevel + 150)
            miningLevel++;
    }

    public int getForagingLevel() {
        return foragingLevel;
    }

    public void addForagingUnit(int amount) {
        foragingUnit += amount;
        if (foragingUnit >= 100 * foragingLevel + 150)
            foragingLevel++;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public void addFishingUnit(int amount) {
        fishingUnit += amount;
        if (fishingUnit >= 100 * fishingLevel + 150)
            fishingLevel++;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void addEnergy(int amount) {
        energy += amount;
    }

    public void reduceEnergy(int amount) {
        energy -= amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<FoodRecipe> getFoodRecipeList() {
        return foodRecipeList;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSebastianFriendship() {
        return sebastianFriendship;
    }

    public int getAbigailFriendship() {
        return abigailFriendship;
    }

    public int getHarveyFriendship() {
        return harveyFriendship;
    }

    public int getLiaFriendship() {
        return liaFriendship;
    }

    public int getRobinFriendship() {
        return robinFriendship;
    }


    public void addSebastianFriendship(int amount) {
        sebastianFriendship += amount;
    }
    public void addAbigailFriendship(int amount) {
        abigailFriendship += amount;
    }
    public void addHarveyFriendship(int amount) {
        harveyFriendship += amount;
    }
    public void addLiaFriendship(int amount) {
        liaFriendship += amount;
    }
    public void addRobinFriendship(int amount) {
        robinFriendship += amount;
    }
}
