package com.kharitonov.fuel_summary.entity.report;

import com.kharitonov.fuel_summary.entity.Truck;
import com.kharitonov.fuel_summary.entity.TruckDriver;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;

import java.util.Objects;

public class TruckDriverSummary {
    private TruckDriver driver;
    private Truck truck;
    private double kilometrage;
    private int cargoTraffic;
    private double fuelReceived;
    private FuelUsage fuelUsage;
    private double economy;

    private TruckDriverSummary() {
    }

    public TruckDriver getDriver() {
        return driver;
    }

    public void setDriver(TruckDriver driver) {
        this.driver = driver;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
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
        TruckDriverSummary that = (TruckDriverSummary) o;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (Double.compare(that.fuelReceived, fuelReceived) != 0)
            return false;
        if (Double.compare(that.economy, economy) != 0) return false;
        if (!Objects.equals(driver, that.driver))
            return false;
        if (!Objects.equals(truck, that.truck))
            return false;
        return Objects.equals(fuelUsage, that.fuelUsage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = driver != null ? driver.hashCode() : 0;
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
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

    public static final class TruckDriverSummaryBuilder {
        private TruckDriver driver;
        private Truck truck;
        private double kilometrage;
        private int cargoTraffic;
        private double fuelReceived;
        private FuelUsage fuelUsage;
        private double economy;

        private TruckDriverSummaryBuilder() {
        }

        public static TruckDriverSummaryBuilder aTruckDriverSummary() {
            return new TruckDriverSummaryBuilder();
        }

        public TruckDriverSummaryBuilder withDriver(TruckDriver driver) {
            this.driver = driver;
            return this;
        }

        public TruckDriverSummaryBuilder withTruck(Truck truck) {
            this.truck = truck;
            return this;
        }

        public TruckDriverSummaryBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public TruckDriverSummaryBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public TruckDriverSummaryBuilder withFuelReceived(double fuelReceived) {
            this.fuelReceived = fuelReceived;
            return this;
        }

        public TruckDriverSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public TruckDriverSummaryBuilder withEconomy(double economy) {
            this.economy = economy;
            return this;
        }

        public TruckDriverSummary build() {
            TruckDriverSummary truckDriverSummary = new TruckDriverSummary();
            truckDriverSummary.setDriver(driver);
            truckDriverSummary.setTruck(truck);
            truckDriverSummary.setKilometrage(kilometrage);
            truckDriverSummary.setCargoTraffic(cargoTraffic);
            truckDriverSummary.setFuelReceived(fuelReceived);
            truckDriverSummary.setFuelUsage(fuelUsage);
            truckDriverSummary.setEconomy(economy);
            return truckDriverSummary;
        }
    }
}
