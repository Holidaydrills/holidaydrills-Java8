package com.holidaydrills.methodreference;

import java.util.List;
import java.util.stream.Collectors;

public class CarFleet {

    private List<Car> cars;

    public CarFleet(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarsSortedByReleaseDate() {
        cars.sort(Car::compareByReleaseDate);
        return cars;
    }

    public List<Car> getCarsSortedByModelName() {
        CarComparator carComparator = new CarComparator();
        cars.sort(carComparator::compare);
        return cars;
    }

    public List<String> getAllAvailableModelNames() {
        return cars.stream()
                .map(Car::getModelName)
                .collect(Collectors.toList());
    }

    public List<String> getAllAvailableModelNames1() {
        return cars.stream()
                .map(someCar -> someCar.getModelName())
                .collect(Collectors.toList());
    }


    public List<Car> addNewCars(List<String> modelNames) {
        List<Car> newCars = modelNames.stream().map(Car::new).collect(Collectors.toList());
        newCars.addAll(cars);
        this.setCars(newCars);
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
