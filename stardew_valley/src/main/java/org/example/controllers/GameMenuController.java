package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;

public class GameMenuController extends Controller{
    public void exitGame(){
        App.setCurrentMenu(Menu.ExitMenu);
    }
    public Result time(){
        return new Result(true, "It's " + App.getCurrentGame().getCurrentTime().getTime() + " o'clock");
    }
    public Result date(){
        return new Result(true, "It's day " + App.getCurrentGame().getCurrentTime().getDay() + " of " + App.getCurrentGame().getCurrentTime().getSeason());
    }
    public Result dateTime(){
        return new Result(true, "It's " + App.getCurrentGame().getCurrentTime().getTime() + " o'clock on day " + App.getCurrentGame().getCurrentTime().getDay() + " of " + App.getCurrentGame().getCurrentTime().getSeason());
    }
    public Result dayOfTheWeek(){
        int day = App.getCurrentGame().getCurrentTime().getDay();
        return switch (day % 7) {
            case 1 -> new Result(true, "Saturday");
            case 2 -> new Result(true, "Sunday");
            case 3 -> new Result(true, "Monday");
            case 4 -> new Result(true, "Tuesday");
            case 5 -> new Result(true, "Wednesday");
            case 6 -> new Result(true, "Thursday");
            default -> new Result(true, "Friday");
        };
    }
}
