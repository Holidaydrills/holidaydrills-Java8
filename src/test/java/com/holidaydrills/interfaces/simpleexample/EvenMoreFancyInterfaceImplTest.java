package com.holidaydrills.interfaces.simpleexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenMoreFancyInterfaceImplTest {

    @Test
    public void test_default_implementation_which_is_not_overridden() {
        EvenMoreFancyInterfaceImpl cut = new EvenMoreFancyInterfaceImpl();
        assertEquals("Hi there", cut.sayHello());
    }

    @Test
    public void test_default_implementation_which_is_overridden_with_new_default_implementation() {
        EvenMoreFancyInterfaceImpl cut = new EvenMoreFancyInterfaceImpl();
        assertEquals("I want to say hello again", cut.sayHelloAgain());
    }

    @Test
    public void test_default_implementation_which_is_overridden_with_abstract_method() {
        EvenMoreFancyInterfaceImpl cut = new EvenMoreFancyInterfaceImpl();
        assertEquals("See you in a while, crocodile!", cut.sayGoodBye());
    }

}