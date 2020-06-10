package com.holidaydrills.interfaces.webshopexample;

public class WebShopCheckout {

    private FormValidatorFINImpl formValidator;

    public WebShopCheckout(FormValidatorFINImpl formValidator) {
        this.formValidator = formValidator;
    }

/*    default boolean validateEmail(String email) {
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
    }*/

    public String doCheckout(String email, String name, String address, String additionalInformation) {
        String invalidFieldName = validateForm(email, name, address, additionalInformation);
        if (invalidFieldName.isEmpty()) {
            return "Successfully checked out.";
        }
        return FormValidator.errorMessageForField(invalidFieldName);
    }

    private String validateForm(String email, String name, String address, String additionalInformation) {
        String invalidFieldName = "";
        if(!formValidator.validateEmail(email)) {
            invalidFieldName = "email";
        } else if(!formValidator.validateEmail(name)) {
            invalidFieldName = "name";
        } else if(!formValidator.validateEmail(address)) {
            invalidFieldName = "address";
        } else if(!formValidator.validateEmail(additionalInformation)) {
            invalidFieldName = "additional information";
        }
        return invalidFieldName;
    }

}
