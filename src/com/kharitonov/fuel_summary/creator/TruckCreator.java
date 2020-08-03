package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.TruckParkInformation;
import com.kharitonov.fuel_summary.entity.Truck;

public class TruckCreator {
    Truck create(String carNumber, String garageNumber, String modelCode) {
        int number = Integer.parseInt(garageNumber);
        return new Truck(carNumber,
                number,
                Integer.parseInt(modelCode),
                TruckParkInformation.getFuelType(number));
    }
}
