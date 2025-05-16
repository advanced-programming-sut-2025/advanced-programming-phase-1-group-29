package org.example.views;

import org.example.controllers.MainMenuController;
import org.example.models.enums.MainMenuCommands;

import java.util.Scanner;

public class MainMenu implements AppMenu{
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        if (MainMenuCommands.ProfileMenuEnter.getMatcher(input) != null) {
            System.out.println(controller.profileMenuEnter());
        } else if (MainMenuCommands.ShowCurrentMenu.getMatcher(input) != null) {
            System.out.println(controller.showCurrentMenu());
        } else if (MainMenuCommands.GameMenuEnter.getMatcher(input) != null) {
            System.out.println(controller.gameMenuEnter());
        } else if (MainMenuCommands.AvatarMenuEnter.getMatcher(input) != null) {
            System.out.println(controller.avatarMenuEnter());
        } else if (MainMenuCommands.UserLogout.getMatcher(input) != null) {
            System.out.println(controller.userLogout());
        } else if (MainMenuCommands.MenuExit.getMatcher(input) != null) {
            controller.menuExit();
        } else {
            System.out.println("Invalid command");
        }
    }
}
