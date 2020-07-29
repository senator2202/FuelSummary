package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.Truck;

public class TruckCreator {
    Truck create(String carNumber, String garageNumber, String modelCode) {
        return new Truck(carNumber,
                Integer.parseInt(garageNumber),
                Integer.parseInt(modelCode));
    }
}
