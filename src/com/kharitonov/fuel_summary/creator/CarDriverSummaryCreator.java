package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.GroupNames;
import com.kharitonov.fuel_summary.constant.CarParkInformation;
import com.kharitonov.fuel_summary.entity.vehicle.Car;
import com.kharitonov.fuel_summary.entity.CarDriver;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;
import com.kharitonov.fuel_summary.entity.report.CarDriverSummary;

import java.util.regex.Matcher;

public class CarDriverSummaryCreator {
    public CarDriverSummary createSeveral(Matcher matcher) {
        String id = matcher.group(GroupNames.DRIVER_ID);
        String name = matcher.group(GroupNames.DRIVER_NAME);
        String kilometrage = matcher.group(GroupNames.DRIVER_KILOMETRAGE);
        String cargoTraffic = matcher.group(GroupNames.DRIVER_CARGO_TRAFFIC);
        String fuelReceived = matcher.group(GroupNames.DRIVER_FUEL_RECEIVED);
        String usageNormal = matcher.group(GroupNames.DRIVER_USAGE_NORMAL);
        String usageWayBill = matcher.group(GroupNames.DRIVER_USAGE_WAY_BILL);
        String economy = matcher.group(GroupNames.DRIVER_ECONOMY);
        CarDriver driver = new CarDriver(Integer.parseInt(id),
                name);
        FuelUsage fuelUsage = new FuelUsage(Double.parseDouble(usageNormal),
                Double.parseDouble(usageWayBill));
        return CarDriverSummary.CarDriverSummaryBuilder
                .aTruckDriverSummary()
                .withDriver(driver)
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withEconomy(Double.parseDouble(economy))
                .withFuelReceived(Double.parseDouble(fuelReceived))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withFuelUsage(fuelUsage)
                .build();
    }

    public CarDriverSummary createSolo(Matcher matcher) {
        int cargoTraffic = Integer
                .parseInt(matcher.group(GroupNames.CARGO_TRAFFIC_TRIP));
        int garageNumber =
                Integer.parseInt(matcher.group(GroupNames.GARAGE_NUMBER));
        Car car = new Car(matcher.group(GroupNames.CAR_NUMBER),
                garageNumber,
                Integer.parseInt(matcher.group(GroupNames.MODEL_CODE)),
                CarParkInformation.getFuelType(garageNumber));
        CarDriver driver = new CarDriver(
                Integer.parseInt(matcher.group(GroupNames.DRIVER_ID_TRIP)),
                matcher.group(GroupNames.DRIVER_NAME_TRIP));
        FuelUsage fuelUsage = new FuelUsage(
                Double.parseDouble(matcher.group(GroupNames.USAGE_NORMAL)),
                Double.parseDouble(matcher.group(GroupNames.USAGE_WAY_BILL)));
        return CarDriverSummary.CarDriverSummaryBuilder
                .aTruckDriverSummary()
                .withCargoTraffic(cargoTraffic)
                .withTruck(car)
                .withDriver(driver)
                .withEconomy(Double.parseDouble(matcher
                        .group(GroupNames.FUEL_ECONOMY)))
                .withFuelReceived(Double.parseDouble(matcher
                        .group(GroupNames.RECEIVED_FUEL)))
                .withFuelUsage(fuelUsage)
                .withKilometrage(Double.parseDouble(matcher
                        .group(GroupNames.KILOMETRAGE)))
                .build();
    }
}
