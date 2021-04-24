package org.ouch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final String VALIDATION_REG_EXP =
            "[^\\d\\s\\-\\+\\*\\/\\.]+|" +
                    "^[\\-\\+\\*\\/] ?\\d|" +
                    "[\\+\\-\\*\\/]$|" +
                    "[\\+\\-\\*\\/]{2,}|" +
                    "\\d+ \\d+|" +
                    "\\d+\\.\\d+\\.\\d";

    public boolean validate(String inputString) {
        Pattern pattern = Pattern.compile(VALIDATION_REG_EXP);
        Matcher matcher = pattern.matcher(inputString);
        return !matcher.find();
    }

    public String findErrors(String inputString) {
        StringBuilder errors = new StringBuilder();

        Pattern pattern = Pattern.compile(VALIDATION_REG_EXP);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            errors.append(matcher.group()).append(" ");
        }

        return errors.toString().trim();
    }
}