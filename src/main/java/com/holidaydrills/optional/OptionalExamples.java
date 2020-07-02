package com.holidaydrills.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {

    public Optional<String> getEmptyOptional() {
        Optional<String> optional = Optional.empty();
        return optional;
    }

    public Optional<String> getOptionalContainingObject(String aString) {
        Optional<String> optional = Optional.of(aString);
        return optional;
    }

    public Optional<String> getPotentiallyEmptyOptional(String aStringThatIsPotentiallyNull) {
        Optional<String> optional = Optional.ofNullable(aStringThatIsPotentiallyNull);
        return optional;
    }

    public String unpackOptionalWithGet(Optional<String> optional) {
        return optional.get();
    }

    public String unpackOptionalWithOrElse(Optional<String> optional) {
        return optional.orElse("Some Standard String");
    }

    public String unpackOptionalWithOrElseGet(Optional<String> optional) {
        return optional.orElseGet(() -> {
            // Add here some fancy logic here
            String a = "Hello";
            String b = "there!";
            String result = String.format("This is some String computed with a complex logic: %s %s", a, b);
            return result;
        });
    }

    public String unpackOptionalWithOrElseThrow(Optional<String> optional) {
        return optional.orElseThrow(() -> new IllegalArgumentException("Please provide a non null value"));
    }

    public boolean checkIfValueIsPresent(Optional<String> optional) {
        return optional.isPresent();
    }

    public boolean checkIfTwoOptionalValuesAreEqual(Optional<String> optional1, Optional<String> optional2) {
        return optional1.equals(optional2);
    }

    public String avoidNullPointerWithoutOptionals(Customer customer) {
        if (customer != null && customer.getAddress() != null && customer.getAddress().getCountry() != null) {
            Customer.Address address = customer.getAddress();
            if (address != null) {
                String country = address.getCountry();
                if (country != null) {
                    return country;
                }
            }
        }

        //Or
        /*
        if(customer != null
                && customer.getAddress() != null
                && customer.getAddress().getCountry() != null) {
            String country = customer.getAddress().getCountry();
            return country;
        }*/
        return "Country is null";
    }

    public String avoidNullPointerWithOptionals(Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customer);
        String country = customerOptional
                .map(Customer::getAddress)
                .map(Customer.Address::getCountry)
                .orElse("Country is null");
        return country;
    }

    public String useMapOnNonOptionalField(Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customer);
        Optional<String> firstNameOptional = customerOptional.map(Customer::getFirstName);
        String firstName = firstNameOptional.orElse("First name is not available");
        return firstName;
    }

    public String useMapOnOptionalField(Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customer);
        Optional<Optional<String>> lastNameOptionalOfOptional = customerOptional.map(Customer::getLastName);
        Optional<String> lastNameOptional = lastNameOptionalOfOptional.get();
        String lastName = lastNameOptional.orElse("Last name is not available");
        return lastName;
    }

    public String useFlatMapOnOptionalField(Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customer);
        Optional<String> lastNameOptional = customerOptional.flatMap(Customer::getLastName);
        String lastName = lastNameOptional.orElse("Last name is not available");
        return lastName;
    }
}
