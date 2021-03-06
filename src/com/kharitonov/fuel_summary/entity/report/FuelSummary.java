package com.kharitonov.fuel_summary.entity.report;

import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;
import com.kharitonov.fuel_summary.type.FuelType;

import java.util.Objects;

public class FuelSummary {
    private FuelType fuelType;
    private double kilometrage;
    private int cargoTraffic;
    private int ridersNumber;
    private double fuelReceived;
    private double fuelReceivedOfficial;
    private FuelUsage fuelUsage;
    private double economy;

    private FuelSummary() {
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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

    public double getFuelReceived() {
        return fuelReceived;
    }

    public void setFuelReceived(double fuelReceived) {
        this.fuelReceived = fuelReceived;
    }

    public double getFuelReceivedOfficial() {
        return fuelReceivedOfficial;
    }

    public void setFuelReceivedOfficial(double fuelReceivedOfficial) {
        this.fuelReceivedOfficial = fuelReceivedOfficial;
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
        FuelSummary that = (FuelSummary) o;
        if (Double.compare(that.kilometrage, kilometrage) != 0)
            return false;
        if (cargoTraffic != that.cargoTraffic) return false;
        if (ridersNumber != that.ridersNumber) return false;
        if (Double.compare(that.fuelReceived, fuelReceived) != 0)
            return false;
        if (Double.compare(that.fuelReceivedOfficial, fuelReceivedOfficial) != 0)
            return false;
        if (Double.compare(that.economy, economy) != 0) return false;
        if (fuelType != that.fuelType) return false;
        return Objects.equals(fuelUsage, that.fuelUsage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fuelType != null ? fuelType.hashCode() : 0;
        temp = Double.doubleToLongBits(kilometrage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cargoTraffic;
        result = 31 * result + ridersNumber;
        temp = Double.doubleToLongBits(fuelReceived);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelReceivedOfficial);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (fuelUsage != null ? fuelUsage.hashCode() : 0);
        temp = Double.doubleToLongBits(economy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static final class FuelSummaryBuilder {
        private FuelType fuelType;
        private double kilometrage;
        private int cargoTraffic;
        private int ridersNumber;
        private double fuelReceived;
        private double fuelReceivedOfficial;
        private FuelUsage fuelUsage;
        private double economy;

        private FuelSummaryBuilder() {
        }

        public static FuelSummaryBuilder aFuelSummary() {
            return new FuelSummaryBuilder();
        }

        public FuelSummaryBuilder withFuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public FuelSummaryBuilder withKilometrage(double kilometrage) {
            this.kilometrage = kilometrage;
            return this;
        }

        public FuelSummaryBuilder withCargoTraffic(int cargoTraffic) {
            this.cargoTraffic = cargoTraffic;
            return this;
        }

        public FuelSummaryBuilder withRidersNumber(int ridersNumber) {
            this.ridersNumber = ridersNumber;
            return this;
        }

        public FuelSummaryBuilder withFuelReceived(double fuelReceived) {
            this.fuelReceived = fuelReceived;
            return this;
        }

        public FuelSummaryBuilder withFuelReceivedOfficial(
                double fuelReceivedOfficial) {
            this.fuelReceivedOfficial = fuelReceivedOfficial;
            return this;
        }

        public FuelSummaryBuilder withFuelUsage(FuelUsage fuelUsage) {
            this.fuelUsage = fuelUsage;
            return this;
        }

        public FuelSummaryBuilder withEconomy(double economy) {
            this.economy = economy;
            return this;
        }

        public FuelSummary build() {
            FuelSummary fuelSummary = new FuelSummary();
            fuelSummary.setFuelType(fuelType);
            fuelSummary.setKilometrage(kilometrage);
            fuelSummary.setCargoTraffic(cargoTraffic);
            fuelSummary.setRidersNumber(ridersNumber);
            fuelSummary.setFuelReceived(fuelReceived);
            fuelSummary.setFuelReceivedOfficial(fuelReceivedOfficial);
            fuelSummary.setFuelUsage(fuelUsage);
            fuelSummary.setEconomy(economy);
            return fuelSummary;
        }
    }
}
