package com.company;

public class Main {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO(new Validator(),
                        new ExpressionParser(),
                        new Calculator());

        console.greeting();
        console.expressionRequest();
    }
}
