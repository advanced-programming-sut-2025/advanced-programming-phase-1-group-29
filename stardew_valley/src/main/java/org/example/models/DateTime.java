package org.example.models;

import org.example.models.enums.Seasons;

public class DateTime {
    private Seasons season;
    private int day;
    private int time;

    public DateTime(Seasons season, int day, int time) {
        this.season = season;
        this.day = day;
        this.time = time;
    }

    public Seasons getSeason() {
        return season;
    }

    public void setSeason(Seasons season) {
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
