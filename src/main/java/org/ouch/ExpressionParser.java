package org.ouch;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionParser {
    // RPN - Reverse Polish Notation
    public Deque<String> convertToRPN(String inputExpression) {

        String[] tokens = prepareExpression(inputExpression).split(" ");
        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

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
        System.out.println(outputQueue);
        return outputQueue;
    }

    public boolean isNumber(String token) {
        if (token == null) return false;
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    private int getPriority(String token) {
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
