package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;
import org.example.models.enums.RegisterMenuCommands;

import java.util.StringJoiner;

public class ProfileMenuController extends Controller{

    public Result menuEnter() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "Now you are in Main Menu.");
    }

    public Result changeUsername(String username) {
        if (RegisterMenuCommands.Username.getMatcher(username) == null)
            return new Result(false, "Invalid username format");
        if(App.getLoggedInUser().getUsername().equals(username)){
            return new Result(false, "The new username must be different from the current username.");
        }
        App.getLoggedInUser().setUsername(username);
        return new Result(true, "username has been changed.");
    }

    public Result changeNickname(String nickname) {
        App.getLoggedInUser().setNickname(nickname);
        return new Result(true, "nickname has been changed.");
    }

    public Result changeEmail(String email) {
        if (RegisterMenuCommands.Email.getMatcher(email) == null) {
            return new Result(false, "Invalid Email Format");
        }
        App.getLoggedInUser().setEmail(email);
        return new Result(true, "email has been changed.");
    }

    public Result changePassword(String oldPassword, String newPassword) {
        if(!App.getLoggedInUser().getPassword().equals(oldPassword)){
            return new Result(false, "Incorrect Password");
        }
        if(App.getLoggedInUser().getPassword().equals(newPassword)){
            return new Result(false, "The new password must be different from the current password.");
        }
        if (RegisterMenuCommands.Password.getMatcher(newPassword) == null) {
            return new Result(false, "Invalid password Format");
        }
        if (RegisterMenuCommands.StrongPassword.getMatcher(newPassword) == null || newPassword.length() < 8) {
            return new Result(false, "The password is too weak");
        }
        App.getLoggedInUser().setPassword(newPassword);
        return new Result(true, "password has been changed.");
    }

    public Result userInfo(){
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Username: " + App.getLoggedInUser().getUsername());
        joiner.add("Nickname: " + App.getLoggedInUser().getNickname());
        joiner.add("Best Score: " + App.getLoggedInUser().getMaxCoins());
        joiner.add("Games Played: " + App.getLoggedInUser().getNumberOfGames());
        return new Result(true, joiner.toString());
    }

    public void menuExit() {
        if (!App.getstayLoggedIn()){
            App.setLoggedInUser(null);
        }
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
