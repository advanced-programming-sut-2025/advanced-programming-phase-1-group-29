package org.example.models.enums;

import java.util.regex.Matcher;

public enum GameMenuCommands implements Command {
    GameNew("\\s*game\\s+new\\s+-u\\s+(?<username1>\\S+)\\s*(?<username2>\\S*)\\s*(?<username3>\\S*)\\s*"),
    GameMap("\\s*game\\s+map\\s+(?<mapNumber>\\d+)\\s*"),
    LoadGame("\\s*load\\s+game\\s*"),
    ExitGame("\\s*exit\\s+game\\s*"),
    ForceTerminate("\\s*force\\s+terminate\\s*"),
    NextTurn("\\s*next\\s+turn\\s*"),
    Time("\\s*time\\s*"),
    Date("\\s*date\\s*"),
    DateTime("\\s*datetime\\s*"),
    DayOfTheWeek("\\s*day\\s+of\\s+the\\s+week\\s*"),
    CheatAdvanceTime("\\s*cheat\\s+advance\\s+time\\s+(?<x>\\d+)h\\s*"),
    CheatAdvanceDate("\\s*cheat\\s+advance\\s+date\\s+(?<x>\\d+)d\\s*"),
    Season("\\s*season\\s*"),
    CheatThor("\\s*cheat\\s+Thor\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    Weather("\\s*weather\\s*"),
    WeatherForecast("\\s*weather\\s+forecast\\s*"),
    CheatWeatherSet("\\s*cheat\\s+weather\\s+set\\s+(?<type>.+)\\s*"),
    GreenHouseBuild("\\s*greenhouse\\s+build\\s*"),
    Walk("\\s*walk\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*"),
    PrintMap("\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*"),
    HelpReadingMap("\\s*help\\s+reading\\s+map\\s*"),
    EnergyShow("\\s*energy\\s+show\\s*"),
    ;


    private final String pattern;
    GameMenuCommands(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public String getPattern() {
        return "";
    }

    @Override
    public Matcher getMatcher(String input) {
        return Command.super.getMatcher(input);
    }
}
