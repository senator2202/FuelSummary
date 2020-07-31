package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.constant.GroupNames;
import com.kharitonov.text_editor.constant.RegexContainer;
import com.kharitonov.text_editor.entity.*;
import com.kharitonov.text_editor.entity.fuel.FuelBalance;
import com.kharitonov.text_editor.entity.fuel.FuelUsage;
import com.kharitonov.text_editor.entity.report.TruckSummary;

import java.util.HashMap;
import java.util.Map;
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
        Map<TruckDriver, Double> economyMap = getEconomy(matcher);
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
                .withFuelEconomy(economyMap)
                .build();
    }

    private Map<TruckDriver, Double> getEconomy(Matcher matcher) {
        Pattern p = Pattern.compile(RegexContainer.REGEX_DRIVER);
        Matcher m = p.matcher(matcher.group());
        Map<TruckDriver, Double> economyMap = new HashMap<>();
        while (m.find()) {
            String id = m.group(GroupNames.DRIVER_ID);
            String name = m.group(GroupNames.DRIVER_NAME);
            String economy = m.group(GroupNames.DRIVER_ECONOMY);
            TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                    name);
            economyMap.put(driver, Double.parseDouble(economy));
        }
        if (economyMap.isEmpty()) {
            String name = matcher.group(GroupNames.DRIVER_NAME_TRIP);
            String id = matcher.group(GroupNames.DRIVER_ID_TRIP);
            String economy = matcher.group(GroupNames.FUEL_ECONOMY);
            TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                    name);
            economyMap.put(driver, Double.parseDouble(economy));
        }
        return economyMap;
    }
}
