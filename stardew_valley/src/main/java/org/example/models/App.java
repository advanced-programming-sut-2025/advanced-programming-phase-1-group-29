package org.example.models;

import org.example.models.enums.Menu;

import java.util.ArrayList;

public class App {
    private static Menu currentMenu = Menu.RegisterMenu;
    private final static ArrayList<User> users = new ArrayList<>();

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
