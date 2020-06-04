package com.holidaydrills.interfaces;


interface Validator {

    /*
    Email validation should be the same across all validators implementing the Validator interface.
    The static interface method ensures, that implementing classes cannot override the method.
     */
    static boolean validateEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    default boolean validateAdditionalInformation(String additionalInformation) {
        if(additionalInformation.length() > 200) {
            return false;
        }
        return true;
    }

}