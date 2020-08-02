package com.kharitonov.text_editor.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckDriver driver = (TruckDriver) o;
        if (id != driver.id) return false;
        return Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
