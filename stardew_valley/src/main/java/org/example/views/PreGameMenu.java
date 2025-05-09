package org.example.views;

import org.example.controllers.PreGameMenuController;
import org.example.models.enums.GameMenuCommands;
import org.example.models.enums.PreGameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class PreGameMenu implements AppMenu{
    private final PreGameMenuController controller = new PreGameMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if (PreGameMenuCommands.MenuEnter.getMatcher(input) != null) {
            System.out.println(controller.menuEnter());
        } else if (PreGameMenuCommands.ShowCurrentMenu.getMatcher(input) != null) {
            System.out.println(controller.showCurrentMenu());
        } else if ((matcher = PreGameMenuCommands.GameNew.getMatcher(input)) != null) {
            System.out.println(controller.gameNew(
                    matcher.group("username1"),
                    matcher.group("username2"),
                    matcher.group("username3")
            ));
        } else {
            System.out.println("Invalid command");
        }
    }
}
