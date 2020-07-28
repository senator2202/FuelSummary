package com.kharitonov.text_editor.entity;

public class FuelBallance {
    private double fuelStart;
    private double receivedFuel;
    private double receivedFuelOfficial;
    private double returnedFuel;
    private double returnedFuelOfficial;
    private double fuelEnd;

    public FuelBallance(double fuelStart,
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
