package com.kharitonov.text_editor.entity;

public class Truck {
    private final String carNumber;
    private final int garageNumber;
    private final int modelCode;

    public Truck(String carNumber, int garageNumber, int modelCode) {
        this.carNumber = carNumber;
        this.garageNumber = garageNumber;
        this.modelCode = modelCode;
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
}
