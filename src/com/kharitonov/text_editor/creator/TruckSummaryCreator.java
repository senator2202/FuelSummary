package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.*;
import com.kharitonov.text_editor.parser.FuelBallanceParser;
import com.kharitonov.text_editor.parser.FuelUsageParser;
import com.kharitonov.text_editor.parser.TruckParser;
import com.kharitonov.text_editor.regex.RegexContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TruckSummaryCreator {
    public TruckSummary create(Matcher matcher) {
        String dayFirst = matcher.group("dayFirst");
        String dayLast = matcher.group("dayLast");
        String garageNumber = matcher.group("garageNumber");
        String modelCode = matcher.group("modelCode");
        String kilometrage = matcher.group("kilometrage");
        String cargoTraffic = matcher.group("cargoTraffic");
        String ridersNumber = matcher.group("ridersNumber");
        String fuelStart = matcher.group("fuelStart");
        String receivedFuel = matcher.group("receivedFuel");
        String receivedFuelOfficial = matcher.group("receivedFuelOfficial");
        String returnedFuel = matcher.group("returnedFuel");
        String returnedFuelOfficial = matcher.group("returnedFuelOfficial");
        String fuelEnd = matcher.group("fuelEnd");
        String usageNormal = matcher.group("usageNormal");
        String usageWayBill = matcher.group("usageWayBill");
        String carNumber = matcher.group("carNumber");
        Truck truck = TruckParser.parse(carNumber, garageNumber, modelCode);
        FuelBallance fuelBallance = FuelBallanceParser.parse(
                fuelStart,
                receivedFuel,
                receivedFuelOfficial,
                returnedFuel,
                returnedFuelOfficial,
                fuelEnd);
        FuelUsage fuelUsage = FuelUsageParser
                .parse(usageNormal, usageWayBill);
        int numberOfRiders = ridersNumber == null || ridersNumber.isEmpty()
                ? 0
                : Integer.parseInt(ridersNumber);
        Map<TruckDriver, Double> economyMap = getEconomy(matcher);
        TruckSummary truckSummary = TruckSummary.TruckSummaryBuilder
                .aTruckSummary()
                .withTruck(truck)
                .withFuelBallance(fuelBallance)
                .withFuelUsage(fuelUsage)
                .withRidersNumber(numberOfRiders)
                .withDayFirst(Integer.parseInt(dayFirst))
                .withDayLast(Integer.parseInt(dayLast))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withFuelEconomy(economyMap)
                .build();
        return truckSummary;
    }

    private Map<TruckDriver, Double> getEconomy(Matcher matcher) {
        Pattern p = Pattern.compile(RegexContainer.REGEX_DRIVER);
        Matcher m = p.matcher(matcher.group());
        Map<TruckDriver, Double> economyMap = new HashMap<>();
        while (m.find()) {
            String id = m.group("driverId");
            String name = m.group("driverName");
            String economy = m.group("driverEconomy");
            TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                    name);
            economyMap.put(driver, Double.parseDouble(economy));
        }
        if (economyMap.isEmpty()) {
            String name = matcher.group("driverNameTrip");
            String id = matcher.group("driverIdTrip");
            String economy = matcher.group("fuelEconomy");
            TruckDriver driver = new TruckDriver(Integer.parseInt(id),
                    name);
            economyMap.put(driver, Double.parseDouble(economy));
        }
        return economyMap;
    }
}
