package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.constant.GroupNames;
import com.kharitonov.text_editor.constant.RegexContainer;
import com.kharitonov.text_editor.entity.Truck;
import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.entity.fuel.FuelBalance;
import com.kharitonov.text_editor.entity.fuel.FuelUsage;
import com.kharitonov.text_editor.entity.report.TruckDriverSummary;
import com.kharitonov.text_editor.entity.report.TruckSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TruckSummaryCreator {
    public TruckSummary create(Matcher matcher) {
        String dayFirst = matcher.group(GroupNames.DAY_FIRST);
        String dayLast = matcher.group(GroupNames.DAY_LAST);
        String garageNumber = matcher.group(GroupNames.GARAGE_NUMBER);
        String modelCode = matcher.group(GroupNames.MODEL_CODE);
        String kilometrage = matcher.group(GroupNames.KILOMETRAGE);
        String cargoTraffic = matcher.group(GroupNames.CARGO_TRAFFIC);
        String ridersNumber = matcher.group(GroupNames.RIDERS_NUMBER);
        String fuelStart = matcher.group(GroupNames.FUEL_START);
        String receivedFuel = matcher.group(GroupNames.RECEIVED_FUEL);
        String receivedFuelOfficial =
                matcher.group(GroupNames.RECEVIED_FUEL_OFFICIAL);
        String returnedFuel = matcher.group(GroupNames.RETURNED_FUEL);
        String returnedFuelOfficial = matcher.group(GroupNames.RETURNED_FUEL_OFFICIAL);
        String fuelEnd = matcher.group(GroupNames.FUEL_END);
        String usageNormal = matcher.group(GroupNames.USAGE_NORMAL);
        String usageWayBill = matcher.group(GroupNames.USAGE_WAY_BILL);
        String carNumber = matcher.group(GroupNames.CAR_NUMBER);
        Truck truck = new TruckCreator()
                .create(carNumber, garageNumber, modelCode);
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
        List<TruckDriverSummary> truckDriverSummaries =
                getTruckDriverSummaries(matcher);
        return TruckSummary.TruckSummaryBuilder
                .aTruckSummary()
                .withReportPosition(matcher.start())
                .withTruck(truck)
                .withFuelBallance(fuelBalance)
                .withFuelUsage(fuelUsage)
                .withRidersNumber(numberOfRiders)
                .withDayFirst(Integer.parseInt(dayFirst))
                .withDayLast(Integer.parseInt(dayLast))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withTruckDriverSummaries(truckDriverSummaries)
                .build();
    }

    private List<TruckDriverSummary> getTruckDriverSummaries(Matcher matcher) {
        Pattern p = Pattern.compile(RegexContainer.REGEX_DRIVER);
        Matcher m = p.matcher(matcher.group());
        List<TruckDriverSummary> list = new ArrayList<>();
        while (m.find()) {
            String id = m.group(GroupNames.DRIVER_ID);
            String name = m.group(GroupNames.DRIVER_NAME);
            String kilometrage = m.group(GroupNames.DRIVER_KILOMETRAGE);
            String cargoTraffic = m.group(GroupNames.DRIVER_CARGO_TRAFFIC);
            String fuelReceived = m.group(GroupNames.DRIVER_FUEL_RECEIVED);
            String usageNormal = m.group(GroupNames.DRIVER_USAGE_NORMAL);
            String usageWayBill = m.group(GroupNames.DRIVER_USAGE_WAY_BILL);
            String economy = m.group(GroupNames.DRIVER_ECONOMY);
            TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                    name);
            FuelUsage fuelUsage = new FuelUsage(Double.parseDouble(usageNormal),
                    Double.parseDouble(usageWayBill));
            TruckDriverSummary summary = TruckDriverSummary
                    .TruckDriverSummaryBuilder
                    .aTruckDriverSummary()
                    .withDriver(driver)
                    .withCargoTraffic(Integer.parseInt(cargoTraffic))
                    .withEconomy(Double.parseDouble(economy))
                    .withFuelReceived(Double.parseDouble(fuelReceived))
                    .withKilometrage(Double.parseDouble(kilometrage))
                    .withFuelUsage(fuelUsage)
                    .build();
            list.add(summary);
        }
        return list;
    }
}
