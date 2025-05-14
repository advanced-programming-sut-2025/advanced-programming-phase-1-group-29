package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class SebastiansHouse extends NPCHouse{
    @Override
    public String getName() {
        return "Sebastian";
    }
    @Override
    public Result questsList() {
        StringBuilder result = new StringBuilder();
        result.append("Quest 1 : 50 Irons  Reward: 2 Diamonds");
        if (super.quest1) result.append(" (done)\n");
        else result.append(" (undone)\n");
        result.append("Quest 2 : 1 pumpkin pie  Reward: 5000 golds");
        if (super.quest2) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentPlayer().getSebastianFriendship() < 200){
            result.append(" you need to have 200 friendship points with Sebastian to unlock this quest\n");
        }
        else result.append(" undone\n");
        result.append("Quest 3 : 150 stones  Reward: 50 quartz");
        if (super.quest3) result.append(" (done)\n");
        else if (App.getCurrentGame().getCurrentTime().getSeason() )
    }
    @Override
    public Result gift(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!super.getGiftNPCToday()){
            player.addSebastianFriendship(50);
        }
        if (itemName.equalsIgnoreCase("pizza")) {
            player.addSebastianFriendship(200);
        }
        if (itemName.equalsIgnoreCase("wool")) {
            player.addSebastianFriendship(200);
        }
        if (itemName.equalsIgnoreCase("pumpkinPie")) {
            player.addSebastianFriendship(200);
        }
        return new Result(true, "Sebastian: Huh. I didn’t expect this from you. I mean that in a good way.");
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (abs(super.getNPCPlaceX() - player.getX()) > 1 || abs(super.getNPCPlaceY() - player.getY()) > 1) {
            return new Result(false, "You are too far from Sebastian to talk.");
        }

        boolean isFirstMeetingToday = !super.getMeetNPCToday();
        if (isFirstMeetingToday) {
            player.addSebastianFriendship(20);
            super.setMeetNPCToday(true);
        }

        int timeOfDay = App.getCurrentGame().getCurrentTime().getTime(); // e.g., 0–24
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        Weather weather = App.getCurrentGame().getWeather();
        int friendship = player.getSebastianFriendship();

        StringBuilder dialog = new StringBuilder();

        if (isFirstMeetingToday) {
            dialog.append("Sebastian: Hey there. Good to see you. ");
        }

        if (friendship < 40) {
            if (weather == Weather.RAINY) {
                dialog.append("I don’t mind the rain. People leave me alone.");
            } else if (season == Season.Winter) {
                dialog.append("Cold, dark... just how I like it.");
            } else if (timeOfDay < 12) {
                dialog.append("Morning... already?");
            } else {
                dialog.append("Do I know you?");
            }
        } else if (friendship < 100) {
            if (weather == Weather.SUNNY && season == Season.Spring) {
                dialog.append("The sun’s out. I guess that’s nice for a change.");
            } else if (season == Season.Summer) {
                dialog.append("Summer's fine if I don’t have to go outside.");
            } else {
                dialog.append("I'm starting to like you. You seem... different.");
            }
        } else if (friendship < 200) {
            if (season == Season.Fall) {
                dialog.append("Fall’s cool. The colors match my hoodie.");
            } else if (weather == Weather.RAINY) {
                dialog.append("Rain’s perfect for staying in and working.");
            } else if (timeOfDay > 18) {
                dialog.append("Evenings are my favorite time to code.");
            } else {
                dialog.append("Nice seeing you again. I was just thinking about some mods.");
            }
        } else {
            if (timeOfDay >= 17) {
                dialog.append("Want to come stargazing with me later?");
            } else if (season == Season.Spring && weather == Weather.SUNNY) {
                dialog.append("Days like this make me almost want to go outside.");
            } else {
                dialog.append("It's really nice talking to you. I’m glad we’ve become friends.");
            }
        }

        return new Result(true, dialog.toString());
    }

}
