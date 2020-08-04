package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.CarDriver;

public class CarDriverCreator {
    CarDriver create(String driverId, String driverName) {
        int id = Integer.parseInt(driverId);
        return new CarDriver(id, driverName);
    }
}
