package com.holidaydrills.methodreference;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car a, Car b) {
        return a.getModelName().compareTo(b.getModelName());
    }
}
