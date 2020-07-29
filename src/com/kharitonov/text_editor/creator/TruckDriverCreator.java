package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.TruckDriver;

public class TruckDriverCreator {
    TruckDriver create(String driverId, String driverName) {
        int id = Integer.parseInt(driverId);
        return new TruckDriver(id, driverName);
    }
}
