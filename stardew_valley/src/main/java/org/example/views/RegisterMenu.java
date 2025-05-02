package org.example.views;

import org.example.controllers.RegisterMenuController;
import org.example.models.enums.RegisterMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterMenu implements AppMenu{
    private final RegisterMenuController controller = new RegisterMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = RegisterMenuCommands.MenuEnter.getMatcher(input)) != null) {
            System.out.println(controller.menuEnter(matcher.group("menuName")));
        } else if (RegisterMenuCommands.ShowCurrentMenu.getMatcher(input) != null) {
            System.out.println(controller.showCurrentMenu());
        } else if ((matcher = RegisterMenuCommands.Register.getMatcher(input)) != null) {
            System.out.println(controller.register(
                    matcher.group("username"),
                    matcher.group("password"),
                    matcher.group("passwordConfirm"),
                    matcher.group("nickname"),
                    matcher.group("email"),
                    matcher.group("gender")
            ));
        } else if (RegisterMenuCommands.MenuExit.getMatcher(input) != null) {
            controller.menuExit();
        } else {
            System.out.println("Invalid command");
        }
    }
}
