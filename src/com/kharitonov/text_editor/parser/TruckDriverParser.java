package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.entity.TruckDriver;

public class TruckDriverParser {

    static TruckDriver parse(String driverId, String driverName) {
        int id = Integer.parseInt(driverId);
        return new TruckDriver(id, driverName);
    }
}
