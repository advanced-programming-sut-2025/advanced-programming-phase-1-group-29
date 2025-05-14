package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Season;
import org.example.models.enums.Weather;

import static java.lang.Math.abs;

public class LiasHouse extends NPCHouse {
    @Override
    public Result gift(String itemName) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!super.getGiftNPCToday()) {
            player.addLiaFriendship(50);
        }
        if (itemName.equalsIgnoreCase("Salad")) {
            player.addLiaFriendship(200);
        }
        if (itemName.equalsIgnoreCase("Wine")) {
            player.addLiaFriendship(200);
        }
        if (itemName.equalsIgnoreCase("grape")) {
            player.addLiaFriendship(200);
        }
        return new Result("Lia: Gifts like this make my heart feel warm. You're wonderful.");
    }
    @Override
    public String getName() {
        return "Lia";
    }
    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (abs(super.getNPCPlaceX() - player.getX()) > 1 || abs(super.getNPCPlaceY() - player.getY()) > 1) {
            return new Result(false, "You are too far from Lia to talk.");
        }

        boolean isFirstMeetingToday = !super.getMeetNPCToday();
        if (isFirstMeetingToday) {
            player.addLiaFriendship(20);
            super.setMeetNPCToday(true);
        }

        int timeOfDay = App.getCurrentGame().getCurrentTime().getTime();
        Season season = App.getCurrentGame().getCurrentTime().getSeason();
        Weather weather = App.getCurrentGame().getWeather();
        int friendship = player.getLiaFriendship();

        StringBuilder dialog = new StringBuilder();

        if (isFirstMeetingToday) {
            dialog.append("Lia: Oh! Hey there. You always brighten up my space. ");
        }

        if (friendship < 40) {
            if (weather == Weather.RAINY) {
                dialog.append("Rain is the earth’s way of breathing, don't you think?");
            } else if (season == Season.Spring) {
                dialog.append("Everything feels new in spring. It’s the perfect time for inspiration.");
            } else if (timeOfDay < 12) {
                dialog.append("Mornings are quiet here. It helps me think... and create.");
            } else {
                dialog.append("Do you enjoy art? Even doodling can feel magical.");
            }
        } else if (friendship < 100) {
            if (season == Season.Summer) {
                dialog.append("I’ve been sketching by the river lately. The reflections are beautiful.");
            } else if (weather == Weather.SUNNY) {
                dialog.append("Sunlight through the trees makes everything look like a painting.");
            } else {
                dialog.append("I think your presence brings good energy. It’s... calming.");
            }
        } else if (friendship < 200) {
            if (season == Season.Fall) {
                dialog.append("The crunch of leaves underfoot—it’s like nature’s applause.");
            } else if (weather == Weather.RAINY) {
                dialog.append("Rainy days are perfect for warm tea and quiet sketches.");
            } else {
                dialog.append("You always arrive at the perfect time. It’s like the universe nudged you here.");
            }
        } else {
            if (timeOfDay >= 18) {
                dialog.append("You know... if you ever want to watch the stars with me, I’d like that.");
            } else {
                dialog.append("I’ve carved something small for you. Just... to say thank you for being kind.");
            }
        }

        return new Result(true, dialog.toString());
    }
}
