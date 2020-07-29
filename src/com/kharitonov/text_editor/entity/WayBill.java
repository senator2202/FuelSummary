package com.kharitonov.text_editor.entity;

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
}
