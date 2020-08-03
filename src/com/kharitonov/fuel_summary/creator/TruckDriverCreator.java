package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.TruckDriver;

public class TruckDriverCreator {
    TruckDriver create(String driverId, String driverName) {
        int id = Integer.parseInt(driverId);
        return new TruckDriver(id, driverName);
    }
}
