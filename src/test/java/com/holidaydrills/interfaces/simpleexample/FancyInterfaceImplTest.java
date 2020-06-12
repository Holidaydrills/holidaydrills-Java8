package com.holidaydrills.interfaces.simpleexample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FancyInterfaceImplTest {
    @Test
    public void test_static_interface_method() {
        FancyInterfaceImpl cut = new FancyInterfaceImpl();
        String expected = "This is a Fancy interface which provides methods to say hello and to say goodbye:)";
        assertEquals(expected, cut.getFancyInterfaceInfo());
        // Test directly on the interface
        assertEquals(expected, FancyInterface.giveMeTheDescriptionOfThisInterface());
    }
}