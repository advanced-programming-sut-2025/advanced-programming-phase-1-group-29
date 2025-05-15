package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class RobinsHouse extends NPCHouse {
    @Override
    public Result questFinish(int ind) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (ind == 1 && !super.quest1){
            if (player.getInventory().getNumberOfInventoryItem("wood") < 80){
                return new Result(false, "You don't have enough wood in your inventory.");
            }
            else {
                super.quest1 = true;
                player.addCoins(1000);
                return new Result(true, "quest completed. you received 1000 coins.");
            }
        }
        else if (ind == 2 && !super.quest2 && App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() >= 200){
            if (player.getInventory().getNumberOfInventoryItem("ironBar") < 10){
                return new Result(false, "You don't have enough iron bar in your inventory.");
            }
            else {
                super.quest2 = true;
                player.getInventory().addInventoryItem("queenBeeHive", 3, 0);
                return new Result(true, "quest completed. you received 3 Queen Bee Hives.");
            }
        }
        else if (ind == 3 && !super.quest3 && (App.getCurrentGame().getCurrentTime().getYear() > 0 || (App.getCurrentGame().getCurrentTime().getSeason() == Season.Winter))){
            if (player.getInventory().getNumberOfInventoryItem("wood") < 1000){
                return new Result(false, "You don't have enough wood in your inventory.");
            }
            else{
                super.quest3 = true;
                player.addCoins(25000);
                return new Result(true, "quest completed. you received 25000 coins.");
            }
        }
        else return new Result(false, "invalid index");
    }
    @Override
    public Result questsList() {
        StringBuilder result = new StringBuilder();
        result.append("Quest 1 : 80 woods  Reward: 1000 golds");
        if (super.quest1) result.append(" (done)\n");
        else result.append(" (undone)\n");
        result.append("Quest 2 : 10 iron bar Reward: 3 queen bee hives");
        if (super.quest2) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() < 200){
            result.append(" you need to have 200 friendship points with Robin to unlock this quest\n");
        }
        else result.append(" undone\n");
        result.append("Quest 3 : 1000 woods Reward: 25000 golds");
        if (super.quest3) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentTime().getYear() > 1){
            result.append(" (undone)\n");
        }
        else {
            result.append(" this quest unlocks after a year\n");
        }
        return new Result(true, result.toString());
    }
    @Override
    public Result gift(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!super.getGiftNPCToday()) {
            player.addRobinFriendship(50);
        }
        if (itemName.equalsIgnoreCase("Spaghetti")) {
            player.addRobinFriendship(200);
        }
        if (itemName.equalsIgnoreCase("wood")) {
            player.addRobinFriendship(200);
        }
        if (itemName.equalsIgnoreCase("ironBar")) {
            player.addRobinFriendship(200);
        }
        return new Result(true, "Robin: Hmph. Well... at least it’s useful. Thanks." );
    }
    @Override
    public String getName() {
        return "Robin";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) + abs(super.getNPCPlaceY() - player.getY()) > 1) {
            return new Result(false, "You are too far from Robin to talk.");
        }

        boolean isFirstMeetingToday = !super.getMeetNPCToday();
        if (isFirstMeetingToday) {
            player.addRobinFriendship(20);
            super.setMeetNPCToday(true);
        }

        int timeOfDay = App.getCurrentGame().getCurrentTime().getTime();
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        Weather weather = App.getCurrentGame().getWeather();
        int friendship = player.getRobinFriendship();

        StringBuilder dialog = new StringBuilder();

        if (isFirstMeetingToday) {
            dialog.append("Robin: What now? ");
        }

        if (friendship < 40) {
            if (weather == Weather.RAINY) {
                dialog.append("Rain again?! Great, just what my joints needed.");
            } else if (season == Season.Winter) {
                dialog.append("Snow blocks everything. And guess who has to shovel it?");
            } else {
                dialog.append("Unless you're buying lumber or building a barn, don't waste my time.");
            }
        } else if (friendship < 100) {
            if (season == Season.Spring && timeOfDay < 12) {
                dialog.append("Spring? Sure. Means I’ll be fixing everyone’s fences all over again.");
            } else {
                dialog.append("You’re slightly less annoying than usual. Congrats.");
            }
        } else if (friendship < 200) {
            if (weather == Weather.SUNNY) {
                dialog.append("Alright, alright… it’s a decent day. Don’t push your luck.");
            } else if (timeOfDay >= 18) {
                dialog.append("Still working? Huh. Maybe you’re not as lazy as you look.");
            } else {
                dialog.append("You know, you're not half bad... for a farmer.");
            }
        } else {
            if (season == Season.Fall) {
                dialog.append("Fall’s alright. Quiet. Peaceful. No one asking for a new coop every five minutes.");
            } else {
                dialog.append("If you ever need help, just ask. I’ll pretend not to mind.");
            }
        }

        return new Result(true, dialog.toString());
    }
}
