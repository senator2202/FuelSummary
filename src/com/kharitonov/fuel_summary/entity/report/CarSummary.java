package com.kharitonov.fuel_summary.entity.report;

import com.kharitonov.fuel_summary.entity.Car;
import com.kharitonov.fuel_summary.entity.fuel.FuelBalance;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;

import java.util.List;
import java.util.Objects;

public class CarSummary extends ReportContext {

    private int dayFirst;
    private int dayLast;
    private Car car;
    private double kilometrage;
    private int cargoTraffic;
    private int ridersNumber;
    private FuelBalance fuelBalance;
    private FuelUsage fuelUsage;
    private List<CarDriverSummary> carDriverSummaryList;

    private CarSummary(int position) {
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

    public List<CarDriverSummary> getCarDriverSummaryList() {
        return carDriverSummaryList;
    }

    public void setCarDriverSummaryList(List<CarDriverSummary> carDriverSummaryList) {
        this.carDriverSummaryList = carDriverSummaryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarSummary that = (CarSummary) o;
        if (dayFirst != that.dayFirst) return false;
        if (dayLast != that.dayLast) return false;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (ridersNumber != that.ridersNumber) return false;
        if (!Objects.equals(car, that.car))
            return false;
        if (!Objects.equals(fuelBalance, that.fuelBalance))
            return false;
        if (!Objects.equals(fuelUsage, that.fuelUsage))
            return false;
        return Objects.equals(carDriverSummaryList,
                that.carDriverSummaryList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + dayFirst;
        result = 31 * result + dayLast;
        result = 31 * result + (car != null ? car.hashCode() : 0);
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        result = 31 * result + ridersNumber;
        result = 31 * result + (fuelBalance != null ? fuelBalance.hashCode() : 0);
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        result = 31 * result + (carDriverSummaryList != null
                ? carDriverSummaryList.hashCode()
                : 0);
        return result;
    }

    public static final class CarSummaryBuilder {
        private int reportPosition;
        private int dayFirst;
        private int dayLast;
        private Car car;
        private double kilometrage;
        private int cargoTraffic;
        private int ridersNumber;
        private FuelBalance fuelBalance;
        private FuelUsage fuelUsage;
        private List<CarDriverSummary> carDriverSummaryList;

        private CarSummaryBuilder() {
        }

        public static CarSummaryBuilder aTruckSummary() {
            return new CarSummaryBuilder();
        }

        public CarSummaryBuilder withReportPosition(int reportPosition) {
            this.reportPosition = reportPosition;
            return this;
        }

        public CarSummaryBuilder withDayFirst(int dayFirst) {
            this.dayFirst = dayFirst;
            return this;
        }

        public CarSummaryBuilder withDayLast(int dayLast) {
            this.dayLast = dayLast;
            return this;
        }

        public CarSummaryBuilder withTruck(Car car) {
            this.car = car;
            return this;
        }

        public CarSummaryBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public CarSummaryBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public CarSummaryBuilder withRidersNumber(int ridersNumber) {
            this.ridersNumber = ridersNumber;
            return this;
        }

        public CarSummaryBuilder withFuelBalance(FuelBalance fuelBalance) {
            this.fuelBalance = fuelBalance;
            return this;
        }

        public CarSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public CarSummaryBuilder withTruckDriverSummaries(
                List<CarDriverSummary> carDriverSummaryList) {
            this.carDriverSummaryList = carDriverSummaryList;
            return this;
        }

        public CarSummary build() {
            CarSummary carSummary = new CarSummary(reportPosition);
            carSummary.setDayFirst(dayFirst);
            carSummary.setDayLast(dayLast);
            carSummary.setCar(car);
            carSummary.setKilometrage(kilometrage);
            carSummary.setCargoTraffic(cargoTraffic);
            carSummary.setRidersNumber(ridersNumber);
            carSummary.setFuelBalance(fuelBalance);
            carSummary.setFuelUsage(fuelUsage);
            carSummary.setCarDriverSummaryList(carDriverSummaryList);
            return carSummary;
        }
    }
}
