package org.example.models.enums;

import java.util.regex.Matcher;

public enum LoginMenuCommands implements Command {
    MenuEnter("\\s*menu\\s+enter\\s+Register\\s+Menu\\s*"),
    MenuExit("\\s*menu\\s+exit\\s*"),
    ShowCurrentMenu("\\s*show\\s+current\\s+menu\\s*"),
    Login("\\s*login\\s+-u\\s+(?<username>.+)\\s+-p\\s+(?<password>.+)\\s*(?<stayLoggedIn>.*)\\s*"),
    ForgetPassword("\\s*forget\\s+password\\s+-u\\s+(?<username>.+)\\s*"),
    Answer("\\s*answer\\s+-a\\s+(?<answer>.+)\\s*")
    ;


    private final String pattern;
    LoginMenuCommands(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public String getPattern() {
        return this.pattern;
    }

}
