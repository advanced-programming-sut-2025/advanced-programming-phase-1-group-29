package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class AbigailsHouse extends NPCHouse{
    @Override
    public Result questFinish(int ind) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (ind == 1 && !super.quest1){
            if (player.getInventory().getNumberOfInventoryItem("goldBar") < 1){
                return new Result(false, "You don't have enough gold bars in your inventory.");
            }
            else {
                super.quest1 = true;
                player.addAbigailFriendship(200);
                return new Result(true, "quest completed. you received 1 friendship level.");
            }
        }
        else if (ind == 2 && !super.quest2 && App.getCurrentGame().getCurrentPlayer().getAbigailFriendship() >= 200){
            if (player.getInventory().getNumberOfInventoryItem("pumpkin") < 1){
                return new Result(false, "You don't have enough pumpkin in your inventory.");
            }
            else {
                super.quest2 = true;
                player.addCoins(500);
                return new Result(true, "quest completed. you received 500 coins.");
            }
        }
        else if (ind == 3 && !super.quest3 && (App.getCurrentGame().getCurrentTime().getYear() > 0 || (App.getCurrentGame().getCurrentTime().getSeason() != Season.Spring && App.getCurrentGame().getCurrentTime().getSeason() != Season.Summer))){
            if (player.getInventory().getNumberOfInventoryItem("wheat") < 50){
                return new Result(false, "You don't have wheat in your inventory.");
            }
            else{
                super.quest3 = true;
                player.getInventory().addInventoryItem("quartz", 50, 0);
                return new Result(true, "quest completed. you received 50 quartz.");
                //TODO
            }
        }
        else return new Result(false, "invalid index");
    }
    @Override
    public Result questsList() {
        StringBuilder result = new StringBuilder();
        result.append("Quest 1 : 1 Gold bar  Reward: +1 frienship level");
        if (super.quest1) result.append(" (done)\n");
        else result.append(" (undone)\n");
        result.append("Quest 2 : 1 pumpkin Reward: 500 golds");
        if (super.quest2) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() < 200){
            result.append(" you need to have 200 friendship points with Abigail to unlock this quest\n");
        }
        else result.append(" undone\n");
        result.append("Quest 3 : 50 wheat  Reward: Iridium watering can");
        if (super.quest3) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentTime().getYear() > 0 || (App.getCurrentGame().getCurrentTime().getSeason() != Season.Spring && App.getCurrentGame().getCurrentTime().getSeason() != Season.Summer)){
            result.append(" (undone)\n");
        }
        else {
            result.append(" this quest unlocks after Summer\n");
        }
        return new Result(true, result.toString());
    }
    @Override
    public Result gift(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!super.getGiftNPCToday()) {
            player.addAbigailFriendship(50);
        }
        if (itemName.equalsIgnoreCase("stone")) {
            player.addAbigailFriendship(200);
        }
        if (itemName.equalsIgnoreCase("IronOre")) {
            player.addAbigailFriendship(200);
        }
        if (itemName.equalsIgnoreCase("coffee")) {
            player.addAbigailFriendship(200);
        }
        return new Result(true, "Abigail: You got this for me? Aww, you’re the best!" );
    }
    @Override
    public String getName() {
        return "Abigail";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) + abs(super.getNPCPlaceY() - player.getY()) > 1) {
            return new Result(false, "You are too far from Abigail to talk.");
        }

        boolean isFirstMeetingToday = !super.getMeetNPCToday();
        if (isFirstMeetingToday) {
            player.addAbigailFriendship(20);
            super.setMeetNPCToday(true);
        }

        int timeOfDay = App.getCurrentGame().getCurrentTime().getTime();
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        Weather weather = App.getCurrentGame().getWeather();
        int friendship = player.getAbigailFriendship();

        StringBuilder dialog = new StringBuilder();

        if (isFirstMeetingToday) {
            dialog.append("Abigail: Oh, hey! I'm so glad you stopped by. ");
        }

        if (friendship < 40) {
            if (weather == Weather.RAINY) {
                dialog.append("Rainy days make me feel cozy. Want to stay in and play some games?");
            } else if (timeOfDay < 12) {
                dialog.append("Mornings are better when shared with a friend.");
            } else {
                dialog.append("Hi there! I hope your day’s going well.");
            }
        } else if (friendship < 100) {
            if (season == Season.Spring && weather == Weather.SUNNY) {
                dialog.append("Everything feels alive in spring... just like my mood when I see you!");
            } else if (season == Season.Fall) {
                dialog.append("Fall is magical, don’t you think? I baked cookies if you want some!");
            } else {
                dialog.append("You're really kind. I like being around you.");
            }
        } else if (friendship < 200) {
            if (timeOfDay >= 18) {
                dialog.append("The stars are out soon. We should stargaze together sometime.");
            } else if (weather == Weather.RAINY) {
                dialog.append("Rain tapping on the window... it’s the perfect moment for tea and a story.");
            } else {
                dialog.append("I found a flower that reminded me of you. Want it?");
            }
        } else {
            if (season == Season.Summer) {
                dialog.append("Summer days are better with someone special... like you.");
            } else if (timeOfDay < 12) {
                dialog.append("Good morning! I was hoping to see you today. You make everything brighter.");
            } else {
                dialog.append("You're always welcome here. You feel like home.");
            }
        }

        return new Result(true, dialog.toString());
    }
}
