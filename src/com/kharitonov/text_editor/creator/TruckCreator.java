package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.Truck;
import com.kharitonov.text_editor.type.FuelType;

public class TruckCreator {
    private static final int[] TRUCK_NUMBERS_AI_92 = {10049, 11118};
    private static final int[] TRUCK_NUMBERS_AI_95 = {10014};

    Truck create(String carNumber, String garageNumber, String modelCode) {
        int number = Integer.parseInt(garageNumber);
        return new Truck(carNumber,
                number,
                Integer.parseInt(modelCode),
                defineFuelType(number));
    }

    private FuelType defineFuelType(int garageNumber) {
        FuelType fuelType = FuelType.DIESEL;
        for (int i : TRUCK_NUMBERS_AI_92) {
            if (i == garageNumber) {
                return FuelType.AI_92;
            }
        }
        for (int i : TRUCK_NUMBERS_AI_95) {
            if (i == garageNumber) {
                return FuelType.AI_95;
            }
        }
        return fuelType;
    }
}
