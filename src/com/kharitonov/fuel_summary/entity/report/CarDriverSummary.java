package com.kharitonov.fuel_summary.entity.report;

import com.kharitonov.fuel_summary.entity.vehicle.Car;
import com.kharitonov.fuel_summary.entity.CarDriver;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;

import java.util.Objects;

public class CarDriverSummary {
    private CarDriver driver;
    private Car car;
    private double kilometrage;
    private int cargoTraffic;
    private double fuelReceived;
    private FuelUsage fuelUsage;
    private double economy;

    private CarDriverSummary() {
    }

    public CarDriver getDriver() {
        return driver;
    }

    public void setDriver(CarDriver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getCargoTraffic() {
        return cargoTraffic;
    }

    public void setCargoTraffic(int cargoTraffic) {
        this.cargoTraffic = cargoTraffic;
    }

    public double getFuelReceived() {
        return fuelReceived;
    }

    public void setFuelReceived(double fuelReceived) {
        this.fuelReceived = fuelReceived;
    }

    public FuelUsage getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(FuelUsage fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDriverSummary that = (CarDriverSummary) o;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (Double.compare(that.fuelReceived, fuelReceived) != 0)
            return false;
        if (Double.compare(that.economy, economy) != 0) return false;
        if (!Objects.equals(driver, that.driver))
            return false;
        if (!Objects.equals(car, that.car))
            return false;
        return Objects.equals(fuelUsage, that.fuelUsage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = driver != null ? driver.hashCode() : 0;
        result = 31 * result + (car != null ? car.hashCode() : 0);
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        temp = Double.doubleToLongBits(fuelReceived);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        temp = Double.doubleToLongBits(economy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static final class CarDriverSummaryBuilder {
        private CarDriver driver;
        private Car car;
        private double kilometrage;
        private int cargoTraffic;
        private double fuelReceived;
        private FuelUsage fuelUsage;
        private double economy;

        private CarDriverSummaryBuilder() {
        }

        public static CarDriverSummaryBuilder aTruckDriverSummary() {
            return new CarDriverSummaryBuilder();
        }

        public CarDriverSummaryBuilder withDriver(CarDriver driver) {
            this.driver = driver;
            return this;
        }

        public CarDriverSummaryBuilder withTruck(Car car) {
            this.car = car;
            return this;
        }

        public CarDriverSummaryBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public CarDriverSummaryBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public CarDriverSummaryBuilder withFuelReceived(double fuelReceived) {
            this.fuelReceived = fuelReceived;
            return this;
        }

        public CarDriverSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public CarDriverSummaryBuilder withEconomy(double economy) {
            this.economy = economy;
            return this;
        }

        public CarDriverSummary build() {
            CarDriverSummary carDriverSummary = new CarDriverSummary();
            carDriverSummary.setDriver(driver);
            carDriverSummary.setCar(car);
            carDriverSummary.setKilometrage(kilometrage);
            carDriverSummary.setCargoTraffic(cargoTraffic);
            carDriverSummary.setFuelReceived(fuelReceived);
            carDriverSummary.setFuelUsage(fuelUsage);
            carDriverSummary.setEconomy(economy);
            return carDriverSummary;
        }
    }
}
