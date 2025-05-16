package org.example.models.enums;

import java.util.regex.Matcher;

public enum ProfileMenuCommands implements Command{
    ShowCurrentMenu("\\s*show\\s+current\\s+menu\\s*"),
    MenuEnter("\\s*menu\\s+enter\\s+Main\\s+Menu\\s*"),
    ChangeUsername("\\s*change\\s+username\\s+-u\\s+(?<username>.+)\\s*"),
    ChangeNickname("\\s*change\\s+nickname\\s+-u\\s+(?<nickname>.+)\\s*"),
    ChangeEmail("\\s+change\\s+email\\s+-e\\s+(?<email>.+)\\s*"),
    ChangePassword("\\s*change\\s+password\\s+-p\\s+(?<newPassword>.+)\\s+-o\\s+(?<oldPassword>.+)\\s*"),
    UserInfo("\\s*user\\s+info\\s*"),
    MenuExit("\\s*menu\\s+exit\\s*"),
    ;


    private final String pattern;
    ProfileMenuCommands(String pattern) {
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