package com.holidaydrills.interfaces.webshopexample;

public interface FormValidatorFIN extends FormValidator {

    // The FormValidator implementation seems not to be fitting. So here we provide another default implementation
    // which fits our needs better.
    default boolean validateName(String name) {
        String regex = "\\p{L}";
        return name.matches(regex);
    }

    // We want the implementing classes to come up with an own implementation of validateAddress instead of using the
    // default implementation provided by FormValidator. By declaring it as an abstract method we force all implementing
    // classes to do so.
    boolean validateAddress(String address);

}
