package com.kharitonov.text_editor.entity;

import java.util.Map;

public class TruckSummary {

    private int dayFirst;
    private int dayLast;
    private Truck truck;
    private double kilometrage;
    private int cargoTraffic;
    private int ridersNumber;
    private FuelBalance fuelBalance;
    private FuelUsage fuelUsage;
    private Map<TruckDriver,Double> fuelEconomy;

    private TruckSummary() {
    }
    public int getDayFirst() {
        return dayFirst;
    }

    public void setDayFirst(int dayFirst) {
        this.dayFirst = dayFirst;
    }

    public int getDayLast() {
        return dayLast;
    }

    public void setDayLast(int dayLast) {
        this.dayLast = dayLast;
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

    public int getRidersNumber() {
        return ridersNumber;
    }

    public void setRidersNumber(int ridersNumber) {
        this.ridersNumber = ridersNumber;
    }

    public FuelBalance getFuelBalance() {
        return fuelBalance;
    }

    public void setFuelBalance(FuelBalance fuelBalance) {
        this.fuelBalance = fuelBalance;
    }

    public FuelUsage getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(FuelUsage fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public Map<TruckDriver, Double> getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(Map<TruckDriver, Double> fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public static final class TruckSummaryBuilder {
        private int dayFirst;
        private int dayLast;
        private Truck truck;
        private double kilometrage;
        private int cargoTraffic;
        private int ridersNumber;
        private FuelBalance fuelBalance;
        private FuelUsage fuelUsage;
        private Map<TruckDriver, Double> fuelEconomy;

        private TruckSummaryBuilder() {
        }

        public static TruckSummaryBuilder aTruckSummary() {
            return new TruckSummaryBuilder();
        }

        public TruckSummaryBuilder withDayFirst(int dayFirst) {
            this.dayFirst = dayFirst;
            return this;
        }

        public TruckSummaryBuilder withDayLast(int dayLast) {
            this.dayLast = dayLast;
            return this;
        }

        public TruckSummaryBuilder withTruck(Truck truck) {
            this.truck = truck;
            return this;
        }

        public TruckSummaryBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public TruckSummaryBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public TruckSummaryBuilder withRidersNumber(int ridersNumber) {
            this.ridersNumber = ridersNumber;
            return this;
        }

        public TruckSummaryBuilder withFuelBallance(FuelBalance fuelBalance) {
            this.fuelBalance = fuelBalance;
            return this;
        }

        public TruckSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public TruckSummaryBuilder withFuelEconomy(Map<TruckDriver, Double> fuelEconomy) {
            this.fuelEconomy = fuelEconomy;
            return this;
        }

        public TruckSummary build() {
            TruckSummary truckSummary = new TruckSummary();
            truckSummary.setDayFirst(dayFirst);
            truckSummary.setDayLast(dayLast);
            truckSummary.setTruck(truck);
            truckSummary.setKilometrage(kilometrage);
            truckSummary.setCargoTraffic(cargoTraffic);
            truckSummary.setRidersNumber(ridersNumber);
            truckSummary.setFuelBalance(fuelBalance);
            truckSummary.setFuelUsage(fuelUsage);
            truckSummary.setFuelEconomy(fuelEconomy);
            return truckSummary;
        }
    }
}
