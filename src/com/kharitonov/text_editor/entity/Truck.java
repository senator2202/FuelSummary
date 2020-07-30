package com.kharitonov.text_editor.entity;

import com.kharitonov.text_editor.type.FuelType;

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
}
