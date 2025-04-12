package models.enums;

import views.*;

import java.util.Scanner;

public enum Menu {
    RegisterLoginMenu(new RegisterLoginMenu()),
    MainMenu(new MainMenu()),
    ProfileMenu(new ProfileMenu()),
    InventoryMenu(new InventoryMenu()),
    GameMenu(new GameMenu()),
    AvatarMenu(new AvatarMenu()),
    TradeMenu(new TradeMenu()),
    Exitmenu(new ExitMenu());

    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }


}
