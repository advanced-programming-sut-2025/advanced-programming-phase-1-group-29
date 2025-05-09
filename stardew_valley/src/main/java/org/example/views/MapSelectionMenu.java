package org.example.views;

import org.example.controllers.MapSelectionMenuController;
import org.example.models.enums.MainMenuCommands;
import org.example.models.enums.MapSelectionMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MapSelectionMenu implements AppMenu {
    private final MapSelectionMenuController controller = new MapSelectionMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = MapSelectionMenuCommands.GameMap.getMatcher(input)) != null) {
            System.out.println(controller.gameMap(matcher.group("mapNumber")));
        }
        else {
            System.out.println("Invalid command");
        }
    }
}
