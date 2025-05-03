package org.example.views;

import org.example.controllers.MainMenuController;
import org.example.models.enums.MainMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu implements AppMenu{
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = MainMenuCommands.MenuEnter.getMatcher(input)) != null) {
            System.out.println(controller.menuEnter(matcher.group("menuName")));
        } else if (MainMenuCommands.UserLogout.getMatcher(input) != null) {
            System.out.println(controller.userLogout());
        } else {
            System.out.println("Invalid command");
        }
    }
}
