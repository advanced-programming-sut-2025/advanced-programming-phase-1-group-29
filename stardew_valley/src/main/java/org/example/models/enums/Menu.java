package org.example.models.enums;

import org.example.views.*;

import java.util.Scanner;

public enum Menu {
    RegisterMenu("Register Menu", new RegisterMenu()),
    LoginMenu("Login Menu", new LoginMenu()),
    MainMenu("Main Menu", new MainMenu()),
    ProfileMenu("Profile Menu", new ProfileMenu()),
    PreGameMenu("Game Menu", new PreGameMenu()),
    GameMenu("Game Menu", new GameMenu()),
    MapSelectionMenu("Map Selection Menu", new MapSelectionMenu()),
    AvatarMenu("Avatar Menu", new AvatarMenu()),
    ExitMenu("Exit Menu", new ExitMenu());


    private final AppMenu menu;
    private final String name;

    Menu(String name, AppMenu menu) {
        this.name = name;
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }

    @Override
    public String toString() {
        return name;
    }
}
