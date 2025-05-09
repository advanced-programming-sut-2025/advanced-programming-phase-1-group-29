package org.example.models;

import org.example.models.enums.Season;

public class DateTime {
    private Season season;
    private int day;
    private int time;

    public DateTime(Season season, int day, int time) {
        this.season = season;
        this.day = day;
        this.time = time;
    }

    public void incrementTime() {
        time++;
        if (time == 24) {
            time = 0;
            incrementDay();
        }
    }

    public void incrementDay() {
        day++;
        if (day == 29) {
            day = 1;
            if (season.equals(Season.SPRING)) setSeason(Season.SUMMER);
            else if (season.equals(Season.SUMMER)) setSeason(Season.AUTUMN);
            else if (season.equals(Season.AUTUMN)) setSeason(Season.WINTER);
            else setSeason(Season.SPRING);
        }
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
