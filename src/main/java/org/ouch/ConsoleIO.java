package org.ouch;

import org.ouch.exception.DividingByZeroException;

import java.util.Deque;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;
    private Validator validator;
    private ExpressionParser parser;
    private Calculator calculator;

    private final String GREETING_MESSAGE = "Hello! This is a console calculator v1.0\n" +
            "Enter math expression like '3. + 23 - 34.02 * 100 / .5'\n" +
            "Available operations: +, -, *, /\n" +
            "In this version you may not use round brackets and negative numbers\n" +
            "Enter 'exit' or 'quit' to exit the program\n";

    public ConsoleIO(Validator validator,
                     ExpressionParser parser,
                     Calculator calculator) {
        this.scanner = new Scanner(System.in);
        this.validator = validator;
        this.parser = parser;
        this.calculator = calculator;
    }

    public void expressionRequest() {
        while (true) {
            System.out.println("Enter math expression:");
            String inputString = scanner.nextLine().trim();

            if (inputString.equals("")) {
                System.out.println("Empty line");
                continue;
            }

            if (inputString.equalsIgnoreCase("exit") ||
                    inputString.equalsIgnoreCase("quit")) {
                break;
            }

            if (validator.validate(inputString)) {
                Deque<String> rpn = parser.convertToRPN(inputString);

                String calculationResult;
                try {
                    calculationResult = calculator.calculate(rpn);
                } catch (DividingByZeroException exc) {
                    exc.printException();
                    continue;
                }

                printResult(calculationResult);
            } else {
                printError(inputString);
            }
        }

        scanner.close();
    }

    public void greeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public void printResult(String result) {
        System.out.println("Result: " + result + "\n");
    }

    public void printError(String inputString) {
        System.out.println("Incorrect Expression: " +
                validator.findErrors(inputString) + "\n");
    }

}
