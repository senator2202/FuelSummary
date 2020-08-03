package com.kharitonov.fuel_summary.entity.report;

import com.kharitonov.fuel_summary.entity.Truck;
import com.kharitonov.fuel_summary.entity.fuel.FuelBalance;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;

import java.util.List;
import java.util.Objects;

public class TruckSummary extends ReportContext {

    private int dayFirst;
    private int dayLast;
    private Truck truck;
    private double kilometrage;
    private int cargoTraffic;
    private int ridersNumber;
    private FuelBalance fuelBalance;
    private FuelUsage fuelUsage;
    private List<TruckDriverSummary> truckDriverSummaryList;

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

    public List<TruckDriverSummary> getTruckDriverSummaryList() {
        return truckDriverSummaryList;
    }

    public void setTruckDriverSummaryList(List<TruckDriverSummary> truckDriverSummaryList) {
        this.truckDriverSummaryList = truckDriverSummaryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TruckSummary that = (TruckSummary) o;
        if (dayFirst != that.dayFirst) return false;
        if (dayLast != that.dayLast) return false;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (ridersNumber != that.ridersNumber) return false;
        if (!Objects.equals(truck, that.truck))
            return false;
        if (!Objects.equals(fuelBalance, that.fuelBalance))
            return false;
        if (!Objects.equals(fuelUsage, that.fuelUsage))
            return false;
        return Objects.equals(truckDriverSummaryList,
                that.truckDriverSummaryList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + dayFirst;
        result = 31 * result + dayLast;
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        result = 31 * result + ridersNumber;
        result = 31 * result + (fuelBalance != null ? fuelBalance.hashCode() : 0);
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        result = 31 * result + (truckDriverSummaryList != null
                ? truckDriverSummaryList.hashCode()
                : 0);
        return result;
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
        private List<TruckDriverSummary> truckDriverSummaryList;

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

        public TruckSummaryBuilder withFuelBalance(FuelBalance fuelBalance) {
            this.fuelBalance = fuelBalance;
            return this;
        }

        public TruckSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public TruckSummaryBuilder withTruckDriverSummaries(
                List<TruckDriverSummary> truckDriverSummaryList) {
            this.truckDriverSummaryList = truckDriverSummaryList;
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
            truckSummary.setTruckDriverSummaryList(truckDriverSummaryList);
            return truckSummary;
        }
    }
}
