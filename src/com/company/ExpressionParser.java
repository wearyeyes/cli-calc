package com.company;

import java.util.ArrayDeque;

public class ExpressionParser {
    // RPN - Reverse Polish Notation
    public static ArrayDeque<String> convertToRPN(String inputExpression) {

        String[] tokens = prepareExpression(inputExpression).split(" ");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                outputQueue.add(token);
            } else {
                if (!operatorStack.isEmpty()
                        && getPriority(operatorStack.getLast()) > getPriority(token)) {
                    while (!operatorStack.isEmpty()
                            && getPriority(operatorStack.getLast()) > getPriority(token)) {
                        outputQueue.add(operatorStack.removeLast());
                    }
                }

                if (!operatorStack.isEmpty()
                        && getPriority(operatorStack.getLast()) == getPriority(token)) {
                    outputQueue.add(operatorStack.removeLast());
                }

                operatorStack.add(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.removeLast());
        }

        return outputQueue;
    }

    public static boolean isNumber(String token) {
        if (token == null || token.equals("")) return false;
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    private static int getPriority(String token) {
        switch (token) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    // Input math expression may be without spaces between operators and operands.
    private static String prepareExpression(String inputString) {
        String expression = inputString.replaceAll(" ", "");

        // Insert spaces before and after operators.
        String regExp = "(?<=[\\+\\-\\*\\/])|(?=[\\+\\-\\*\\/])";
        return expression.replaceAll(regExp, " ").trim();
    }
}
