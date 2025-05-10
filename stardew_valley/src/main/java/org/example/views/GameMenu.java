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
        else if((matcher = GameMenuCommands.CheatAdvanceTime.getMatcher(input)) != null) {
            System.out.println(controller.cheatAdvanceTime(matcher.group("x")));
        }
        else if((matcher = GameMenuCommands.CheatAdvanceDate.getMatcher(input)) != null) {
            System.out.println(controller.cheatAdvanceDate(matcher.group("x")));
        }
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
        else if (GameMenuCommands.HelpReadingMap.getMatcher(input) != null) {
            System.out.println(controller.helpReadingMap());
        }
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
//        else if ((matcher = GameMenuCommands.CollectProduce.getMatcher(input)) != null) {
//            System.out.println(controller.collectProduce(matcher.group("name")));
//        }
//        else if ((matcher = GameMenuCommands.SellAnimal.getMatcher(input)) != null) {
//            System.out.println(controller.sellAnimal(matcher.group("name")));
//        }
//        else if ((matcher = GameMenuCommands.Fishing.getMatcher(input)) != null) {
//            System.out.println(controller.fishing(matcher.group("fishingPole")));
//        }
//        else if ((matcher = GameMenuCommands.ArtisanUse.getMatcher(input)) != null) {
//            System.out.println(controller.ArtisanUse(matcher.group("artisanName"), matcher.group("item1Name")));
//        }
//        else if ((matcher = GameMenuCommands.ArtisanGet.getMatcher(input)) != null) {
//            System.out.println(controller.ArtisanGet(matcher.group("artisanName")));
//        }
//        else if (GameMenuCommands.ShowAllProducts.getMatcher(input) != null) {
//            System.out.println(controller.showAllProducts());
//        }
//        else if (GameMenuCommands.ShowAllAvailableProducts.getMatcher(input) != null) {
//            System.out.println(controller.showAllAvailableProducts());
//        }
//        else if ((matcher = GameMenuCommands.Purchase.getMatcher(input)) != null) {
//            System.out.println(controller.purchase(matcher.group("productName"), matcher.group("count")));
//        }
//        else if ((matcher = GameMenuCommands.CheatAddDollars.getMatcher(input)) != null) {
//            System.out.println(controller.cheatAddDollars(matcher.group("count")));
//        }
//        else if ((matcher = GameMenuCommands.Sell.getMatcher(input)) != null) {
//            System.out.println(controller.sell(matcher.group("productName"), matcher.group("count")));
//        }
//        else if (GameMenuCommands.Friendships.getMatcher(input) != null) {
//            System.out.println(controller.friendships());
//        }
//        else if ((matcher = GameMenuCommands.Talk.getMatcher(input)) != null) {
//            System.out.println(controller.talk(matcher.group("username"), matcher.group("message")));
//        }
//        else if ((matcher = GameMenuCommands.TalkHistory.getMatcher(input)) != null) {
//            System.out.println(controller.talkHistory(matcher.group("username")));
//        }
//        else if ((matcher = GameMenuCommands.Gift.getMatcher(input)) != null) {
//            System.out.println(controller.gift(
//            matcher.group("username"),
//            matcher.group("item"),
//            matcher.group("amount")));
//        }
//        else if (GameMenuCommands.GiftList.getMatcher(input) != null) {
//            System.out.println(controller.giftList());
//        }
//        else if ((matcher = GameMenuCommands.GiftRate.getMatcher(input)) != null) {
//            System.out.println(controller.giftRate(matcher.group("giftNumber"), matcher.group("rate")));
//        }
//        else if ((matcher = GameMenuCommands.GiftHistory.getMatcher(input)) != null) {
//            System.out.println(controller.giftHistory(matcher.group("username")));
//        }
//        else if ((matcher = GameMenuCommands.Hug.getMatcher(input)) != null) {
//            System.out.println(controller.hug(matcher.group("username")));
//        }
//        else if ((matcher = GameMenuCommands.Flower.getMatcher(input)) != null) {
//            System.out.println(controller.flower(matcher.group("username")));
//        }
//        else if ((matcher = GameMenuCommands.AskMarriage.getMatcher(input)) != null) {
//            System.out.println(controller.askMarriage(matcher.group("username"), matcher.group("ring")));
//        }
//        else if ((matcher = GameMenuCommands.Respond.getMatcher(input)) != null) {
//            System.out.println(controller.respond(matcher.group("result"), matcher.group("username")));
//        }
//        else if (GameMenuCommands.StartTrade.getMatcher(input) != null) {
//            System.out.println(controller.startTrade());
//        }
//        else if ((matcher = GameMenuCommands.Trade.getMatcher(input)) != null) {
//            System.out.println(controller.trade(
//            matcher.group("username"),
//            matcher.group("type"),
//            matcher.group("item"),
//            matcher.group("amount"),
//            matcher.group("price"),
//            matcher.group("targetItem"),
//            matcher.group("type"),
//            matcher.group("targetAmount")));
//        }
//        else if (GameMenuCommands.TradeList.getMatcher(input) != null) {
//            System.out.println(controller.tradeList());
//        }
//        else if ((matcher = GameMenuCommands.TradeResponse.getMatcher(input)) != null) {
//            System.out.println(controller.TradeResponse(matcher.group("result"), matcher.group("id")));
//        }
//        else if (GameMenuCommands.TradeHistory.getMatcher(input) != null) {
//            System.out.println(controller.tradeHistory());
//        }
//        else if ((matcher = GameMenuCommands.MeetNPC.getMatcher(input)) != null) {
//            System.out.println(controller.meetNPC(matcher.group("npcName")));
//        }
//        else if ((matcher = GameMenuCommands.GiftNPC.getMatcher(input)) != null) {
//            System.out.println(controller.giftNPC(matcher.group("npcName"), matcher.group("item")));
//        }
//        else if (GameMenuCommands.FriendshipNPCList.getMatcher(input) != null) {
//            System.out.println(controller.friendshipNPCList());
//        }
//        else if (GameMenuCommands.QuestsList.getMatcher(input) != null) {
//            System.out.println(controller.questsList());
//        }
//        else if ((matcher = GameMenuCommands.QuestsFinish.getMatcher(input)) != null) {
//            System.out.println(controller.questsFinish(matcher.group("index")));
//        }
    }
}
