package com.holidaydrills.interfaces.webshopexample;

public class WebShopCheckout {

    private FormValidatorFINImpl formValidator;

    public WebShopCheckout(FormValidatorFINImpl formValidator) {
        this.formValidator = formValidator;
    }

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
