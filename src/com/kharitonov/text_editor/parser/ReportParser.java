package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.creator.ReportHeaderCreator;
import com.kharitonov.text_editor.creator.TruckSummaryCreator;
import com.kharitonov.text_editor.entity.*;
import com.kharitonov.text_editor.regex.RegexContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportParser {
    public List<Trip> parseTrips(String data) {
        Pattern pattern = Pattern.compile(RegexContainer.REGEX_TRIP);
        Matcher matcher = pattern.matcher(data);
        List<Trip> tripList = new ArrayList<>();
        while (matcher.find()) {
            String date = matcher.group("date");
            String officialBillId = matcher.group("officialBillId");
            String pack = matcher.group("pack");
            String wayBillId = matcher.group("wayBillId");
            String driverName = matcher.group("driverNameTrip");
            String driverId = matcher.group("driverIdTrip");
            String kilometrage = matcher.group("kilometrageTrip");
            String cargoTraffic = matcher.group("cargoTrafficTrip");
            String ridersNumber = matcher.group("ridersNumberTrip");
            String fuelStart = matcher.group("fuelStartTrip");
            String receivedFuel = matcher.group("receivedFuelTrip");
            String receivedFuelOfficial = matcher
                    .group("receivedFuelOfficialTrip");
            String returnedFuel = matcher.group("returnedFuelTrip");
            String returnedFuelOfficial = matcher
                    .group("returnedFuelOfficialTrip");
            String fuelEnd = matcher.group("fuelEndTrip");
            String usageNormal = matcher.group("usageNormalTrip");
            String usageWayBill = matcher.group("usageWayBillTrip");
            String fuelEconomy = matcher.group("fuelEconomyTrip");
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

    public FuelSummary parseFuelSummary(String data) {
        List<TruckSummary> truckSummaryList = parseTruckSummaries(data);
        ReportHeader reportHeader = parseReportHeader(data);
        return new FuelSummary(reportHeader,truckSummaryList);
    }

    public ReportHeader parseReportHeader(String data) {
        Pattern pattern = Pattern.compile(RegexContainer.REGEX_HEADER);
        Matcher matcher = pattern.matcher(data);
        ReportHeader reportHeader = null;
        if (matcher.find()) {
            reportHeader = new ReportHeaderCreator().create(matcher);
        }
        return reportHeader;
    }

    public List<TruckSummary> parseTruckSummaries(String data) {
        String finalRegex = String.format("(%s(\\s+)%s(\\s+))((%s)((\\s+)(%s))+)?",
                RegexContainer.REGEX_TRIP,
                RegexContainer.REGEX_TRUCK_SUMMARY,
                RegexContainer.DRIVERS_TEXT,
                RegexContainer.REGEX_DRIVER);
        Pattern pattern = Pattern.compile(finalRegex);
        Matcher matcher = pattern.matcher(data);
        List<TruckSummary> truckSummaryList = new ArrayList<>();
        while (matcher.find()) {
            TruckSummaryCreator creator = new TruckSummaryCreator();
            TruckSummary truckSummary = creator.create(matcher);
            truckSummaryList.add(truckSummary);
        }
        return truckSummaryList;
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
