package org.example.models.enums;

public enum MapSelectionMenuCommands implements Command{
    GameMap("\\s*game\\s+map\\s+(?<mapNumber>\\d+)\\s*");

    private final String pattern;

    MapSelectionMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
