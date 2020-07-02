package com.holidaydrills.optional;

import java.util.Optional;

public class Customer {

    private String firstName;
    private Optional<String> lastName;
    private Address address;

    public Customer(String firstName, Optional<String> lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, Optional<String> lastName, String country, String city, String street, String houseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(country, city, street, houseNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    class Address {

        public Address(String country, String city, String street, String houseNumber) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
        }

        private String country;
        private String city;
        private String street;
        private String houseNumber;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }
    }

}
