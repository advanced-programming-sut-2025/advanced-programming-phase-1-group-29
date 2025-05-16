package org.example.models;

import org.example.models.enums.Menu;

import java.io.Serializable;
import java.util.ArrayList;

public class AppState implements Serializable {
    private Menu currentMenu;
    private ArrayList<User> users;
    private User loggedInUser;
    private boolean stayLoggedIn;
    private Game currentGame;
    private ArrayList<Game> games;
    private ArrayList<Map> maps;

    public AppState(Menu currentMenu, ArrayList<User> users, User loggedInUser,
                    boolean stayLoggedIn, Game currentGame, ArrayList<Game> games, ArrayList<Map> maps) {
        this.currentMenu = currentMenu;
        this.users = users;
        this.loggedInUser = loggedInUser;
        this.stayLoggedIn = stayLoggedIn;
        this.currentGame = currentGame;
        this.games = games;
        this.maps = maps;
    }

    // Getters for App loading
    public Menu getCurrentMenu() { return currentMenu; }
    public ArrayList<User> getUsers() { return users; }
    public User getLoggedInUser() { return loggedInUser; }
    public boolean isStayLoggedIn() { return stayLoggedIn; }
    public Game getCurrentGame() { return currentGame; }
    public ArrayList<Game> getGames() { return games; }
    public ArrayList<Map> getMaps() { return maps; }
}
