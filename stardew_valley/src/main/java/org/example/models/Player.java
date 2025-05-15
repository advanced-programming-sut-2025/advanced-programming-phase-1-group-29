package org.example.models;

import org.example.models.VillagePackage.NPCMissionList;
import org.example.models.enums.CraftingItemEnum;
import org.example.models.enums.FoodRecipe;
import org.example.models.enums.TrashCan;

import java.util.ArrayList;
import java.util.List;

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
    private int coins = 0;
    private Inventory inventory = new Inventory();
    private final ArrayList<FoodRecipe> foodRecipeList = new ArrayList<>();
    private final ArrayList<CraftingItemEnum> craftingRecipeList = new ArrayList<>();
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
    private ArrayList<ArrayList<String>> talkHistory = new ArrayList<>();
    private boolean isCollapsed = false;
    private ArrayList<String> giftItems = new ArrayList<>();
    private ArrayList<Integer> giftNumbers = new ArrayList<>();
    private ArrayList<Integer> giftPlayersIndex = new ArrayList<>();
    private boolean[] flower = new boolean[5];
    private boolean[] askMarriage = new boolean[5];
    private boolean[] married = new boolean[5];
    private ArrayList<String> ring = new ArrayList<>();



    public void setAskMarriage(int index) {
        askMarriage[index] = true;
    }
    public boolean getAskMarriage(int index) {
        return askMarriage[index];
    }
    public void setMarried(int index) {
        married[index] = true;
    }
    public boolean getMarried(int index) {
        return married[index];
    }

    public void setFlower(int index) {
        flower[index] = true;
    }

    public boolean getFlower(int index) {
        return flower[index];
    }

    public Player() {
        for (int i = 0; i < 5; i++) {
            talkHistory.add(new ArrayList<>());
            flower[i] = false;
        }
        for (int i = 0; i < 5; i++) {
            ring.add(null);
        }
    }
    public void addTalk(String message, int index){
        talkHistory.get(index).add(message);
    }
    public ArrayList<String> getTalkHistory(int ind){
        return talkHistory.get(ind);
    }
    public void addGift(String name, int amount, int index){
        giftItems.add(name);
        giftNumbers.add(amount);
        giftPlayersIndex.add(index);
    }

    public ArrayList<String> getRing() {
        return ring;
    }

    public void setRing(int index, String name) {
        ring.set(index, name);
    }

    public ArrayList<String> getGiftItems() {
        return giftItems;
    }

    public ArrayList<Integer> getGiftNumbers() {
        return giftNumbers;
    }

    public ArrayList<Integer> getGiftPlayersIndex() {
        return giftPlayersIndex;
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
        this.energy = Math.max(200,energy);
        if (energy <= 0 && !isEnergyUnlimited) isCollapsed = true;
    }

    public void addEnergy(int amount) {
        energy += amount;
    }

    public void reduceEnergy(int amount) {
        energy -= amount;
        if(energy < 0) energy = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<FoodRecipe> getFoodRecipeList() {
        return foodRecipeList;
    }

    public ArrayList<CraftingItemEnum> getCraftingRecipeList() {
        return craftingRecipeList;
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
        int ind = -1;
        for (int i = 0; i < 5; i++) {
            if (married[i]) {
                ind = i;
            }
        }
        if (ind == -1) return coins;
        else return coins + App.getCurrentGame().getPlayers().get(ind).getCoins();
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

    public boolean isCollapsed() {
        return isCollapsed;
    }

    public void setCollapsed(boolean collapsed) {
        isCollapsed = collapsed;
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
