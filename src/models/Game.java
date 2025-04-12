package models;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    private int turn = 0;

    private Map map;

    private DateAndTime dateAndTime = new DateAndTime();

    private int numberOfWoods = 0;

    private int numberOfCoins = 0;

}
