package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.entity.FuelBallance;

public class FuelBallanceParser {
    static FuelBallance parse(String fuelStart,
                              String receivedFuel,
                              String receivedFuelOfficial,
                              String returnedFuel,
                              String returnedFuelOfficial,
                              String fuelEnd) {
        double start = Double.parseDouble(fuelStart);
        double end = Double.parseDouble(fuelEnd);
        double received = Double.parseDouble(receivedFuel);
        double receivedOfficial = Double.parseDouble(receivedFuelOfficial);
        double returned = Double.parseDouble(returnedFuel);
        double returnedOfficial = Double.parseDouble(returnedFuelOfficial);
        return new FuelBallance(start, received, receivedOfficial,
                returned, returnedOfficial, end);
    }
}
