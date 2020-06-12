package com.holidaydrills.interfaces.webshopexample;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface FormValidator {

    static String errorMessageForField(String fieldName) {
        return String.format("The %s field is not valid. Please check your input and try it again", fieldName);
    }

    default boolean validateEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    default boolean validateName(String name) {
        return name.length() <= 30;
    }

    default boolean validateAddress(String address) {
        return address.length() <= 10;
    }

    default boolean validateAdditionalInformation(String additionalInformation) {
        return additionalInformation.length() <= 200;
    }

}