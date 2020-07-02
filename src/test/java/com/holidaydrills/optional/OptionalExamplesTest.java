package com.holidaydrills.optional;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExamplesTest {

    OptionalExamples cut = new OptionalExamples();
    String expectedString = "Hello there!";
    Optional<String> nonEmptyOptional = Optional.of(expectedString);

    @Test
    void getEmptyOptional() {
        Optional<String> resultOptional = cut.getEmptyOptional();
        String resultString = resultOptional.orElseGet(() -> "String is a null pointer.");

        assertTrue(resultOptional.isEmpty());
        assertEquals("String is a null pointer.", resultString);
    }

    @Test
    void getOptionalContainingObject() {
        String result = cut.getOptionalContainingObject("Hello there").get();
        assertEquals("Hello there", result);
    }

    @Test
    void getOptionalContainingObject_with_null_object() {
        assertThrows(NullPointerException.class, () -> cut.getOptionalContainingObject(null));
    }

    @Test
    void getPotentiallyEmptyOptional() {
        String result = cut.getPotentiallyEmptyOptional("Hello there").get();

        assertEquals("Hello there", result);
    }

    @Test
    void getPotentiallyEmptyOptional_with_null_object() {
        Optional<String> result = cut.getPotentiallyEmptyOptional(null);

        assertTrue(result.isEmpty());
    }

    @Test
    void unpackOptionalWithGet() {
        String result = cut.unpackOptionalWithGet(nonEmptyOptional);

        assertEquals(expectedString, result);
        assertThrows(NoSuchElementException.class, () -> cut.unpackOptionalWithGet(Optional.empty()));
    }

    @Test
    void unpackOptionalWithOrElse() {
        String result = cut.unpackOptionalWithOrElse(nonEmptyOptional);
        assertEquals(expectedString, result);
    }

    @Test
    void unpackOptionalWithOrElse_with_empty_optional() {
        String result = cut.unpackOptionalWithOrElse(Optional.empty());
        assertEquals("Some Standard String", result);
    }

    @Test
    void unpackOptionalWithOrElseGet() {
        String result = cut.unpackOptionalWithOrElseGet(nonEmptyOptional);
        assertEquals(expectedString, result);
    }

    @Test
    void unpackOptionalWithOrElseGet_with_empty_optional() {
        String result = cut.unpackOptionalWithOrElseGet(Optional.empty());
        String expected = "This is some String computed with a complex logic: Hello there!";
        assertEquals(expected, result);
    }

    @Test
    void unpackOptionalWithOrElseThrow() {
        String result = cut.unpackOptionalWithOrElseThrow(nonEmptyOptional);
        assertEquals(expectedString, result);
        assertThrows(IllegalArgumentException.class, () -> cut.unpackOptionalWithOrElseThrow(Optional.empty()));
    }

    @Test
    void checkIfValueIsPresent() {
        assertTrue(cut.checkIfValueIsPresent(nonEmptyOptional));
        assertFalse(cut.checkIfValueIsPresent(Optional.empty()));
    }

    @Test
    void checkIfTwoOptionalValuesAreEqual() {
        Optional optional1 = Optional.of("Hello there!");
        Optional optional2 = Optional.of("Hello there!");
        Optional optional3 = Optional.of("Hi there!");

        assertTrue(cut.checkIfTwoOptionalValuesAreEqual(optional1, optional2));
        assertFalse(cut.checkIfTwoOptionalValuesAreEqual(optional1, optional3));
    }

    @Test
    void avoidNullPointerWithoutOptionals() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"), "England", "London", "Gower Street", "1");

        String result = cut.avoidNullPointerWithoutOptionals(customer);

        assertEquals("England", result);
    }

    @Test
    void avoidNullPointerWithoutOptionals_with_null_country() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"), null, "London", "Gower Street", "1");

        String result = cut.avoidNullPointerWithoutOptionals(customer);

        assertEquals("Country is null", result);
    }

    @Test
    void avoidNullPointerWithoutOptionals_with_null_address() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"));

        String result = cut.avoidNullPointerWithoutOptionals(customer);

        assertEquals("Country is null", result);
    }

    @Test
    void avoidNullPointerWithoutOptionals_with_null_customer() {
        String result = cut.avoidNullPointerWithoutOptionals(null);

        assertEquals("Country is null", result);
    }

    @Test
    void avoidNullPointerWithOptionals_with_null_country() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"), null, "London", "Gower Street", "1");

        String result = cut.avoidNullPointerWithOptionals(customer);

        assertEquals("Country is null", result);
    }

    @Test
    void avoidNullPointerWithOptionals_with_null_address() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"));

        String result = cut.avoidNullPointerWithOptionals(customer);

        assertEquals("Country is null", result);
    }

    @Test
    void avoidNullPointerWithOptionals_with_null_customer() {
        String result = cut.avoidNullPointerWithOptionals(null);

        assertEquals("Country is null", result);
    }

    @Test
    void useMapOnNonOptionalField() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"));

        String result = cut.useMapOnNonOptionalField(customer);

        assertEquals("Ada", result);
    }

    @Test
    void useMapOnOptionalField() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"));

        String result = cut.useMapOnOptionalField(customer);

        assertEquals("Lovelace", result);
    }

    @Test
    void useFlatMapOnOptionalField() {
        Customer customer = new Customer("Ada", Optional.of("Lovelace"));

        String result = cut.useFlatMapOnOptionalField(customer);

        assertEquals("Lovelace", result);
    }
}