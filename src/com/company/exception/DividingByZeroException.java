package com.company.exception;

public class DividingByZeroException extends Exception {
    private final String dividend;
    private final String divisor;

    public DividingByZeroException(String dividend, String divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    @Override
    public String toString() {
        return "Error. Dividing By Zero: " + dividend + "/" + divisor + "\n";
    }
}
