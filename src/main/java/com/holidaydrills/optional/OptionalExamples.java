package com.holidaydrills.optional;

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

}
