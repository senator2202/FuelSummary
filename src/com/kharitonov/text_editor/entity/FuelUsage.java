package com.kharitonov.text_editor.entity;

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
}
