package com.kharitonov.fuel_summary.entity.vehicle;

public class WheelUnit {
    protected final String unitNumber;
    protected final int garageNumber;
    protected final int modelCode;

    public WheelUnit(String stateNumber, int garageNumber, int modelCode) {
        this.unitNumber = stateNumber;
        this.garageNumber = garageNumber;
        this.modelCode = modelCode;
    }

    public String getStateNumber() {
        return unitNumber;
    }

    public int getGarageNumber() {
        return garageNumber;
    }

    public int getModelCode() {
        return modelCode;
    }
}
