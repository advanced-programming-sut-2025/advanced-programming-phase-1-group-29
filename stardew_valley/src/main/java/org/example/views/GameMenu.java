package org.example.views;

import org.example.controllers.*;
import org.example.models.Result;
import org.example.models.enums.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameMenuController controller = new GameMenuController();
    private final StoreMenuController storeController = new StoreMenuController();
    private final NPCHouseMenuController npcController = new NPCHouseMenuController();
    private final TradeMenuController tradeController = new TradeMenuController();
    //TODO
    //remove all the spaces from the inputs
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        Result collapse = controller.isCollapsed(input);
        if (!collapse.isSuccessful()) {
            System.out.print(collapse);
        }
        else if (GameMenuCommands.MenuEnter.getMatcher(input) != null) {
            System.out.println(controller.menuEnter());
        }
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
            System.out.println(controller.cheatAdvanceTime(matcher.group("x").trim()));
        }
        else if((matcher = GameMenuCommands.CheatAdvanceDate.getMatcher(input)) != null) {
            System.out.println(controller.cheatAdvanceDate(matcher.group("x").trim()));
        }
        else if (GameMenuCommands.Season.getMatcher(input) != null) {
            System.out.println(controller.season());
        }
        else if((matcher = GameMenuCommands.CheatThor.getMatcher(input)) != null) {
            System.out.println(controller.cheatThor(matcher.group("x").trim(), matcher.group("y").trim()));
        }
        else if (GameMenuCommands.Weather.getMatcher(input) != null) {
            System.out.println(controller.weather());
        }
        else if(GameMenuCommands.WeatherForecast.getMatcher(input) != null) {
            System.out.println(controller.weatherForecast());
        }
        else if ((matcher = GameMenuCommands.CheatWeatherSet.getMatcher(input)) != null) {
            System.out.println(controller.cheatWeatherSet(matcher.group("type").trim()));
        }
//        else if (GameMenuCommands.GreenHouseBuild.getMatcher(input) != null) {
//            System.out.println(controller.greenhouseBuild());
//        }
        else if ((matcher = GameMenuCommands.Walk.getMatcher(input)) != null) {
            System.out.println(controller.walk(matcher.group("x").trim(), matcher.group("y").trim()));
        }
        else if ((matcher = GameMenuCommands.PrintMap.getMatcher(input)) != null) {
            controller.printMap(
                    matcher.group("x").trim(),
                    matcher.group("y").trim(),
                    matcher.group("size").trim());
        }
        else if (GameMenuCommands.HelpReadingMap.getMatcher(input) != null) {
            System.out.println(controller.helpReadingMap());
        }
        else if (GameMenuCommands.EnergyShow.getMatcher(input) != null) {
            System.out.println(controller.energyShow());
        }
        else if ((matcher = GameMenuCommands.EnergySet.getMatcher(input)) != null) {
            controller.energySet(matcher.group("value").trim());
        }
        else if (GameMenuCommands.EnergyUnlimited.getMatcher(input) != null) {
            controller.energyUnlimited();
        }
        else if (GameMenuCommands.InventoryShow.getMatcher(input) != null) {
            System.out.println(controller.inventoryShow());
        }
        else if ((matcher = GameMenuCommands.InventoryTrash.getMatcher(input)) != null) {
            System.out.println(controller.inventoryTrash(
                    matcher.group("itemsName").trim(),
                    matcher.group("number").trim()));
        }
        else if ((matcher = GameMenuCommands.ToolsEquip.getMatcher(input)) != null) {
            System.out.println(controller.toolsEquip(matcher.group("toolName").trim()));
        }
        else if (GameMenuCommands.ToolsShowCurrent.getMatcher(input) != null) {
            System.out.println(controller.toolsShowCurrent());
        }
        else if (GameMenuCommands.ToolsShowAvailable.getMatcher(input) != null) {
            System.out.println(controller.toolsShowAvailable());
        }
        else if ((matcher = GameMenuCommands.ToolsUpgrade.getMatcher(input)) != null) {
            System.out.println(controller.toolsUpgrade(matcher.group("toolName").trim()));
        }
        else if ((matcher = GameMenuCommands.ToolsUse.getMatcher(input)) != null) {
            System.out.println(controller.toolsUse(matcher.group("direction").trim()));
        }
        else if ((matcher = GameMenuCommands.CraftInfo.getMatcher(input)) != null) {
            System.out.println(controller.craftInfo(matcher.group("craftName").trim()));
        }
        else if ((matcher = GameMenuCommands.Plant.getMatcher(input)) != null) {
            System.out.println(controller.plant(
                    matcher.group("seed").trim(),
                    matcher.group("direction").trim()));
        }
        else if ((matcher = GameMenuCommands.ShowPlant.getMatcher(input)) != null) {
            System.out.println(controller.showPlant(
                    matcher.group("x").trim(),
                    matcher.group("y").trim()));
        }
        else if ((matcher = GameMenuCommands.Fertilize.getMatcher(input)) != null) {
            System.out.println(controller.fertilize(
                    matcher.group("fertilizer").trim(),
                    matcher.group("direction").trim()));
        }
        else if (GameMenuCommands.HowMuchWater.getMatcher(input) != null) {
            System.out.println(controller.howMuchWater());
        }
        else if (GameMenuCommands.CraftingShowRecipes.getMatcher(input) != null) {
            System.out.println(controller.craftingShowRecipes());
        }
        else if ((matcher = GameMenuCommands.CraftingCraft.getMatcher(input)) != null) {
            System.out.println(controller.craftingCraft(matcher.group("itemName").trim()));
        }
        else if ((matcher = GameMenuCommands.PlaceItem.getMatcher(input)) != null) {
            System.out.println(controller.placeItem(
                    matcher.group("itemName").trim(),
                    matcher.group("direction").trim()));
        }
        else if ((matcher = GameMenuCommands.CheatAddItem.getMatcher(input)) != null) {
            System.out.println(controller.cheatAddItem(
                    matcher.group("itemName").trim(),
                    matcher.group("count").trim()));
        }
        else if ((matcher = GameMenuCommands.CookingRefrigerator.getMatcher(input)) != null) {
            System.out.println(controller.cookingRefrigerator(
                    matcher.group("action").trim(),
                    matcher.group("item").trim()));
        }
        else if (GameMenuCommands.CookingShowRecipes.getMatcher(input) != null) {
            System.out.println(controller.cookingShowRecipes());
        }
        else if ((matcher = GameMenuCommands.CookingPrepare.getMatcher(input)) != null) {
            System.out.println(controller.cookingPrepare(matcher.group("recipeName").trim()));
        }
        else if ((matcher = GameMenuCommands.Eat.getMatcher(input)) != null) {
            System.out.println(controller.eat(matcher.group("foodName").trim()));
        }
