package com.holidaydrills.interfaces;

public class WebShopCheckout {

    private FormValidatorImpl formValidator;

    public WebShopCheckout(FormValidatorImpl formValidator) {
        this.formValidator = formValidator;
    }

    public String doCheckout(String name, String email, String price, String address) {
        if(validateForm(email)) {
            return "Successfully checked out.";
        }
        return "Form input is not valid. Please check your input and try again.";
    }

    private boolean validateForm(String email) {
        // Note: the validateEmail method is called as a static method
        if(FormValidator.validateEmail(email)) {
            return true;
        }
        return false;
    }

}
