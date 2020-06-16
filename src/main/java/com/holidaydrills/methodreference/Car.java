package com.holidaydrills.methodreference;

import java.util.Date;

public class Car {

    private String producerName;
    private String modelName;
    private Date releaseDate;
    private int horsePower;

    public Car(String producerName, String modelName, Date releaseYear, int horsePower) {
        this.producerName = producerName;
        this.modelName = modelName;
        this.releaseDate = releaseYear;
        this.horsePower = horsePower;
    }

    public Car(String modelName) {
        this.modelName = modelName;
    }

    public static int compareByReleaseDate(Car a, Car b) {
        return a.getReleaseDate().compareTo(b.getReleaseDate());
    }

    public String getTechnicalDescription() {
        return String.format("Producer: %s | Model: %s | Horse Power: %s",
                producerName, modelName, horsePower);
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
