package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.CarParkInformation;
import com.kharitonov.fuel_summary.entity.vehicle.Car;

public class CarCreator {
    Car create(String garageNumber) {
        int number = Integer.parseInt(garageNumber);
        return CarParkInformation.getCar(number);
    }
}
