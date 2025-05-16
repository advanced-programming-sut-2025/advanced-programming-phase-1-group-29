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
        if (LoginMenuCommands.MenuEnter.getMatcher(input) != null) {
            System.out.println(controller.menuEnter());
        }
        else if (LoginMenuCommands.ShowCurrentMenu.getMatcher(input) != null) {
            System.out.println(controller.showCurrentMenu());
        }
        else if ((matcher = LoginMenuCommands.Login.getMatcher(input)) != null){
            System.out.println(controller.login(matcher.group("username").trim(), matcher.group("password").trim(), matcher.group("stayLoggedIn").trim()));
        }
        else if ((matcher = LoginMenuCommands.ForgetPassword.getMatcher(input)) != null){
            System.out.println(controller.forgetPassword(matcher.group("username").trim()));
        }
        else if ((matcher = LoginMenuCommands.Answer.getMatcher(input)) != null){
            Result result = controller.answer(matcher.group("answer").trim());
            System.out.println(result);
            if (result.isSuccessful()){
                input = scanner.nextLine().trim();
                Result result1 = controller.setPassword(input);
                while(!result1.isSuccessful()){
                    System.out.println(result1);
                    input = scanner.nextLine().trim();
                    result1 = controller.setPassword(input);
                }
                System.out.println(result1);
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
