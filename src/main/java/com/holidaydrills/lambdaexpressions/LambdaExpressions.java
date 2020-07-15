package com.holidaydrills.lambdaexpressions;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaExpressions {

    public int calculateTwoValues(int valueOne, int valueTwo, FancyCalculator fancyCalculator) {
        return fancyCalculator.calculateTwoValues(valueOne, valueTwo);
    }

    public int makeSum() {
        FancyCalculator sumCalculator = (a,b) -> a + b;
        return calculateTwoValues(5, 7, sumCalculator);
    }

    public int makeProduct() {
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

    public Integer calculateTwoValuesWithBiFunction(int valueOne, int valueTwo, BiFunction<Integer, Integer, Integer> myFancyFunction) {
        return myFancyFunction.apply(valueOne, valueTwo);
    }

    public Integer makeProductWithBiFunction() {
        return calculateTwoValuesWithBiFunction(5, 7, (a,b) -> a * b);
    }

    public void testConsumer(String someone, Consumer<String> consumerFunction) {
        consumerFunction.accept(someone);
    }

    public void printSomethingNice() {
        Consumer<String> myConsumer = inputString -> System.out.println(String.format("%s is my best friend", inputString));
        // Will print "Franky is my best friend"
        testConsumer("Franky", myConsumer);

        // Will print "Hey Franky, do you want some ice cream?"
        testConsumer("do you want some ice cream?", inputString -> System.out.println(String.format("Hey Franky, %s", inputString)));
    }

}
