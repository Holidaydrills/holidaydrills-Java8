package com.holidaydrills.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExamplesTest {

    OptionalExamples cut = new OptionalExamples();

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
        assertThrows(NullPointerException.class, () -> {
            cut.getOptionalContainingObject(null);
        });
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
}