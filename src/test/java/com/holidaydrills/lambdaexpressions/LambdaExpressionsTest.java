package com.holidaydrills.lambdaexpressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExpressionsTest {

    LambdaExpressions cut = new LambdaExpressions();

    int valueOne = 10;
    int valueTwo = 15;

    @Test
    public void calculateTwoValues() {

        int result = cut.calculateTwoValues(valueOne, valueTwo, (a, b) -> a + b);

        int expected = valueOne + valueTwo;
        assertEquals(expected, result);
    }

    @Test
    void makeSum() {
        int result =cut.makeSum();

        int expected = 12;
        assertEquals(expected, result);
    }

    @Test
    void makeProduct() {
        int result = cut.makeProduct();

        int expected = 35;
        assertEquals(expected, result);
    }

    @Test
    void makeSumTheOldWay() {
        int result = cut.makeSumTheOldWay();

        int expected = 12;
        assertEquals(expected, result);
    }

    @Test
    void makeProductTheOldWay() {
        int result = cut.makeProductTheOldWay();

        int expected = 35;
        assertEquals(expected, result);
    }

    @Test
    void makeProductTheOldWayImplementationInline() {
        int result = cut.makeProductTheOldWayImplementationInline();

        int expected = 35;
        assertEquals(expected, result);
    }

    @Test
    void calculateTwoValuesWithBiFunction() {
        int result = cut.calculateTwoValuesWithBiFunction(valueOne, valueTwo, (a, b) -> a * b);

        int expected = 35;
        assertEquals(expected, result);
    }

    @Test
    public void makeProductWithBiFunction() {

        int result = cut.makeProductWithBiFunction();

        int expected = 35;
        assertEquals(expected, result);
    }
}