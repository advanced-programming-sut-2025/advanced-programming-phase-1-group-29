package org.example.models.enums;

public enum MainMenuCommands implements Command{
    ProfileMenuEnter("\\s*menu\\s+enter\\s+Profile\\s+Menu\\s*"),
    GameMenuEnter("\\s*menu\\s+enter\\s+Game\\s+Menu\\s*"),
    AvatarMenuEnter("\\s*menu\\s+enter\\s+Avatar\\s+Menu\\s*"),
    UserLogout("\\s*user\\s+logout\\s*"),
    MenuExit("\\s*menu\\s+exit\\s*")
    ;
    private final String pattern;

    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
