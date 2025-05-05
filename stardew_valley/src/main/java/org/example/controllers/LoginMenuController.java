package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Menu;
import org.example.models.enums.RegisterMenuCommands;
import org.example.models.enums.RegisterState;

public class LoginMenuController extends Controller{
    private static User forgetPasswordUser = null;

    public Result menuEnter() {
        App.setCurrentMenu(Menu.RegisterMenu);
        return new Result(true, "Now you are in Register Menu.");
    }

    public Result login(String username, String password, String stayLoggedIn){
        User user = App.findUserByUsername(username);
        if (user == null){
            return new Result(false, "User not found");
        }
        if (!user.getPassword().equals(password)){
            return new Result(false, "Wrong password");
        }
        App.setLoggedInUser(user);
        if (stayLoggedIn != null) App.setStayLoggedIn(true);
        else App.setStayLoggedIn(false);
        return new Result(true, "Login successful");
    }
    public Result forgetPassword(String username){
        forgetPasswordUser = App.findUserByUsername(username);
        if (forgetPasswordUser == null){
            return new Result(false, "User not found");
        }
        return new Result(true, forgetPasswordUser.getSecurityQuestion());
    }
    public Result answer(String answer){
        if (answer.equals(forgetPasswordUser.getAnswerToSecurityQuestion())){
            return new Result(true, "enter new password");
        }
        return new Result(false, "Wrong answer");
    }
    public Result setPassword(String password){
        if (RegisterMenuCommands.Password.getMatcher(password) == null){
            return new Result(false, "Wrong password format; try again");
        }
        forgetPasswordUser.setPassword(password);
        return new Result(true, "Password changed successfully");
    }
    public void menuExit(){
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
