package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Gender;
import org.example.models.enums.Menu;
import org.example.models.enums.RegisterMenuCommands;

public class RegisterMenuController extends Controller{
    public Result menuEnter(String menuName) {
        if (!menuName.equals("Login Menu")) return new Result(false, "Invalid menu");
        App.setCurrentMenu(Menu.LoginMenu);
        return new Result(true, "Now you are in Login Menu.");
    }

    public Result register(
            String username, String password, String passwordConfirm, String nickname, String email, String gender
    ) {
        if (RegisterMenuCommands.Username.getMatcher(username) == null)
            return new Result(false, "Invalid username format");
        if (App.findUserByUsername(username) != null) {
            // suggest another username
            return new Result(false, "The username is already taken.");
        }
        if (RegisterMenuCommands.Email.getMatcher(email) == null)
            return new Result(false, "Invalid Email Format");
        if (RegisterMenuCommands.Password.getMatcher(password) == null)
            return new Result(false, "Invalid Email Format");
        if (RegisterMenuCommands.StrongPassword.getMatcher(password) == null || password.length() < 8)
            return new Result(false, "The password is too weak");
        if (!password.equals(passwordConfirm))
            return new Result(false, "");
        User user = new User(username, password, email, nickname, Gender.getGender(gender));
        App.addUser(user);
        return new Result(true, "");
    }

    public void menuExit() {
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
