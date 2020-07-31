package com.kharitonov.text_editor.entity.report;

import com.kharitonov.text_editor.entity.fuel.FuelBalance;
import com.kharitonov.text_editor.entity.fuel.FuelUsage;
import com.kharitonov.text_editor.entity.Truck;
import com.kharitonov.text_editor.entity.TruckDriver;

import java.util.Map;

public class TruckSummary extends ReportContext {

    private int dayFirst;
    private int dayLast;
    private Truck truck;
    private double kilometrage;
    private int cargoTraffic;
    private int ridersNumber;
    private FuelBalance fuelBalance;
    private FuelUsage fuelUsage;
    private Map<TruckDriver, Double> fuelEconomy;

    private TruckSummary(int position) {
        super(position);
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
        private int reportPosition;
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

        public TruckSummaryBuilder withReportPosition(int reportPosition) {
            this.reportPosition = reportPosition;
            return this;
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
            TruckSummary truckSummary = new TruckSummary(reportPosition);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckSummary that = (TruckSummary) o;
        if (dayFirst != that.dayFirst) return false;
        if (dayLast != that.dayLast) return false;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (ridersNumber != that.ridersNumber) return false;
        if (truck != null ? !truck.equals(that.truck) : that.truck != null)
            return false;
        if (fuelBalance != null ? !fuelBalance.equals(that.fuelBalance) : that.fuelBalance != null)
            return false;
        if (fuelUsage != null ? !fuelUsage.equals(that.fuelUsage) : that.fuelUsage != null)
            return false;
        return fuelEconomy != null ? fuelEconomy.equals(that.fuelEconomy) : that.fuelEconomy == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dayFirst;
        result = 31 * result + dayLast;
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        result = 31 * result + ridersNumber;
        result = 31 * result + (fuelBalance != null ? fuelBalance.hashCode() : 0);
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        result = 31 * result + (fuelEconomy != null ? fuelEconomy.hashCode() : 0);
        return result;
    }
}
