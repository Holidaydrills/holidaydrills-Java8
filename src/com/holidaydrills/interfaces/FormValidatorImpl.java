package com.holidaydrills.interfaces;

public class FormValidatorImpl implements Validator {

    /*
    The default implementation in the Validator interface defines the form field for additional information as invalid
    if the input is longer than 200 characters.
    In our implementation we want to be this kind of input field only valid if it is max 100 characters.
    */
    @Override
    public boolean validateAdditionalInformation(String additionalInformation) {
        if(additionalInformation.length() > 100) {
            return false;
        }
        return true;
    }

}
