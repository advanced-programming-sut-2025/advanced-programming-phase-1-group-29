package org.example.models;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players;
    private Player mainPlayer;
    private int turn;
    private DateTime currentTime;

    public Player getMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public DateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(DateTime currentTime) {
        this.currentTime = currentTime;
    }
}
