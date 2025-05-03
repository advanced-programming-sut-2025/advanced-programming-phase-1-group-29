package org.example.models.enums;

public enum MainMenuCommands implements Command{
    MenuEnter("\\s*menu\\s+enter\\s+(?<menuName>.+?)\\s*"),
    UserLogout("\\s*user\\s+logout\\s*");
    private final String pattern;

    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
