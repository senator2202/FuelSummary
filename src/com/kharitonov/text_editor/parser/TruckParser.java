package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.entity.Truck;

public class TruckParser {
    public static Truck parse(String carNumber, String garageNumber, String modelCode) {
        return new Truck(carNumber,
                Integer.parseInt(garageNumber),
                Integer.parseInt(modelCode));
    }
}
