package com.kharitonov.fuel_summary.entity.vehicle;

import com.kharitonov.fuel_summary.type.FuelType;

import java.util.Objects;

public class Car extends WheelUnit {
    private final FuelType fuelType;

    public Car(String carNumber, int garageNumber, int modelCode,
               FuelType fuelType) {
        super(carNumber, garageNumber, modelCode);
        this.fuelType = fuelType;
    }



    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (garageNumber != car.garageNumber) return false;
        if (modelCode != car.modelCode) return false;
        if (!Objects.equals(unitNumber, car.unitNumber))
            return false;
        return fuelType == car.fuelType;
    }

    @Override
    public int hashCode() {
        int result = unitNumber != null ? unitNumber.hashCode() : 0;
        result = 31 * result + garageNumber;
        result = 31 * result + modelCode;
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        return result;
    }
}
