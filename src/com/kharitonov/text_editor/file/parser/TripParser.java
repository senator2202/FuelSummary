package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripParser {
    private static final String REGEX_TRIP =
            "(?<date>\\d\\d\\.\\d\\d)(\\s+)" +
                    "(?<officialBillId>\\d?)(\\s+)" +
                    "(?<pack>\\d+)(\\s+)" +
                    "(?<wayBillId>\\d+)(\\s+)" +
                    "(?<driverName>\\p{L}+\\s\\p{L}[\\s\\.]\\p{L}\\.?)(\\s+)" +
                    "(?<driverId>\\d+)(\\s+)" +
                    "(?<kilometrage>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTraffic>\\d+)(\\s+)" +
                    "(?<ridersNumber>\\d)?(\\s+)" +
                    "(?<fuelStart>\\d+\\.\\d+)(\\s+)" +
                    "(?<receivedFuel>\\d+\\.\\d+)(\\s+)" +
                    "(?<receivedFuelOfficial>\\d+\\.\\d?)(\\s+)" +
                    "(?<returnedFuel>\\d+)(\\s+)" +
                    "(?<returnedFuelOfficial>\\d+)(\\s+)" +
                    "(?<fuelEnd>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageNormal>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageWayBill>\\d+\\.\\d+)(\\s+)" +
                    "(?<fuelEconomy>-?\\d+\\.\\d+)";

    public List<Trip> parse(String data) {
        Pattern pattern = Pattern.compile(REGEX_TRIP);
        Matcher matcher = pattern.matcher(data);
        List<Trip> tripList = new ArrayList<>();
        while (matcher.find()) {
            String date = matcher.group("date");
            String officialBillId = matcher.group("officialBillId");
            String pack = matcher.group("pack");
            String wayBillId = matcher.group("wayBillId");
            String driverName = matcher.group("driverName");
            String driverId = matcher.group("driverId");
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
            String fuelEconomy = matcher.group("fuelEconomy");
            OfficialBill officialBill =
                    OfficialBillParser.parse(officialBillId,
                            receivedFuelOfficial,
                            returnedFuelOfficial);
            WayBill wayBill = WayBillParser.parse(wayBillId, pack,
                    receivedFuel, returnedFuel);
            TruckDriver truckDriver =
                    TruckDriverParser.parse(driverId, driverName);
            FuelUsage fuelUsage =
                    FuelUsageParser.parse(usageNormal, usageWayBill);
            int numberOfRiders = ridersNumber == null || ridersNumber.isEmpty()
                    ? 0
                    : Integer.parseInt(ridersNumber);
            Trip trip = Trip.TripBuilder.aTrip()
                    .withDate(date)
                    .withOfficialBill(officialBill)
                    .withWayBill(wayBill)
                    .withDriver(truckDriver)
                    .withFuelUsage(fuelUsage)
                    .withKilometrage(Double.parseDouble(kilometrage))
                    .withCargoTraffic(Integer.parseInt(cargoTraffic))
                    .withRidersNumber(numberOfRiders)
                    .withFuelStart(Double.parseDouble(fuelStart))
                    .withFuelEnd(Double.parseDouble(fuelEnd))
                    .withFuelEconomy(Double.parseDouble(fuelEconomy))
                    .build();
            tripList.add(trip);
        }
        return tripList;
    }
}
