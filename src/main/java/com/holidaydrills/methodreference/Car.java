package com.holidaydrills.methodreference;

import java.time.LocalDate;
import java.util.UUID;

public class Car {

    private UUID id;
    private String producerName;
    private String modelName;
    private LocalDate releaseDate;
    private int horsePower;

    public Car(String producerName, String modelName, LocalDate releaseYear, int horsePower) {
        this.id = UUID.randomUUID();
        this.producerName = producerName;
        this.modelName = modelName;
        this.releaseDate = releaseYear;
        this.horsePower = horsePower;
    }

    public Car(String modelName) {
        this.id = UUID.randomUUID();
        this.modelName = modelName;
    }

    public static int compareByReleaseDate(Car a, Car b) {
        return a.getReleaseDate().compareTo(b.getReleaseDate());
    }

    public String getTechnicalDescription() {
        return String.format("Producer: %s | Model: %s | Horse Power: %s",
                producerName, modelName, horsePower);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return car.id.equals(this.id);
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