//        else if ((matcher = GameMenuCommands.Build.getMatcher(input)) != null) {
//            System.out.println(controller.build(
//            matcher.group("buildingName").trim(),
//            matcher.group("x").trim(),
//            matcher.group("y").trim()));
//        }
//        else if ((matcher = GameMenuCommands.BuyAnimal.getMatcher(input)) != null) {
//            System.out.println(controller.buyAnimal(matcher.group("animal").trim(), matcher.group("name").trim()));
//        }
        else if ((matcher = GameMenuCommands.Pet.getMatcher(input)) != null) {
            System.out.println(controller.pet(matcher.group("name").trim()));
        }
        else if ((matcher = GameMenuCommands.CheatSetFriendship.getMatcher(input)) != null) {
            System.out.println(controller.cheatSetFriendship(
                    matcher.group("animalName").trim(),
                    matcher.group("amount").trim()));
        }
        else if (GameMenuCommands.Animals.getMatcher(input) != null) {
            System.out.println(controller.animals());
        }
        else if ((matcher = GameMenuCommands.ShepherdAnimals.getMatcher(input)) != null) {
            System.out.println(controller.shepherdAnimals(
            matcher.group("animalName").trim(),
            matcher.group("x").trim(),
            matcher.group("y").trim()));
        }
        else if ((matcher = GameMenuCommands.FeedHay.getMatcher(input)) != null) {
            System.out.println(controller.feedHay(matcher.group("animalName").trim()));
        }
        else if (GameMenuCommands.Produces.getMatcher(input) != null) {
            System.out.println(controller.produces());
        }
        else if ((matcher = GameMenuCommands.CollectProduce.getMatcher(input)) != null) {
            System.out.println(controller.collectProduce(matcher.group("name").trim()));
        }
        else if ((matcher = GameMenuCommands.SellAnimal.getMatcher(input)) != null) {
            System.out.println(controller.sellAnimal(matcher.group("name").trim()));
        }
        else if ((matcher = GameMenuCommands.Fishing.getMatcher(input)) != null) {
            System.out.println(controller.fishing(matcher.group("fishingPole").trim()));
        }
