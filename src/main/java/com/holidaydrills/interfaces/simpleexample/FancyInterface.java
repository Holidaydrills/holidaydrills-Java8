package com.holidaydrills.interfaces.simpleexample;

public interface FancyInterface {

    default String sayHello() {
        return "Hi there";
    }

    default String sayHelloAgain() {
        return "Hi there";
    }

}
