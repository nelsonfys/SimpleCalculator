package com.calc.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void sumTestAddTwoNumbersExpectSum() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(2, 3));

    }

    @Test
    void sumTestAddZeroToNumberExpectNumber() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(0, 5));
    }

    @Test
    void differenceTestAddTwoNumbersExpectDifference() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.difference(6, 5));
    }

    @Test
    void differenceTestSubtractNumberFromZeroExpectNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.difference(0, 1));
    }
}
