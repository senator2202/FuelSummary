package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.GroupNames;
import com.kharitonov.fuel_summary.constant.TruckParkInformation;
import com.kharitonov.fuel_summary.entity.Truck;
import com.kharitonov.fuel_summary.entity.TruckDriver;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;
import com.kharitonov.fuel_summary.entity.report.TruckDriverSummary;

import java.util.regex.Matcher;

public class TruckDriverSummaryCreator {
    public TruckDriverSummary createSeveral(Matcher matcher) {
        String id = matcher.group(GroupNames.DRIVER_ID);
        String name = matcher.group(GroupNames.DRIVER_NAME);
        String kilometrage = matcher.group(GroupNames.DRIVER_KILOMETRAGE);
        String cargoTraffic = matcher.group(GroupNames.DRIVER_CARGO_TRAFFIC);
        String fuelReceived = matcher.group(GroupNames.DRIVER_FUEL_RECEIVED);
        String usageNormal = matcher.group(GroupNames.DRIVER_USAGE_NORMAL);
        String usageWayBill = matcher.group(GroupNames.DRIVER_USAGE_WAY_BILL);
        String economy = matcher.group(GroupNames.DRIVER_ECONOMY);
        TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                name);
        FuelUsage fuelUsage = new FuelUsage(Double.parseDouble(usageNormal),
                Double.parseDouble(usageWayBill));
        return TruckDriverSummary
                .TruckDriverSummaryBuilder
                .aTruckDriverSummary()
                .withDriver(driver)
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withEconomy(Double.parseDouble(economy))
                .withFuelReceived(Double.parseDouble(fuelReceived))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withFuelUsage(fuelUsage)
                .build();
    }

    public TruckDriverSummary createSolo(Matcher matcher) {
        int cargoTraffic = Integer
                .parseInt(matcher.group(GroupNames.CARGO_TRAFFIC_TRIP));
        int garageNumber =
                Integer.parseInt(matcher.group(GroupNames.GARAGE_NUMBER));
        Truck truck = new Truck(matcher.group(GroupNames.CAR_NUMBER),
                garageNumber,
                Integer.parseInt(matcher.group(GroupNames.MODEL_CODE)),
                TruckParkInformation.getFuelType(garageNumber));
        TruckDriver driver = new TruckDriver(
                Integer.parseInt(matcher.group(GroupNames.DRIVER_ID_TRIP)),
                matcher.group(GroupNames.DRIVER_NAME_TRIP));
        FuelUsage fuelUsage = new FuelUsage(
                Double.parseDouble(matcher.group(GroupNames.USAGE_NORMAL)),
                Double.parseDouble(matcher.group(GroupNames.USAGE_WAY_BILL)));
        return TruckDriverSummary
                .TruckDriverSummaryBuilder
                .aTruckDriverSummary()
                .withCargoTraffic(cargoTraffic)
                .withTruck(truck)
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
