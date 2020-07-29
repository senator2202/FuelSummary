package com.kharitonov.text_editor.entity;

public class FuelBalance {
    private final double fuelStart;
    private final double receivedFuel;
    private final double receivedFuelOfficial;
    private final double returnedFuel;
    private final double returnedFuelOfficial;
    private final double fuelEnd;

    public FuelBalance(double fuelStart,
                       double receivedFuel,
                       double receivedFuelOfficial,
                       double returnedFuel,
                       double returnedFuelOfficial,
                       double fuelEnd) {
        this.fuelStart = fuelStart;
        this.receivedFuel = receivedFuel;
        this.receivedFuelOfficial = receivedFuelOfficial;
        this.returnedFuel = returnedFuel;
        this.returnedFuelOfficial = returnedFuelOfficial;
        this.fuelEnd = fuelEnd;
    }

    public double getFuelStart() {
        return fuelStart;
    }

    public double getReceivedFuel() {
        return receivedFuel;
    }

    public double getReceivedFuelOfficial() {
        return receivedFuelOfficial;
    }

    public double getReturnedFuel() {
        return returnedFuel;
    }

    public double getReturnedFuelOfficial() {
        return returnedFuelOfficial;
    }

    public double getFuelEnd() {
        return fuelEnd;
    }
}
