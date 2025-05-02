package org.example.models.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public interface Command {
    String getPattern();

    default Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(getPattern()).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
