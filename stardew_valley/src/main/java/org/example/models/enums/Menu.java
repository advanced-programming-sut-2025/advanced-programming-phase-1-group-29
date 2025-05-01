package org.example.models.enums;

import org.example.views.*;

import java.util.Scanner;

public enum Menu {
    RegisterMenu(new RegisterMenu()),
    LoginMenu(new LoginMenu()),
    MainMenu(new MainMenu()),
    ProfileMenu(new ProfileMenu()),
    GameMenu(new GameMenu()),
    AvatarMenu(new AvatarMenu()),
    ExitMenu(new ExitMenu());


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }
}
