package com.calc.calculator;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;

        if (simplifiedDenominator < 0) {
            simplifiedNumerator *= -1;
            simplifiedDenominator *= -1;
        }

        this.numerator = simplifiedNumerator;
        this.denominator = simplifiedDenominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }
}
