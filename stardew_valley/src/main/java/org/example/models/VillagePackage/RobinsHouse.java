package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class RobinsHouse extends NPCHouse {
    @Override
    public String getName() {
        return "Robin";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) > 1 || abs(super.getNPCPlaceY() - player.getY()) > 1) {
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
