package com.kharitonov.fuel_summary.entity.bill;

public class WayBill {
    private final int id;
    private final int pack;
    private final double fuelReceived;
    private final double fuelReturned;

    public WayBill(int id, int pack, double fuelReceived, double fuelReturned) {
        this.id = id;
        this.pack = pack;
        this.fuelReceived = fuelReceived;
        this.fuelReturned = fuelReturned;
    }

    public int getId() {
        return id;
    }

    public int getPack() {
        return pack;
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
        WayBill wayBill = (WayBill) o;
        if (id != wayBill.id) return false;
        if (pack != wayBill.pack) return false;
        if (Double.compare(wayBill.fuelReceived, fuelReceived) != 0)
            return false;
        return Double.compare(wayBill.fuelReturned, fuelReturned) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + pack;
        temp = Double.doubleToLongBits(fuelReceived);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelReturned);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
