package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                "Hello! This is a console calculator v1.0\n" +
                "Enter math expression like '3. + 23 - 34.02 * 100 / .5'\n" +
                "Available operations: +, -, *, /\n" +
                "In this version you may not use round brackets and negative numbers\n" +
                "Enter 'exit' or 'quit' to exit the program\n");

        ConsoleIO console = new ConsoleIO();
        console.expressionRequest();
    }
}
