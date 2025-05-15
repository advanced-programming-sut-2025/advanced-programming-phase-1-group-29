package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class HarveysHouse extends NPCHouse {
    @Override
    public Result questFinish(int ind) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (ind == 1 && !super.quest1){
            if (player.getInventory().getNumberOfInventoryItem("plant") < 1){ // TODO
                return new Result(false, "You don't have enough plants in your inventory.");
            }
            else {
                super.quest1 = true;
                player.addCoins(750);
                return new Result(true, "quest completed. you received 750 coins");
            }
        }
        else if (ind == 2 && !super.quest2 && App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() >= 200){
            if (player.getInventory().getNumberOfInventoryItem("salmon") < 1){
                return new Result(false, "You don't have enough salmon in your inventory.");
            }
            else {
                super.quest2 = true;
                player.addHarveyFriendship(1);
                return new Result(true, "quest completed. your friendship with Harvey increased 1");
            }
        }
        else if (ind == 3 && !super.quest3 && (App.getCurrentGame().getCurrentTime().getYear() > 0 || (App.getCurrentGame().getCurrentTime().getSeason() != Season.Spring && App.getCurrentGame().getCurrentTime().getSeason() != Season.Summer))){
            if (player.getInventory().getNumberOfInventoryItem("wine") < 1){
                return new Result(false, "You don't have wine in your inventory.");
            }
            else{
                super.quest3 = true;
                player.getInventory().addInventoryItem("salad", 5, 0);//TODO??
                return new Result(true, "quest completed. you received 5 salads.");
            }
        }
        else return new Result(false, "invalid index");
    }
    @Override
    public Result questsList() {
        StringBuilder result = new StringBuilder();
        result.append("Quest 1 : 12 plants of choice  Reward: 750 golds");
        if (super.quest1) result.append(" (done)\n");
        else result.append(" (undone)\n");
        result.append("Quest 2 : 1 Salmon Reward: +1 friendship level");
        if (super.quest2) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() < 200){
            result.append(" you need to have 200 friendship points with Harvey to unlock this quest\n");
        }
        else result.append(" undone\n");
        result.append("Quest 3 : 1 Wine  Reward: 5 salads ");
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
            player.addHarveyFriendship(50);
        }
        if (itemName.equalsIgnoreCase("coffee")) {
            player.addHarveyFriendship(200);
        }
        if (itemName.equalsIgnoreCase("pickle")) {
            player.addHarveyFriendship(200);
        }
        if (itemName.equalsIgnoreCase("wine")) {
            player.addHarveyFriendship(200);
        }
        return new Result(true, "Harvey: You didn’t have to... but I’m grateful you did.");
    }
    @Override
    public String getName() {
        return "Harvey";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) > 1 || abs(super.getNPCPlaceY() - player.getY()) > 1) {
            return new Result(false, "You are too far from Harvey to talk.");
        }

        boolean isFirstMeetingToday = !super.getMeetNPCToday();
        if (isFirstMeetingToday) {
            player.addHarveyFriendship(20);
            super.setMeetNPCToday(true);
        }

        int timeOfDay = App.getCurrentGame().getCurrentTime().getTime();
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        Weather weather = App.getCurrentGame().getWeather();
        int friendship = player.getHarveyFriendship();

        StringBuilder dialog = new StringBuilder();

        if (isFirstMeetingToday) {
            dialog.append("Harvey: Ah, hello! Always good to check in. ");
        }

        if (friendship < 40) {
            if (weather == Weather.RAINY) {
                dialog.append("Be sure to stay dry today. A cold is the last thing you want.");
            } else if (season == Season.Winter) {
                dialog.append("The cold weather can be hard on the joints. Stay warm, alright?");
            } else {
                dialog.append("Remember to eat well and rest. Your health matters.");
            }
        } else if (friendship < 100) {
            if (season == Season.Spring && weather == Weather.SUNNY) {
                dialog.append("A sunny spring day! Excellent for both mood and metabolism.");
            } else if (timeOfDay < 12) {
                dialog.append("Good morning! Did you get enough sleep?");
            } else {
                dialog.append("It's always nice to talk. Let me know if you need a checkup.");
            }
        } else if (friendship < 200) {
            if (weather == Weather.RAINY) {
                dialog.append("Rainy days are peaceful. I like reading medical journals during storms.");
            } else if (season == Season.Fall) {
                dialog.append("Fall air is crisp and clean. Great for your lungs.");
            } else {
                dialog.append("You seem healthier lately. Taking care of yourself, I hope?");
            }
        } else {
            if (timeOfDay >= 18) {
                dialog.append("Evenings like this remind me why I love this town. Maybe we could share some tea sometime?");
            } else {
                dialog.append("I feel I can trust you. Thank you for being so consistent.");
            }
        }

        return new Result(true, dialog.toString());
    }
}
