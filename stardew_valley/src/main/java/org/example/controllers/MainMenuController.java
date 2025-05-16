package org.example.controllers;

import org.example.models.App;
import org.example.models.AppSaver;
import org.example.models.Result;
import org.example.models.enums.Menu;

public class MainMenuController extends Controller{
    public Result profileMenuEnter() {
        App.setCurrentMenu(Menu.ProfileMenu);
        return new Result(true, "Now you are in Profile Menu.");
    }

    public Result gameMenuEnter() {
        App.setCurrentMenu(Menu.PreGameMenu);
        return new Result(true, "Now you are in Game Menu.");
    }
    public Result avatarMenuEnter() {
        App.setCurrentMenu(Menu.AvatarMenu);
        return new Result(true, "Now you are in Avatar Menu.");
    }

    public Result userLogout() {
        App.setLoggedInUser(null);
        App.setCurrentMenu(Menu.RegisterMenu);
        return new Result(true, "You logged out successfully.");
    }
    public void menuExit() {
        if (!App.getstayLoggedIn()){
            App.setLoggedInUser(null);
        }
        AppSaver.saveAppState(App.exportState(), "save.dat");
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
