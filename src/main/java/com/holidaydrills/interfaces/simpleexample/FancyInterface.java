package com.holidaydrills.interfaces.simpleexample;

public interface FancyInterface {

    default String sayHello() {
        return "Hi there";
    }

    default String sayHelloAgain() {
        return "Hi there";
    }

    default String sayGoodBye() {
        return "Goodbye my friend!";
    }

    static String giveMeTheDescriptionOfThisInterface() {
        return "This is a Fancy interface which provides methods to say hello and to say goodbye:)";
    }

}
