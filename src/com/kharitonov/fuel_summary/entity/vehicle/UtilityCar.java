package com.kharitonov.fuel_summary.entity.vehicle;

import com.kharitonov.fuel_summary.type.FuelType;

public class UtilityCar extends Car {
    public UtilityCar(String carNumber, int garageNumber, int modelCode,
                      FuelType fuelType) {
        super(carNumber, garageNumber, modelCode, fuelType);
    }
}
