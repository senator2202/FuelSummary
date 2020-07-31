package com.kharitonov.text_editor.entity.fuel;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelBalance that = (FuelBalance) o;
        if (Double.compare(that.fuelStart, fuelStart) != 0) return false;
        if (Double.compare(that.receivedFuel, receivedFuel) != 0)
            return false;
        if (Double.compare(that.receivedFuelOfficial, receivedFuelOfficial) != 0)
            return false;
        if (Double.compare(that.returnedFuel, returnedFuel) != 0)
            return false;
        if (Double.compare(that.returnedFuelOfficial, returnedFuelOfficial) != 0)
            return false;
        return Double.compare(that.fuelEnd, fuelEnd) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(fuelStart);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(receivedFuel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(receivedFuelOfficial);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(returnedFuel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(returnedFuelOfficial);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelEnd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
