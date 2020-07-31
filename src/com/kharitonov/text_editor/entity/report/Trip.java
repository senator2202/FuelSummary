package com.kharitonov.text_editor.entity.report;

import com.kharitonov.text_editor.entity.fuel.FuelUsage;
import com.kharitonov.text_editor.entity.bill.OfficialBill;
import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.entity.bill.WayBill;

public class Trip extends ReportContext {
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

    private Trip(int reportPosition) {
        super(reportPosition);
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
        private int reportPosition;
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

        public TripBuilder withReportPosition(int reportPosition) {
            this.reportPosition = reportPosition;
            return this;
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
            Trip trip = new Trip(reportPosition);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        if (Double.compare(trip.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != trip.cargoTraffic) return false;
        if (Double.compare(trip.fuelStart, fuelStart) != 0) return false;
        if (ridersNumber != trip.ridersNumber) return false;
        if (Double.compare(trip.fuelEnd, fuelEnd) != 0) return false;
        if (Double.compare(trip.fuelEconomy, fuelEconomy) != 0)
            return false;
        if (date != null ? !date.equals(trip.date) : trip.date != null)
            return false;
        if (wayBill != null ? !wayBill.equals(trip.wayBill) : trip.wayBill != null)
            return false;
        if (driver != null ? !driver.equals(trip.driver) : trip.driver != null)
            return false;
        if (officialBill != null ? !officialBill.equals(trip.officialBill) : trip.officialBill != null)
            return false;
        return fuelUsage != null ? fuelUsage.equals(trip.fuelUsage) : trip.fuelUsage == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        result = 31 * result + (wayBill != null ? wayBill.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + (officialBill != null ? officialBill.hashCode() : 0);
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        temp = Double.doubleToLongBits(fuelStart);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ridersNumber;
        temp = Double.doubleToLongBits(fuelEnd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        temp = Double.doubleToLongBits(fuelEconomy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