//        else if ((matcher = GameMenuCommands.ArtisanUse.getMatcher(input)) != null) {
//            System.out.println(controller.artisanUse(
//                    matcher.group("artisanName").trim(),
//                    matcher.group("item1Name").trim()));
//        }
//        else if ((matcher = GameMenuCommands.ArtisanGet.getMatcher(input)) != null) {
//            System.out.println(controller.artisanGet(matcher.group("artisanName").trim()));
//        }
        else if (GameMenuCommands.ShowAllProducts.getMatcher(input) != null) {
            System.out.println(storeController.showAllProducts());
        }
        else if (GameMenuCommands.ShowAllAvailableProducts.getMatcher(input) != null) {
            System.out.println(storeController.showAllAvailableProducts());
        }
        else if ((matcher = GameMenuCommands.Purchase.getMatcher(input)) != null) {
            System.out.println(storeController.purchase(
                    matcher.group("productName").trim(),
                    matcher.group("count").trim()));
        }
        else if ((matcher = GameMenuCommands.CheatAddDollars.getMatcher(input)) != null) {
            System.out.println(controller.cheatAddDollars(matcher.group("count").trim()));
        }
//        else if ((matcher = GameMenuCommands.Sell.getMatcher(input)) != null) {
//            System.out.println(controller.sell(matcher.group("productName").trim(), matcher.group("count").trim()));
//        }
        else if (GameMenuCommands.Friendships.getMatcher(input) != null) {
            System.out.println(controller.friendships());
        }
        else if ((matcher = GameMenuCommands.Talk.getMatcher(input)) != null) {
            System.out.println(controller.talk(matcher.group("username").trim(), matcher.group("message").trim()));
        }
        else if ((matcher = GameMenuCommands.TalkHistory.getMatcher(input)) != null) {
            System.out.println(controller.talkHistory(matcher.group("username").trim()));
        }
        else if ((matcher = GameMenuCommands.Gift.getMatcher(input)) != null) {
            System.out.println(controller.gift(
            matcher.group("username").trim(),
            matcher.group("item").trim(),
            matcher.group("amount").trim()));
        }
        else if (GameMenuCommands.GiftList.getMatcher(input) != null) {
            System.out.println(controller.giftList());
        }
        else if ((matcher = GameMenuCommands.GiftRate.getMatcher(input)) != null) {
            System.out.println(controller.rateGift(matcher.group("giftNumber").trim(), matcher.group("rate").trim()));
        }
        else if ((matcher = GameMenuCommands.GiftHistory.getMatcher(input)) != null) {
            System.out.println(controller.giftHistory(matcher.group("username").trim()));
        }
        else if ((matcher = GameMenuCommands.Hug.getMatcher(input)) != null) {
            System.out.println(controller.hug(matcher.group("username").trim()));
        }
        else if ((matcher = GameMenuCommands.Flower.getMatcher(input)) != null) {
            System.out.println(controller.flower(matcher.group("username").trim()));
        }
        else if ((matcher = GameMenuCommands.AskMarriage.getMatcher(input)) != null) {
            System.out.println(controller.askMarriage(
                    matcher.group("username").trim(),
                    matcher.group("ring").trim()));
        }
        else if ((matcher = GameMenuCommands.Respond.getMatcher(input)) != null) {
            System.out.println(controller.respond(matcher.group("result").trim(), matcher.group("username").trim()));
        }
        else if (GameMenuCommands.StartTrade.getMatcher(input) != null) {
            System.out.println(tradeController.startTrade());
        }
        else if ((matcher = GameMenuCommands.Trade.getMatcher(input)) != null) {
            System.out.println(tradeController.trade(
            matcher.group("username").trim(),
            matcher.group("type").trim(),
            matcher.group("item").trim(),
            matcher.group("amount").trim(),
            matcher.group("price").trim(),
            matcher.group("targetItem").trim(),
            matcher.group("targetAmount").trim()));
        }
        else if (GameMenuCommands.TradeList.getMatcher(input) != null) {
            System.out.println(tradeController.tradeList());
        }
        else if ((matcher = GameMenuCommands.TradeResponse.getMatcher(input)) != null) {
            System.out.println(tradeController.respondToTrade(matcher.group("result").trim(), matcher.group("id").trim()));
        }
        else if (GameMenuCommands.TradeHistory.getMatcher(input) != null) {
            System.out.println(tradeController.tradeHistory());
        }
        else if ((matcher = GameMenuCommands.MeetNPC.getMatcher(input)) != null) {
            System.out.println(npcController.meetNPC(matcher.group("npcName").trim()));
        }
        else if ((matcher = GameMenuCommands.GiftNPC.getMatcher(input)) != null) {
            System.out.println(controller.giftNPC(matcher.group("npcName").trim(), matcher.group("item").trim()));
        }
        else if (GameMenuCommands.FriendshipNPCList.getMatcher(input) != null) {
            System.out.println(controller.friendshipNPCList());
        }
        else if (GameMenuCommands.QuestsList.getMatcher(input) != null) {
            System.out.println(npcController.questsList());
        }
        else if ((matcher = GameMenuCommands.QuestsFinish.getMatcher(input)) != null) {
            System.out.println(npcController.questFinish(matcher.group("index").trim()));
        }
    }
}
