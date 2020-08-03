package com.kharitonov.fuel_summary.entity.bill;

public class OfficialBill {
    private final int id;
    private final double fuelReceived;
    private final double fuelReturned;

    public OfficialBill(int id, double fuelReceived, double fuelReturned) {
        this.id = id;
        this.fuelReceived = fuelReceived;
        this.fuelReturned = fuelReturned;
    }

    public int getId() {
        return id;
    }

    public double getFuelReceived() {
        return fuelReceived;
    }

    public double getFuelReturned() {
        return fuelReturned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficialBill that = (OfficialBill) o;
        if (id != that.id) return false;
        if (Double.compare(that.fuelReceived, fuelReceived) != 0)
            return false;
        return Double.compare(that.fuelReturned, fuelReturned) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(fuelReceived);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelReturned);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
