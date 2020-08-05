package com.kharitonov.fuel_summary.entity.vehicle;

import com.kharitonov.fuel_summary.type.FuelType;

public class TrailerTruck extends Car {
    private final Trailer trailer;

    public TrailerTruck(String carNumber, int garageNumber, int modelCode,
                        FuelType fuelType, Trailer trailer) {
        super(carNumber, garageNumber, modelCode, fuelType);
        this.trailer = trailer;
    }

    public Trailer getTrailer() {
        return trailer;
    }
}
