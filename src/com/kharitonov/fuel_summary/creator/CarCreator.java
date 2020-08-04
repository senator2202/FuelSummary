package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.CarParkInformation;
import com.kharitonov.fuel_summary.entity.Car;

public class CarCreator {
    Car create(String carNumber, String garageNumber, String modelCode) {
        int number = Integer.parseInt(garageNumber);
        return new Car(carNumber,
                number,
                Integer.parseInt(modelCode),
                CarParkInformation.getFuelType(number),
                CarParkInformation.getCarType(number),
                CarParkInformation.isUtilityTruck(number));
    }
}
