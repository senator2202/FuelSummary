package com.kharitonov.text_editor.entity;

public class TruckDriver {
    private final int id;
    private final String name;

    public TruckDriver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
