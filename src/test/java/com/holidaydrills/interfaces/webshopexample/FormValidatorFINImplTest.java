package com.holidaydrills.interfaces.webshopexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormValidatorFINImplTest {

    FormValidatorFINImpl cut = new FormValidatorFINImpl();

    @Test
    public void validateEmail_with_valid_emailAddress() {
        String validEmailAddress = "holidaydrills@gmail.com";
        assertTrue(cut.validateEmail(validEmailAddress));
    }

}