package models;

import models.enums.Weather;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    private Weather weather;

    private int turn = 0;

    private Map map;

    private DateAndTime dateAndTime = new DateAndTime();

    private int numberOfWoods = 0;

    private int numberOfCoins = 0;

    private ArrayList<Trade> trades;

    private void incrementTurn() {}

    private void incrementTime(){}

    private void incrementDay() {}

    private void setThor() {}

}
