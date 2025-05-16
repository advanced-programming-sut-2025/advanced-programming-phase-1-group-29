package org.example.models;

import java.util.ArrayList;

public class TradeMenu {
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Integer> amounts = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();
    private ArrayList<String> targetItems = new ArrayList<>();
    private ArrayList<Integer> targetAmounts = new ArrayList<>();
    private ArrayList<String> targetUsernames = new ArrayList<>();

    public void addTargetUsername(String username) {
        targetUsernames.add(username);
    }

    public ArrayList<String> getTargetUsernames() {
        return targetUsernames;
    }

    public void addUsername(String username) {
        usernames.add(username);
    }
    public void addType(String type) {
        types.add(type);
    }
    public void addItem(String item) {
        items.add(item);
    }
    public void addAmount(int amount) {
        amounts.add(amount);
    }
    public void addPrice(int price) {
        prices.add(price);
    }
    public void addTargetItem(String item) {
        targetItems.add(item);
    }
    public void addTargetAmount(int amount) {
        targetAmounts.add(amount);
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<Integer> getAmounts() {
        return amounts;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public ArrayList<String> getTargetItems() {
        return targetItems;
    }

    public ArrayList<Integer> getTargetAmounts() {
        return targetAmounts;
    }
}
