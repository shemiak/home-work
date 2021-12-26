package com.sbrf.reboot.calculator;

public class Calculator {
    public double getAddition(double term1, double term2) {
        return term1 + term2;
    }

    public double getSubtraction(double subtrahend1, double subtrahend2) {
        return subtrahend1 - subtrahend2;
    }

    public double getMultiplication(double factor1, double factor2) {
        return factor1 * factor2;
    }

    public double getDivision(double dividend, double divider) {
        return dividend / divider;
    }

    public double getRemainder(double dividend, double divider) {
        return dividend % divider;
    }

    public double getPower(double number, double power) {
        return Math.pow(number, power);
    }

    public double getSquareRoot(double number) {
        return Math.sqrt(number);
    }
}
