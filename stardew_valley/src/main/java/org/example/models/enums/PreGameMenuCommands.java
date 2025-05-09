package org.example.models.enums;

public enum PreGameMenuCommands implements Command {
    MenuEnter("\\s*menu\\s+enter\\s+Main\\s+Menu\\s*"),
    ShowCurrentMenu("\\s*show\\s+current\\s+menu\\s*"),
    GameNew("\\s*game\\s+new\\s+-u\\s+(?<username1>\\S+)\\s*(?<username2>\\S*)\\s*(?<username3>\\S*)\\s*");

    private final String pattern;
    PreGameMenuCommands(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public String getPattern() {
        return pattern;
    }
}
