package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.GroupNames;
import com.kharitonov.fuel_summary.constant.RegexContainer;
import com.kharitonov.fuel_summary.entity.vehicle.Car;
import com.kharitonov.fuel_summary.entity.fuel.FuelBalance;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;
import com.kharitonov.fuel_summary.entity.report.CarDriverSummary;
import com.kharitonov.fuel_summary.entity.report.CarSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarSummaryCreator {
    public CarSummary create(Matcher matcher) {
        String dayFirst = matcher.group(GroupNames.DAY_FIRST);
        String dayLast = matcher.group(GroupNames.DAY_LAST);
        String garageNumber = matcher.group(GroupNames.GARAGE_NUMBER);
        String kilometrage = matcher.group(GroupNames.KILOMETRAGE);
        String cargoTraffic = matcher.group(GroupNames.CARGO_TRAFFIC);
        String ridersNumber = matcher.group(GroupNames.RIDERS_NUMBER);
        String fuelStart = matcher.group(GroupNames.FUEL_START);
        String receivedFuel = matcher.group(GroupNames.RECEIVED_FUEL);
        String receivedFuelOfficial =
                matcher.group(GroupNames.RECEIVED_FUEL_OFFICIAL);
        String returnedFuel = matcher.group(GroupNames.RETURNED_FUEL);
        String returnedFuelOfficial = matcher.group(GroupNames
                .RETURNED_FUEL_OFFICIAL);
        String fuelEnd = matcher.group(GroupNames.FUEL_END);
        String usageNormal = matcher.group(GroupNames.USAGE_NORMAL);
        String usageWayBill = matcher.group(GroupNames.USAGE_WAY_BILL);
        Car car = new CarCreator()
                .create(garageNumber);
        FuelBalance fuelBalance = new FuelBalanceCreator()
                .create(fuelStart,
                        receivedFuel,
                        receivedFuelOfficial,
                        returnedFuel,
                        returnedFuelOfficial,
                        fuelEnd);
        FuelUsage fuelUsage = new FuelUsageCreator()
                .create(usageNormal, usageWayBill);
        int numberOfRiders = ridersNumber == null || ridersNumber.isEmpty()
                ? 0
                : Integer.parseInt(ridersNumber);
        List<CarDriverSummary> truckDriverSummaries =
                getTruckDriverSummaries(matcher);
        return CarSummary.CarSummaryBuilder
                .aTruckSummary()
                .withReportPosition(matcher.start())
                .withTruck(car)
                .withFuelBalance(fuelBalance)
                .withFuelUsage(fuelUsage)
                .withRidersNumber(numberOfRiders)
                .withDayFirst(Integer.parseInt(dayFirst))
                .withDayLast(Integer.parseInt(dayLast))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withTruckDriverSummaries(truckDriverSummaries)
                .build();
    }

    private List<CarDriverSummary> getTruckDriverSummaries(Matcher matcher) {
        Pattern p = Pattern.compile(RegexContainer.REGEX_DRIVER);
        Matcher m = p.matcher(matcher.group());
        List<CarDriverSummary> list = new ArrayList<>();
        while (m.find()) {
            CarDriverSummary summary = new CarDriverSummaryCreator()
                    .createSeveral(m);
            list.add(summary);
        }
        if (list.isEmpty()) {
            CarDriverSummary summary = new CarDriverSummaryCreator()
                    .createSolo(matcher);
            list.add(summary);
        }
        return list;
    }
}
