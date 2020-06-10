package com.holidaydrills.interfaces.webshopexample;

public class FormValidatorFINImpl implements FormValidatorFIN {

    // We have to implement the validateAddress method as it was declared as an abstract method in FormValidatorFIN
    // (even if it has a default implementation in the FormValidator interface)
    @Override
    public boolean validateAddress(String address) {
        return false;
    }

    // We don't implement the validateEmail method as the default implementation in FormValidator fits our needs.

    // We don't implement the validateName method as the default implementation in FormValidatorFIN fits our needs.

    // We don't implement the validateAdditionalInformation method as the default implementation in FormValidator fits
    // our needs
}
