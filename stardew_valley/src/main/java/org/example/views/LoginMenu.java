package org.example.views;

import org.example.controllers.LoginMenuController;
import org.example.models.Result;
import org.example.models.enums.LoginMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu implements AppMenu{
    private final LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = LoginMenuCommands.Login.getMatcher(input)) != null){
            System.out.println(controller.login(matcher.group("username"), matcher.group("password"), matcher.group("stayLoggedIn")));
        }
        else if ((matcher = LoginMenuCommands.ForgetPassword.getMatcher(input)) != null){
            System.out.println(controller.forgetPassword(matcher.group("username")));
        }
        else if ((matcher = LoginMenuCommands.Answer.getMatcher(input)) != null){
            Result result = controller.answer(matcher.group("answer"));
            System.out.println(result);
            if (result.isSuccessful()){
                input = scanner.nextLine();
                System.out.println(controller.setPassword(input));
            }
        }
        else if ((matcher = LoginMenuCommands.MenuExit.getMatcher(input)) != null){
            controller.menuExit();
        }
        else{
            System.out.println("Invalid command");
        }
    }
}
