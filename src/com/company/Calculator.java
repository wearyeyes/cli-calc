package com.company;

import com.company.exception.DividingByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;

public class Calculator {
    private ExpressionParser parser;

    public Calculator() {
        this.parser = new ExpressionParser();
    }

    public String calculate(ArrayDeque<String> expressionInRPN) throws DividingByZeroException {
        ArrayDeque<BigDecimal> stack = new ArrayDeque<>();

        for (String token : expressionInRPN) {
            if (parser.isNumber(token)) {
                stack.add(new BigDecimal(token));
            } else {
                BigDecimal tmp1 = stack.removeLast();
                BigDecimal tmp2 = stack.removeLast();

                switch (token) {
                    case "+":
                        stack.add(tmp2.add(tmp1));
                        break;
                    case "-":
                        stack.add(tmp2.subtract(tmp1));
                        break;
                    case "*":
                        stack.add(tmp2.multiply(tmp1));
                        break;
                    case "/":
                        if (tmp1.equals(BigDecimal.ZERO)) {
                            throw new DividingByZeroException(tmp2.toString(), tmp1.toString());
                        }

                        BigDecimal divisionResult = tmp2.divide(tmp1, 10, RoundingMode.DOWN);
                        stack.add(divisionResult);
                        break;
                }
            }
        }

        return stack.poll().toString();
    }
}
