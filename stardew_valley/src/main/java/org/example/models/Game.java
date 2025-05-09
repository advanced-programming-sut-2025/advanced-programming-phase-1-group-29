package org.example.models;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players;
    private Player mainPlayer;
    private int turn = 0;
    private DateTime currentTime;
    private Map map;

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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isMainPlayerPlaying(){
        return mainPlayer.equals(players.get(turn));
    }
}
