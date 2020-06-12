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

    @Test
    public void validateEmail_with_invalid_emailAddress() {
        String invalidEmailAdress = "holidaydrills@gmail.c";
        assertFalse(cut.validateEmail(invalidEmailAdress));
    }

    @Test
    public void validateName_with_valid_name() {
        String validName = "Ada Lovelace";
        assertTrue(cut.validateName(validName));
    }

    @Test
    public void validateName_with_invalid_name() {
        String invalidName = "Ada Lovelace.";
        assertFalse(cut.validateName(invalidName));
    }

    @Test
    public void validateAddress_with_valid_address() {
        String validAddress = "1640 Riverside Drive, Hill Valley, California";
        assertTrue(cut.validateAddress(validAddress));
    }

    @Test
    public void validateAddress_with_invalid_address() {
        String validAddress = new String(new char[100]);
        assertTrue(cut.validateAddress(validAddress));
    }

    @Test void validateAdditionalInformation_with_valid_additionalInformation_Input() {
        String validAdditionalInformation = "Please gift-wrap the book.";
        assertTrue(cut.validateAdditionalInformation(validAdditionalInformation));
    }

    @Test void validateAdditionalInformation_with_invalid_additionalInformation_Input() {
        String invalidAdditionalInformation = new String(new char[201]);
        assertFalse(cut.validateAdditionalInformation(invalidAdditionalInformation));
    }

}