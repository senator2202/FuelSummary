package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.TruckDriver;

public class TruckDriverParser {

    public static TruckDriver parse(String driverId, String driverName) {
        int id = 0;
        try {
            id = Integer.parseInt(driverId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return new TruckDriver(id, driverName);
    }
}
