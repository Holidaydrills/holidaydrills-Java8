package com.holidaydrills.interfaces.simpleexample;

public class FancyInterfaceImpl implements FancyInterface {
    // sayHello() is not implemented here. Still it can be called on an instance of FancyInterfaceImpl

    // sayHelloAgain is overridden and will return now "Hello all! How are you?" instead of "Hi there"
    @Override
    public String sayHelloAgain() {
        return "Hello all! How are you?";
    }

    public String getFancyInterfaceInfo() {
        return FancyInterface.giveMeTheDescriptionOfThisInterface();
    }
}

class AnotherClass {

    public void checkFancyInterfaceImpl() {
        FancyInterfaceImpl fancyInterfaceImplementation = new FancyInterfaceImpl();
        System.out.println(fancyInterfaceImplementation.sayHello()); // Will print "Hi there"
        System.out.println(fancyInterfaceImplementation.sayHelloAgain()); // Will print "Hello all! How are you?"
    }

}

