package com.company.exception;

import java.sql.SQLOutput;

public class DividingByZeroException extends Exception {
    private final String dividend;
    private final String divisor;

    public DividingByZeroException(String dividend, String divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public void printException() {
        System.out.println("Error! Dividing By Zero: " + dividend + "/" + divisor + "\n");
    }
}
