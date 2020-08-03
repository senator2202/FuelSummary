package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.fuel.FuelBalance;

public class FuelBalanceCreator {
    FuelBalance create(String fuelStart,
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
        return new FuelBalance(start, received, receivedOfficial,
                returned, returnedOfficial, end);
    }
}
