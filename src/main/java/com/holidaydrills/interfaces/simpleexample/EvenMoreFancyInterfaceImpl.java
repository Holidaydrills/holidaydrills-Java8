package com.holidaydrills.interfaces.simpleexample;

public class EvenMoreFancyInterfaceImpl implements EventMoreFancyInterface{

    @Override
    public String sayGoodBye() {
        return "See you in a while, crocodile!";
    }
}

class YetAnotherClass {

    public void checkEvenMoreFancyInterfaceImpl() {
        EvenMoreFancyInterfaceImpl evenMoreFancyInterfaceImplementation = new EvenMoreFancyInterfaceImpl();
        // Will print "Hi there" provided by FancyInterface
        System.out.println(evenMoreFancyInterfaceImplementation.sayHello());

        // Will print "I want to say hello again" provided by EvenMoreFancyInterface
        System.out.println(evenMoreFancyInterfaceImplementation.sayHelloAgain());

        // Will print "See you in a while, crocodile!" provided by EvenMoreFancyInterfaceImpl
        System.out.println(evenMoreFancyInterfaceImplementation.sayGoodBye());
    }

}

