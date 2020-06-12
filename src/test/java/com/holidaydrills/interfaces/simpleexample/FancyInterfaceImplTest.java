package com.holidaydrills.interfaces.simpleexample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FancyInterfaceImplTest {

    FancyInterfaceImpl cut = new FancyInterfaceImpl();

    @Test
    public void test_default_method() {
        assertEquals("Hi there", cut.sayHello());
        assertEquals("Goodbye my friend!", cut.sayGoodBye());
    }

    @Test
    public void test_default_method_overridden() {
        assertEquals("Hello all! How are you?", cut.sayHelloAgain());
    }

    @Test
    public void test_static_interface_method() {
        String expected = "This is a Fancy interface which provides methods to say hello and to say goodbye:)";
        assertEquals(expected, cut.getFancyInterfaceInfo());
        // Test directly on the interface
        assertEquals(expected, FancyInterface.giveMeTheDescriptionOfThisInterface());
    }
}