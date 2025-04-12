package controller;

import models.Result;
import models.enums.Recipe;

import java.rmi.server.RemoteRef;

public class GameController {
    public Result exitGame(){}

    public Result forceTerminate(){}

    public Result nextTurn(){}

    public Result showCurrentTime(){}

    public Result showCurrentDate(){}

    public Result showCurrentDateAndTime(){}

    public Result showCurrentDayOfTheWeek(){}

    public Result showCurrentSeason(){}

    public Result greenhouseBuild(){}

    public Result showCurrentWeather(){}

    public Result weatherForecast(){}

    public Result walk(int x, int y){}

    public Result printMap(int x, int y, int size){}

    public Result helpReadingMap(){}

    public Result showCurrentEnergy(){}

    public Result inventoryShow(){}

    public  Result toolsEquip(String toolName){}

    public Result toolsShowCurrent(){}

    public Result toolsShowAvailable(){}

    public Result toolsUpgrade(String toolName){}

    public Result toolsUse(int direction){}

    public Result plant(String seed, String direction) {}

    public Result showPlant(String x, String y) {}

    public Result fertilize(String fertilizer, String direction) {}

    public Result howMuchWater() {}

    public Result build(String buildingName, String x, String y){}

    public Result adoptAnimal(String animal, String name){}

    public Result petAnimal(String name){}

    public Result showAnimals(){}

    public Result feedHay(String name){}

    public Result showProduces(){}

    public Result collectProduce(String name){}

    public Result sellAnimal(String name){}

    public Result fishing(String fishingPole){}

    public Result artisanUse(String name, String itemName){}

    public Result artisenGet(String name){}

    public Result showAllProducts(){}

    public Result showAvailableProducts(){}

    public Result purchase(String productName, String count){}

    public Result sell(String productName, String count){}

    public Result friendship(){}

    public Result talk(String username, String message){}

    public Result talkHistory(String username){}

    public Result gift(String username, String item, String amount){}

    public Result giftList(){}

    public Result giftRate(String giftNumber, String rate){}

    public Result askMarriage(String username, String ring){}

    public Result respond(String type, String username){}

    public Result startTrade(){}

    public Result meetNPC(String NPCName) {}

    public Result giftNPC(String NPCName, String item){}

    public Result friendshipNPCList() {}

    public Result questsLists() {}

    public Result questsFinish(String index){}
}
