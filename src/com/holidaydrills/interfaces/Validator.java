package com.holidaydrills.interfaces;


interface Validator {

    /*
    Email validation should be the same across all formatters implementing the Formatter interface.
    The static interface method ensures, that implementing classes cannot override the method.
     */
    static boolean validateEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}