package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String regExp = "[^\\d\\s\\-\\+\\*\\/\\.]+|^\\-\\d|[\\+\\-\\*\\/]$" +
            "|[\\+\\-\\*\\/]{2,}|\\d+ \\d+|\\d+\\.\\d+\\.\\d";

    public static boolean validate(String inputString) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputString);
        return !matcher.find();
    }

    public static String findErrors(String inputString) {
        StringBuilder errors = new StringBuilder();

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            errors.append(matcher.group()).append(" ");
        }

        return errors.toString().trim();
    }
}