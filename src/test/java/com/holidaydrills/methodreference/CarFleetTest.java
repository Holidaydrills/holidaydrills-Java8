package com.holidaydrills.methodreference;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

    private Car car1 = new Car("BMW", "2 Series", LocalDate.of(2014, 1, 1), 140);
    private Car car2 = new Car("BMW", "3 Series", LocalDate.of(2019, 10, 1), 185);
    private Car car3 = new Car("Fiat", "Punto", LocalDate.of(2013, 3, 1), 80);
    private Car car4 = new Car("Seat", "Leon", LocalDate.of(2017, 7, 1), 150);
    private List<Car> testData = Arrays.asList(car1, car2, car3, car4);;

    private CarFleet cut = new CarFleet(testData);

    @Test
    void getCarsSortedByReleaseDate() {
        List<Car> result = cut.getCarsSortedByReleaseDate();

        assertEquals(car3.getId(), result.get(0).getId());
        assertEquals(car1.getId(), result.get(1).getId());
        assertEquals(car4.getId(), result.get(2).getId());
        assertEquals(car2.getId(), result.get(3).getId());
    }

    @Test
    void getCarsSortedByModelName() {
        List<Car> result = cut.getCarsSortedByModelName();

        assertEquals(car1.getModelName(), result.get(0).getModelName());
        assertEquals(car2.getModelName(), result.get(1).getModelName());
        assertEquals(car4.getModelName(), result.get(2).getModelName());
        assertEquals(car3.getModelName(), result.get(3).getModelName());
    }

    @Test
    void getAllAvailableModelNames() {
        List<String> result = cut.getAllAvailableModelNames();

        assertTrue(result.contains("2 Series"));
        assertTrue(result.contains("3 Series"));
        assertTrue(result.contains("Punto"));
        assertTrue(result.contains("Leon"));
    }

    @Test
    void addNewCars() {
        List<String> newModelNames = Arrays.asList("Galaxy", "Cayenne");

        cut.addNewCars(newModelNames);

        assertEquals(6, cut.getCars().size());
    }

}