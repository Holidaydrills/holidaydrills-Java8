package com.holidaydrills.interfaces.simpleexample;

public interface EventMoreFancyInterface extends FancyInterface {

    // The method sayHello() is not overridden here, so the default implementation from FancyInterface is still valid

    // Here the default implementation is overridden by a new default implementation
    @Override
    default String sayHelloAgain() {
        return "I want to say hello again";
    }

    // Here the default implementation is overridden by an abstract method. That means that a class that implements
    // EventMoreFancyInterface has to provide an implementation.
    @Override
    String sayGoodBye();

}
