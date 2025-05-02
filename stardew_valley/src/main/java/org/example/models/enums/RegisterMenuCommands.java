package org.example.models.enums;

public enum RegisterMenuCommands implements Command{
    MenuEnter("\\s*menu\\s+enter\\s+(?<menuName>.+?)\\s*"),
    ShowCurrentMenu("\\s*show\\s+current\\s+menu\\s*"),
    Register(
            "\\s*register\\s+-u\\s+(?<username>.+?)\\s+-p\\s+(?<password>.+?)\\s+(?<passwordConfirm>.+?)" +
                    "\\s+-n\\s+(?<nickname>.+?)\\s+-e\\s+(?<email>.+?)\\s+-g\\s+(?<gender>.+?)\\s*"
    ),
    Username("[a-zA-Z0-9-]+"),
    Email(
            "(?!.+\\.\\.)[a-zA-Z0-9]([a-zA-Z0-9.-_]*[a-zA-Z0-9])?@" +
                    "[a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?.[a-zA-Z]{2,}"
    ),
    Password("[a-zA-Z0-9?<>,;:'\"\\/\\\\|\\[\\]{}\\+=\\)\\(\\*&\\^%\\$#!]+"),
    StrongPassword("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[?<>,;:'\"\\/\\\\|\\[\\]{}\\+=\\)\\(\\*&\\^%\\$#!]).*"),
    YesOrNo("\\s*(Y|N)\\s*"),
    PickQuestion(
            "\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>\\d+)\\s+" +
                    "-a\\s+(?<answer>.+?)\\s+-c\\s+(?<answerConfirm>.+?)\\s*"
    ),
    MenuExit("\\s*menu\\s+exit\\s*");
    private final String pattern;

    RegisterMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
