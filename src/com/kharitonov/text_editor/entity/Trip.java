package com.kharitonov.text_editor.entity;

public class Trip {
    private String date;
    private WayBill wayBill;
    private TruckDriver driver;
    private OfficialBill officialBill;
    private double kilometrage;
    private int cargoTraffic;
    private double fuelStart;
    private int ridersNumber;
    private double fuelEnd;
    private FuelUsage fuelUsage;
    private double fuelEconomy;

    private Trip() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WayBill getWayBill() {
        return wayBill;
    }

    public void setWayBill(WayBill wayBill) {
        this.wayBill = wayBill;
    }

    public TruckDriver getDriver() {
        return driver;
    }

    public void setDriver(TruckDriver driver) {
        this.driver = driver;
    }

    public OfficialBill getOfficialBill() {
        return officialBill;
    }

    public void setOfficialBill(OfficialBill officialBill) {
        this.officialBill = officialBill;
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

    public double getFuelStart() {
        return fuelStart;
    }

    public void setFuelStart(double fuelStart) {
        this.fuelStart = fuelStart;
    }

    public int getRidersNumber() {
        return ridersNumber;
    }

    public void setRidersNumber(int ridersNumber) {
        this.ridersNumber = ridersNumber;
    }

    public double getFuelEnd() {
        return fuelEnd;
    }

    public void setFuelEnd(double fuelEnd) {
        this.fuelEnd = fuelEnd;
    }

    public FuelUsage getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(FuelUsage fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public static final class TripBuilder {
        private String date;
        private WayBill wayBill;
        private TruckDriver driver;
        private OfficialBill officialBill;
        private double kilometrage;
        private int cargoTraffic;
        private double fuelStart;
        private int ridersNumber;
        private double fuelEnd;
        private FuelUsage fuelUsage;
        private double fuelEconomy;

        private TripBuilder() {
        }

        public static TripBuilder aTrip() {
            return new TripBuilder();
        }

        public TripBuilder withDate(String date) {
            this.date = date;
            return this;
        }

        public TripBuilder withWayBill(WayBill wayBill) {
            this.wayBill = wayBill;
            return this;
        }

        public TripBuilder withDriver(TruckDriver driver) {
            this.driver = driver;
            return this;
        }

        public TripBuilder withOfficialBill(OfficialBill officialBill) {
            this.officialBill = officialBill;
            return this;
        }

        public TripBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public TripBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public TripBuilder withFuelStart(double fuelStart) {
            this.fuelStart = fuelStart;
            return this;
        }

        public TripBuilder withRidersNumber(int ridersNumber) {
            this.ridersNumber = ridersNumber;
            return this;
        }

        public TripBuilder withFuelEnd(double fuelEnd) {
            this.fuelEnd = fuelEnd;
            return this;
        }

        public TripBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public TripBuilder withFuelEconomy(double fuelEconomy) {
            this.fuelEconomy = fuelEconomy;
            return this;
        }

        public Trip build() {
            Trip trip = new Trip();
            trip.setDate(date);
            trip.setWayBill(wayBill);
            trip.setDriver(driver);
            trip.setOfficialBill(officialBill);
            trip.setKilometrage(kilometrage);
            trip.setCargoTraffic(cargoTraffic);
            trip.setFuelStart(fuelStart);
            trip.setRidersNumber(ridersNumber);
            trip.setFuelEnd(fuelEnd);
            trip.setFuelUsage(fuelUsage);
            trip.setFuelEconomy(fuelEconomy);
            return trip;
        }
    }
}
