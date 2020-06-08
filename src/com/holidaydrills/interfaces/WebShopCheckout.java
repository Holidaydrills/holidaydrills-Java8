package com.holidaydrills.interfaces;

public class WebShopCheckout {

    private FormValidatorImpl formValidator;

    public WebShopCheckout(FormValidatorImpl formValidator) {
        this.formValidator = formValidator;
    }

    public String doCheckout(String email, String additionalInformation) {
        if(validateForm(email, additionalInformation)) {
            return "Successfully checked out.";
        }
        return "Form input is not valid. Please check your input and try again.";
    }

    private boolean validateForm(String email, String additionalInformation) {
        // Note:
        // - the validateEmail method is called as a static method
        // - the additionalInformation input is using the implementation of FormValidatorImpl. If you comment out the
        //   validateAdditionalInformation method in FormValidatorImpl, it will use the default implementation of
        //   FormValidator
        if(FormValidator.validateEmail(email) &&
                formValidator.validateAdditionalInformation(additionalInformation)) {
            return true;
        }
        return false;
    }

}
