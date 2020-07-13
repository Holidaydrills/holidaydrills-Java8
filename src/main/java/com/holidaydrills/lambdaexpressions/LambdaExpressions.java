package com.holidaydrills.lambdaexpressions;

import java.util.function.BiFunction;

public class LambdaExpressions {

    public int calculateTwoValues(int valueOne, int valueTwo, FancyCalculator fancyCalculator) {
        return fancyCalculator.calculateTwoValues(valueOne, valueTwo);
    }

    public int makeSum() {
        FancyCalculator sumCalculator = (a,b) -> a + b;
        return calculateTwoValues(5, 7, sumCalculator);
    }

    public int makeProduct() {
        BiFunction<Integer, Integer, Integer> bi = (a, b) ->  a + b;
        return calculateTwoValues(5, 7, (a,b) -> a * b);
    }

    public int makeSumTheOldWay() {
        FancyCalculator calculator = new FancyCalculator() {
            @Override
            public int calculateTwoValues(int valueOne, int valueTwo) {
                return valueOne + valueTwo;
            }
        };
        return calculateTwoValues(5, 7, calculator);
    }

    public int makeProductTheOldWay() {
        FancyCalculator calculator = new FancyCalculator() {
            @Override
            public int calculateTwoValues(int valueOne, int valueTwo) {
                return valueOne * valueTwo;
            }
        };
        return calculateTwoValues(5, 7, calculator);
    }

    public int makeProductTheOldWayImplementationInline() {
        return calculateTwoValues(5, 7, new FancyCalculator() {
            @Override
            public int calculateTwoValues(int valueOne, int valueTwo) {
                return valueOne * valueTwo;
            }
        });
    }

}
