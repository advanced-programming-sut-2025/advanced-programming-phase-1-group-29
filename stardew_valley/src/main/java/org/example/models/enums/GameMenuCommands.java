package org.example.models.enums;

import java.util.regex.Matcher;

public enum GameMenuCommands implements Command {
    MenuEnter("\\s*menu\\s+enter\\s+Main\\s+Menu\\s*"),
    GameNew("\\s*game\\s+new\\s+-u\\s+(?<username1>\\S+)\\s*(?<username2>\\S*)\\s*(?<username3>\\S*)\\s*"),
    LoadGame("\\s*load\\s+game\\s*"),
    ExitGame("\\s*exit\\s+game\\s*"),
    ForceTerminate("\\s*force\\s+terminate\\s*"),
    NextTurn("\\s*next\\s+turn\\s*"),
    Time("\\s*time\\s*"),
    Date("\\s*date\\s*"),
    DateTime("\\s*datetime\\s*"),
    DayOfTheWeek("\\s*day\\s+of\\s+the\\s+week\\s*"),
    CheatAdvanceTime("\\s*cheat\\s+advance\\s+time\\s+(?<x>\\d+)h\\s*"),
    CheatAdvanceDate("\\s*cheat\\s+advance\\s+date\\s+(?<x>\\d+)d\\s*"),
    Season("\\s*season\\s*"),
    CheatThor("\\s*cheat\\s+Thor\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    Weather("\\s*weather\\s*"),
    WeatherForecast("\\s*weather\\s+forecast\\s*"),
    CheatWeatherSet("\\s*cheat\\s+weather\\s+set\\s+(?<type>.+)\\s*"),
    GreenHouseBuild("\\s*greenhouse\\s+build\\s*"),
    Walk("\\s*walk\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    PrintMap("\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*"),
    HelpReadingMap("\\s*help\\s+reading\\s+map\\s*"),
    EnergyShow("\\s*energy\\s+show\\s*"),

    EnergySet("\\s*energy\\s+set\\s+-v\\s+(?<value>\\d+)\\s*"),
    EnergyUnlimited("\\s*energy\\s+unlimited\\s*"),
    InventoryShow("\\s*inventory\\s+show\\s*"),
    InventoryTrash("\\s*inventory\\s+trash\\s+-i\\s+(?<itemsName>.+)\\s+-n\\s+(?<number>\\d+)\\s*"),
    ToolsEquip("\\s*tools\\s+equip\\s+(?<toolName>.+)\\s*"),
    ToolsShowCurrent("\\s*tools\\s+show\\s+current\\s*"),
    ToolsShowAvailable("\\s*tools\\s+show\\s+available\\s*"),
    ToolsUpgrade("\\s*tools\\s+upgrade\\s+(?<toolName>.+)\\s*"),
    ToolsUse("\\s*tools\\s+use\\s+-d\\s+(?<direction>.+)\\s*"),
    CraftInfo("\\s*craftinfo\\s+-n\\s+(?<craftName>.+)\\s*"),
    Plant("\\s*plant\\s+-s\\s+(?<seed>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    ShowPlant("\\s*showplant\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    Fertilize("\\s*fertilize\\s+-f\\s+(?<fertilizer>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    HowMuchWater("\\s*howmuch\\s+water\\s*"),
    CraftingShowRecipes("\\s*crafting\\s+show\\s+recipes\\s*"),
    CraftingCraft("\\s*crafting\\s+craft\\s+(?<itemName>.+)\\s*"),
    PlaceItem("\\s*place\\s+item\\s+-n\\s+(?<itemName>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    CheatAddItem("\\s*cheat\\s+add\\s+item\\s+-n\\s+(?<itemName>.+)\\s+-c\\s+(?<count>\\d+)\\s*"),
    CookingRefrigerator("\\s*cooking\\s+refrigerator\\s+(?<action>put|pick)\\s+(?<item>.+)\\s*"),
    CookingShowRecipes("\\s*cooking\\s+show\\s+recipes\\s*"),
    CookingPrepare("\\s*cooking\\s+prepare\\s+(?<recipeName>.+)\\s*"),
    Eat("\\s*eat\\s+(?<foodName>.+)\\s*"),
    Build("\\s*build\\s+-a\\s+(?<buildingName>.+)-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    BuyAnimal("\\s*buy\\s+animal\\s+-a\\s+(?<animal>.+)\\s+-n\\s+(?<name>.+)\\s*"),
    Pet("\\s*pet\\s+-n\\s+(?<name>.+)\\s*"),
    CheatSetFriendship("\\s*cheat\\s+set\\s+friendship\\s+-n\\s+(?<animalName>.+)\\s+-c\\s+(?<amount>\\d+)\\s*"),
    Animals("\\s*animals\\s*"),
    ShepherdAnimals("\\s*shepherd\\s+animals\\s+-n\\s+(?<animalName>.+)-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    FeedHay("\\s*feed\\s+hay\\s+-n\\s+(?<animalName>.+)\\s*"),
    Produces("\\s*produces\\s*"),
    CollectProduce("\\s*collect\\s+produce\\s+-n\\s+(?<name>.+)\\s*"),
    SellAnimal("\\s*sell\\s+animal\\s+-n\\s+(?<name>.+)\\s*"),
    Fishing("\\s*fishing\\s+-p\\s+(?<fishingPole>.+)\\s*"),
    ArtisanUse("\\s*artisan\\s+use\\s+(?<artisanName>.+)\\s+(?<item1Name>.+)\\s*"),
    ArtisanGet("\\s*artisan\\s+get\\s+(?<artisanName>.+)\\s*"),
    ShowAllProducts("\\s*show\\s+all\\s+products\\s*"),
    ShowAllAvailableProducts("\\s*show\\s+all\\s+available\\s+products\\s*"),
    Purchase("\\s*purchase\\s+(?<productName>.+)\\s+-n\\s+(?<count>\\d+)\\s*"),
    CheatAdd("\\s*cheat\\s+add\\s+(?<count>\\d+)\\s+dollars\\s*"),
    Sell("\\s*sell\\s+(?<productName>.+)\\s+-n\\s+(?<count>\\d+)\\s*"),
    Friendships("\\s*friendships\\s*"),
    Talk("\\s*talk\\s+-u\\s+(?<username>.+)\\s+-m\\s+(?<message>.+)\\s*"),
    TalkHistory("\\s*talk\\s+history\\s+-u\\s+(?<username>.+)\\s*"),
    Gift("\\s*gift\\s+-u\\s+(?<username>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>\\d+)\\s*"),
    GiftList("\\s*gift\\s+list\\s*"),
    GiftRate("\\s*gift\\s+rate\\s+-i\\s+(?<giftNumber>\\d+)\\s+-r\\s+(?<rate>\\d+)\\s*"),
    GiftHistory("\\s*gift\\s+history\\s+-u\\s+(?<username>.+)\\s*"),
    Hug("\\s*hug\\s+-u\\s+(?<username>.+)\\s*"),
    Flower("\\s*flower\\s+-u\\s+(?<username>.+)\\s*"),
    AskMarriage("\\s*ask\\s+marriage\\s+-u\\s+(?<username>.+)\\s+-r\\s+(?<ring>.+)\\s*"),
    Respond("\\s*respond\\s+(?<result>–accept|–reject)\\s+-u\\s+(?<username>.+)\\s*"),
    StartTrade("\\s*start\\s+trade\\s*"),
    Trade("\\s*trade\\s+-u\\s+(?<username>.+)\\s+-t\\s+(?<type>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>\\d+)\\s+(-p\\s+(?<price>\\d+))?(-ti\\s+(?<targetItem>.+)\\s+-ta\\s+(?<targetAmount>\\d+))?\\s*"),
    TradeList("\\s*trade\\s+list\\s*"),
    TradeResponse("\\s*trade\\s+response\\s+(?<result>–accept|–reject)\\s+-i\\s+(?<id>\\d+)\\s*"),
    TradeHistory("\\s*trade\\s+history\\s*"),
    MeetNPC("\\s*meet\\s+NPC\\s+(?<npcName>.+)\\s*"),
    GiftNPC("\\s*gift\\s+NPC\\s+(?<npcName>.+)\\s+-i\\s+(?<item>.+)\\s*"),
    FriendshipNPCList("\\s*friendship\\s+NPC\\s+list\\s*"),
    QuestsList("\\s*quests\\s+list\\s*"),
    QuestsFinish("\\s*quests\\s+finish\\s+-i\\s+(?<index>\\d+)\\s*"),

    // Marg bar regex

    ;


    private final String pattern;
    GameMenuCommands(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public String getPattern() {
        return pattern;
    }

}
