package org.example.views;

import org.example.controllers.StoreMenuController;
import org.example.models.Game;
import org.example.models.enums.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class StoreMenu implements AppMenu {
    //TODO
    //all the game menu commands should also work here
    private final StoreMenuController controller = new StoreMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = GameMenuCommands.ShowAllProducts.getMatcher(input)) != null) {
            System.out.println(controller.showAllProducts());
        }
        else if ((matcher = GameMenuCommands.ShowAllAvailableProducts.getMatcher(input)) != null) {
            System.out.println(controller.showAllAvailableProducts());
        }
        else if ((matcher = GameMenuCommands.Purchase.getMatcher(input)) != null) {
            System.out.println(controller.purchase(matcher.group("productName").trim(), matcher.group("count").trim()));
        }
        else{
            System.out.println("invalid command");
        }
    }
}
