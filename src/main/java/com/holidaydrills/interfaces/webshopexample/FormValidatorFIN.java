package com.holidaydrills.interfaces.webshopexample;

public interface FormValidatorFIN extends FormValidator {

    // The FormValidator implementation seems not to be fitting. So here we provide another default implementation
    // which fits our needs better.
    @Override
    default boolean validateName(String name) {
        String regex = "^([a-zA-Z]{2,}\\s[a-zA-z]+'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]+)?)";
        return name.matches(regex);
    }

    // We want the implementing classes to come up with an own implementation of validateAddress instead of using the
    // default implementation provided by FormValidator. By declaring it as an abstract method we force all implementing
    // classes to do so.
    @Override
    boolean validateAddress(String address);

}
