package com.kharitonov.text_editor.entity;

public class WayBill {
    private int id;
    private int pack;
    private double fuelReceived;
    private double fuelReturned;

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
}
