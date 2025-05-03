package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;

public class MainMenuController extends Controller{
    public Result menuEnter(String menuName) {
        if (menuName.equals("Profile Menu")) {
            App.setCurrentMenu(Menu.ProfileMenu);
            return new Result(true, "Now you are in Profile Menu.");
        }
        if (menuName.equals("Game Menu")) {
            App.setCurrentMenu(Menu.GameMenu);
            return new Result(true, "Now you are in Game Menu.");
        }
        if (menuName.equals("Avatar Menu")) {
            App.setCurrentMenu(Menu.AvatarMenu);
            return new Result(true, "Now you are in Avatar Menu.");
        }
        return new Result(false, "Invalid menu");
    }

    public Result userLogout() {
        App.setLoggedInUser(null);
        App.setCurrentMenu(Menu.RegisterMenu);
        return new Result(true, "You logged out successfully.");
    }
}
