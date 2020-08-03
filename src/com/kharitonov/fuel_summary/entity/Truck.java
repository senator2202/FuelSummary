package com.kharitonov.fuel_summary.entity;

import com.kharitonov.fuel_summary.type.FuelType;

import java.util.Objects;

public class Truck {
    private final String carNumber;
    private final int garageNumber;
    private final int modelCode;
    private final FuelType fuelType;

    public Truck(String carNumber, int garageNumber, int modelCode,
                 FuelType fuelType) {
        this.carNumber = carNumber;
        this.garageNumber = garageNumber;
        this.modelCode = modelCode;
        this.fuelType = fuelType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        if (garageNumber != truck.garageNumber) return false;
        if (modelCode != truck.modelCode) return false;
        if (!Objects.equals(carNumber, truck.carNumber))
            return false;
        return fuelType == truck.fuelType;
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
