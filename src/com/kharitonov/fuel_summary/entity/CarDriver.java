package com.kharitonov.fuel_summary.entity;

import java.util.Objects;

public class CarDriver {
    private final int id;
    private final String name;

    public CarDriver(int id, String name) {
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
        CarDriver driver = (CarDriver) o;
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
