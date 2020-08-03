package com.kharitonov.fuel_summary.type;

public enum FuelType {
    AI_92("БЕНЗИН АИ-92"),
    AI_95("БЕНЗИН АИ-95"),
    DIESEL("ДИЗТОПЛИВО");

    private final String stringValue;

    FuelType(String stringValue) {
        this.stringValue = stringValue;
    }

    public static FuelType getFuelType(String value) {
        FuelType fuelType = null;
        for (FuelType type : FuelType.values()) {
            if (type.stringValue.equals(value)) {
                fuelType = type;
            }
        }
        return fuelType;
    }

    public String getStringValue() {
        return stringValue;
    }
}
