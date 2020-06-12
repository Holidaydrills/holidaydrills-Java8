package com.holidaydrills.interfaces.simpleexample;

public class EvenMoreFancyInterfaceImpl implements EventMoreFancyInterface{

    // The method sayHello() is not implemented here, so the default implementation from FancyInterface is valid

    // The method sayHelloAgain() is not implemented here, so the default implementation from FancyInterface is valid

    // Must be implemented here since EvenMoreFancyInterfaceImpl declares the method as abstract
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

