package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class AbigailsHouse extends NPCHouse{
    @Override
    public Result gift(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!super.getGiftNPCToday()) {
            player.addAbigailFriendship(50);
        }
    }
    @Override
    public String getName() {
        return "Abigail";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) > 1 || abs(super.getNPCPlaceY() - player.getY()) > 1) {
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
