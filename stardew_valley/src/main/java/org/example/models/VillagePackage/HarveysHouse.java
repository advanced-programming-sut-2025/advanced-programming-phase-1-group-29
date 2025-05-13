package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class HarveysHouse extends NPCHouse {
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
