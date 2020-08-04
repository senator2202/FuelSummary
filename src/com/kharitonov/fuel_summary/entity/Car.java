package com.kharitonov.fuel_summary.entity;

import com.kharitonov.fuel_summary.type.CarType;
import com.kharitonov.fuel_summary.type.FuelType;

import java.util.Objects;

public class Car {
    private final String carNumber;
    private final int garageNumber;
    private final int modelCode;
    private final FuelType fuelType;
    private CarType carType;
    private boolean isUtility;

    public Car(String carNumber, int garageNumber, int modelCode,
               FuelType fuelType, CarType carType, boolean isUtility) {
        this.carNumber = carNumber;
        this.garageNumber = garageNumber;
        this.modelCode = modelCode;
        this.fuelType = fuelType;
        this.carType = carType;
        this.isUtility=isUtility;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getGarageNumber() {
        return garageNumber;
    }

    public int getModelCode() {
        return modelCode;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public boolean isUtility() {
        return isUtility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (garageNumber != car.garageNumber) return false;
        if (modelCode != car.modelCode) return false;
        if (!Objects.equals(carNumber, car.carNumber))
            return false;
        return fuelType == car.fuelType;
    }

    @Override
    public int hashCode() {
        int result = carNumber != null ? carNumber.hashCode() : 0;
        result = 31 * result + garageNumber;
        result = 31 * result + modelCode;
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        return result;
    }
}
