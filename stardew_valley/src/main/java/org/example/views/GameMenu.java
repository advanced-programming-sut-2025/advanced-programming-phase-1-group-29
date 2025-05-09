package org.example.views;

import org.example.controllers.GameMenuController;
import org.example.models.Game;
import org.example.models.enums.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameMenuController controller = new GameMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if (GameMenuCommands.MenuEnter.getMatcher(input) != null) {
            System.out.println(controller.menuEnter());
        }
        /// /turns
//        else if(GameMenuCommands.LoadGame.getMatcher(input) != null) {
//            System.out.println(controller.loadGame());
//        }
        else if (GameMenuCommands.ExitGame.getMatcher(input) != null) {
            System.out.println(controller.exitGame());
        }
        else if(GameMenuCommands.NextTurn.getMatcher(input) != null) {
            controller.nextTurn();
        }
        else if (GameMenuCommands.Time.getMatcher(input) != null) {
            System.out.println(controller.time());
        } else if (GameMenuCommands.Date.getMatcher(input) != null) {
            System.out.println(controller.date());
        } else if (GameMenuCommands.DateTime.getMatcher(input) != null) {
            System.out.println(controller.dateTime());
        } else if (GameMenuCommands.DayOfTheWeek.getMatcher(input) != null) {
            System.out.println(controller.dayOfTheWeek());
        }
//        else if((matcher = GameMenuCommands.CheatAdvanceTime.getMatcher(input)) != null) {
//            System.out.println(controller.cheatAdvanceTime(matcher.group("x")));
//        }
//        else if((matcher = GameMenuCommands.CheatAdvanceDate.getMatcher(input)) != null) {
//            System.out.println(controller.cheatAdvanceDate(matcher.group("x")));
//        }
        else if (GameMenuCommands.Season.getMatcher(input) != null) {
            System.out.println(controller.season());
        }
//        else if((matcher = GameMenuCommands.CheatThor.getMatcher(input)) != null) {
//            System.out.println(controller.cheatThor(matcher.group("x"), matcher.group("y")));
//        }
        else if (GameMenuCommands.Weather.getMatcher(input) != null) {
            System.out.println(controller.weather());
        }
//        else if(GameMenuCommands.WeatherForecast.getMatcher(input) != null) {
//            System.out.println(controller.weatherForecast());
//        }
//        else if ((matcher = GameMenuCommands.CheatWeatherSet.getMatcher(input)) != null) {
//            System.out.println(controller.cheatWeatherSet(matcher.group("type")));
//        }
//        else if (GameMenuCommands.GreenHouseBuild.getMatcher(input) != null) {
//            System.out.println(controller.greenhouseBuild());
//        }
//        else if ((matcher = GameMenuCommands.Walk.getMatcher(input)) != null) {
//            System.out.println(controller.walk(matcher.group("x"), matcher.group("y")));
//        }
        else if ((matcher = GameMenuCommands.PrintMap.getMatcher(input)) != null) {
            System.out.println(controller.printMap(matcher.group("x"), matcher.group("y"), matcher.group("size")));
        }
//        else if (GameMenuCommands.HelpReadingMap.getMatcher(input) != null) {
//            System.out.println(controller.helpReadingMap());
//        }
        else if (GameMenuCommands.EnergyShow.getMatcher(input) != null) {
            System.out.println(controller.energyShow());
        }
        else if ((matcher = GameMenuCommands.EnergySet.getMatcher(input)) != null) {
            controller.energySet(matcher.group("value"));
        }
        else if (GameMenuCommands.EnergyUnlimited.getMatcher(input) != null) {
            controller.energyUnlimited();
        }
        else if (GameMenuCommands.InventoryShow.getMatcher(input) != null) {
            System.out.println(controller.inventoryShow());
        }
//        else if ((matcher = GameMenuCommands.InventoryTrash.getMatcher(input)) != null) {
//            System.out.println(controller.inventoryTrash(matcher.group("itemsName"), matcher.group("number")));
//        }
        else if ((matcher = GameMenuCommands.ToolsEquip.getMatcher(input)) != null) {
            System.out.println(controller.toolsEquip(matcher.group("toolName")));
        }
        else if (GameMenuCommands.ToolsShowCurrent.getMatcher(input) != null) {
            System.out.println(controller.toolsShowCurrent());
        }
        else if (GameMenuCommands.ToolsShowAvailable.getMatcher(input) != null) {
            System.out.println(controller.toolsShowAvailable());
        }
//        else if ((matcher = GameMenuCommands.ToolsUpgrade.getMatcher(input)) != null) {
//            System.out.println(controller.toolsUpgrade(matcher.group("toolName")));
//        }
//        else if ((matcher = GameMenuCommands.ToolsUse.getMatcher(input)) != null) {
//            System.out.println(controller.toolsUse(matcher.group("direction")));
//        }
    }
}
