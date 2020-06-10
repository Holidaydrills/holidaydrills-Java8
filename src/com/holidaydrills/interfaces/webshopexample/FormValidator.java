package com.holidaydrills.interfaces.webshopexample;


interface FormValidator {

    static String errorMessageForField(String fieldName) {
        return String.format("The %s field is not valid. Please check your input and try it again", fieldName);
    }

    default boolean validateEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    default boolean validateName(String name) {
        if(name.length() > 30) {
            return false;
        }
        return true;
    }

    default boolean validateAddress(String address) {
        if(address.length() > 100) {
            return false;
        }
        return true;
    }

    default boolean validateAdditionalInformation(String additionalInformation) {
        if(additionalInformation.length() > 200) {
            return false;
        }
        return true;
    }

}