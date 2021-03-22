package com.company;

import com.company.exception.DividingByZeroException;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public void expressionRequest() {
        while (true) {
            String inputString = scanner.nextLine().trim();

            if (inputString.equals("")) {
                System.out.println("Empty line");
                continue;
            }

            if (inputString.equalsIgnoreCase("exit") ||
                    inputString.equalsIgnoreCase("quit")) {
                break;
            }

            if (Validation.validate(inputString)) {
                ArrayDeque<String> rpn = ExpressionParser.convertToRPN(inputString);

                String calculationResult;
                try {
                    calculationResult = MathCalculation.calculate(rpn);
                } catch (DividingByZeroException exc) {
                    System.out.println(exc);
                    continue;
                }

                printResult(calculationResult);
            } else {
                printError(inputString);
            }
        }

        scanner.close();
    }

    public void printError(String inputString) {
        System.out.println("Incorrect Expression: " +
                Validation.findErrors(inputString) + "\n");
    }

    public void printResult(String result) {
        System.out.println("Result: " + result + "\n");
    }
}
