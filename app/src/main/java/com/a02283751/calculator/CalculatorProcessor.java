package com.a02283751.calculator;

public class CalculatorProcessor {

    public static double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        if (expression.isEmpty()) {
            return Double.NaN;
        }
        if (tokens.length == 0) {
            // this is an error and needs to be handled
            return Double.NaN;
        }
        if (tokens.length == 1) {
            return Double.parseDouble(tokens[0]);
        }

        if (tokens.length % 2 == 0) {
            // we also have an error
            return Double.NaN;
        }

        double currentValue = Double.parseDouble(tokens[0]);
        String operation = tokens[1];
        String mode = "value";

        for (int i = 2; i < tokens.length; i++) {
            if (mode.equals("value")) {
                double foundValue = Double.parseDouble(tokens[i]);

                if (operation.equals("+")) {
                    currentValue = currentValue + foundValue;
                }
                if (operation.equals("-")) {
                    currentValue = currentValue - foundValue;
                }
                if (operation.equals("/")) {
                    if (foundValue == 0) {
                        return Double.NaN;
                    } else {
                        currentValue = currentValue / foundValue;
                    }
                }
                if (operation.equals("x")) {
                    currentValue = currentValue * foundValue;
                }
                mode = "operator";
            } else {
                operation = tokens[i];
                mode = "value";
            }
        }
        return currentValue;
    }
}
