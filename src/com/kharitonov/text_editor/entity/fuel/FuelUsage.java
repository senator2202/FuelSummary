package com.kharitonov.text_editor.entity.fuel;

public class FuelUsage {
    private final double normalUsage;
    private final double wayBillUsage;

    public FuelUsage(double normalUsage, double wayBillUsage) {
        this.normalUsage = normalUsage;
        this.wayBillUsage = wayBillUsage;
    }

    public double getNormalUsage() {
        return normalUsage;
    }

    public double getWayBillUsage() {
        return wayBillUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelUsage fuelUsage = (FuelUsage) o;
        if (Double.compare(fuelUsage.normalUsage, normalUsage) != 0)
            return false;
        return Double.compare(fuelUsage.wayBillUsage, wayBillUsage) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(normalUsage);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(wayBillUsage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
