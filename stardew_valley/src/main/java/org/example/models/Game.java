package org.example.models;

import org.example.models.enums.Weather;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players = new ArrayList<>();
    private Player mainPlayer;
    private int turn = 0;
    private DateTime currentTime;
    private Map map;
    private Weather weather = Weather.RAINY;
    private Weather cheatWeather = null;
    private TradeMenu tradeMenu = new TradeMenu();

    public TradeMenu getTradeMenu() {
        return tradeMenu;
    }

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

    public void nextTurn() {
        turn++;
        if (turn == players.size()) {
            turn = 0;
            currentTime.incrementTime();
        }
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

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Player getCurrentPlayer() {
        return players.get(turn);
    }

    public Farm getCurrentFarm() {
        return this.map.getFarms().get(turn);
    }

    public Weather getCheatWeather() {
        return cheatWeather;
    }

    public void setCheatWeather(Weather cheatWeather) {
        this.cheatWeather = cheatWeather;
    }
}
