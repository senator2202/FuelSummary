package com.kharitonov.text_editor.entity;

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
}
