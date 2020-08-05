package com.kharitonov.fuel_summary.entity.vehicle;

import com.kharitonov.fuel_summary.type.FuelType;

public class DumpTruck extends Car {
    public DumpTruck(String carNumber, int garageNumber, int modelCode,
                     FuelType fuelType) {
        super(carNumber, garageNumber, modelCode, fuelType);
    }
}
