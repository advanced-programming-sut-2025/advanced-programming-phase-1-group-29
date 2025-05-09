package org.example.views;

import org.example.controllers.GameMenuController;
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
        }
        else if (GameMenuCommands.Date.getMatcher(input) != null) {
            System.out.println(controller.date());
        }
        else if (GameMenuCommands.DateTime.getMatcher(input) != null) {
            System.out.println(controller.dateTime());
        }
        else if (GameMenuCommands.DayOfTheWeek.getMatcher(input) != null) {
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
            System.out.println(controller.printMap(
                    matcher.group("x"),
                    matcher.group("y"),
                    matcher.group("size")));
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
//        else if ((matcher = GameMenuCommands.CraftInfo.getMatcher(input)) != null) {
//            System.out.println(controller.craftInfo(matcher.group("craftName")));
//        }
//        else if ((matcher = GameMenuCommands.Plant.getMatcher(input)) != null) {
//            System.out.println(controller.plant(matcher.group("seed"), matcher.group("direction")));
//        }
//        else if ((matcher = GameMenuCommands.ShowPlant.getMatcher(input)) != null) {
//            System.out.println(controller.showPlant(matcher.group("x"), matcher.group("y")));
//        }
//        else if ((matcher = GameMenuCommands.Fertilize.getMatcher(input)) != null) {
//            System.out.println(controller.fertilize(matcher.group("fertilizer"), matcher.group("direction")));
//        }
//        else if (GameMenuCommands.HowMuchWater.getMatcher(input) != null) {
//            System.out.println(controller.howMuchWater());
//        }
//        else if (GameMenuCommands.CraftingShowRecipes.getMatcher(input) != null) {
//            System.out.println(controller.craftingShowRecipes());
//        }
//        else if ((matcher = GameMenuCommands.CraftingCraft.getMatcher(input)) != null) {
//            System.out.println(controller.craftingCraft(matcher.group("itemName")));
//        }
//        else if ((matcher = GameMenuCommands.PlaceItem.getMatcher(input)) != null) {
//            System.out.println(controller.placeItem(matcher.group("itemName"), matcher.group("direction")));
//        }
//        else if ((matcher = GameMenuCommands.CheatAddItem.getMatcher(input)) != null) {
//            System.out.println(controller.cheatAddItem(matcher.group("itemName"), matcher.group("count")));
//        }
//        else if ((matcher = GameMenuCommands.CookingRefrigerator.getMatcher(input)) != null) {
//            System.out.println(controller.cookingRefrigerator(matcher.group("action"), matcher.group("item")));
//        }
//        else if (GameMenuCommands.CookingShowRecipes.getMatcher(input) != null) {
//            System.out.println(controller.cookingShowRecipes());
//        }
//        else if ((matcher = GameMenuCommands.CookingPrepare.getMatcher(input)) != null) {
//            System.out.println(controller.cookingPrepare(matcher.group("recipeName")));
//        }
//        else if ((matcher = GameMenuCommands.Eat.getMatcher(input)) != null) {
//            System.out.println(controller.eat(matcher.group("foodName")));
//        }
//        else if ((matcher = GameMenuCommands.Build.getMatcher(input)) != null) {
//            System.out.println(controller.build(
//            matcher.group("buildingName"),
//            matcher.group("x"),
//            matcher.group("y")));
//        }
//        else if ((matcher = GameMenuCommands.BuyAnimal.getMatcher(input)) != null) {
//            System.out.println(controller.buyAnimal(matcher.group("animal"), matcher.group("name")));
//        }
//        else if ((matcher = GameMenuCommands.Pet.getMatcher(input)) != null) {
//            System.out.println(controller.pet(matcher.group("name")));
//        }
//        else if ((matcher = GameMenuCommands.CheatSetFriendship.getMatcher(input)) != null) {
//            System.out.println(controller.cheatSetFriendship(
//                    matcher.group("animalName"),
//                    matcher.group("amount")));
//        }
//        else if (GameMenuCommands.Animals.getMatcher(input) != null) {
//            System.out.println(controller.animals());
//        }
//        else if ((matcher = GameMenuCommands.ShepherdAnimals.getMatcher(input)) != null) {
//            System.out.println(controller.ShepherdAnimals(
//            matcher.group("animalName"),
//            matcher.group("x"),
//            matcher.group("y")));
//        }
//        else if ((matcher = GameMenuCommands.FeedHay.getMatcher(input)) != null) {
//            System.out.println(controller.feedHay(matcher.group("animalName")));
//        }
//        else if (GameMenuCommands.Produces.getMatcher(input) != null) {
//            System.out.println(controller.produces());
//        }
    }
}
