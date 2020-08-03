package com.kharitonov.fuel_summary.parser;

import com.kharitonov.fuel_summary.constant.RegexContainer;
import com.kharitonov.fuel_summary.creator.FuelSummaryCreator;
import com.kharitonov.fuel_summary.creator.ReportHeaderCreator;
import com.kharitonov.fuel_summary.creator.TripCreator;
import com.kharitonov.fuel_summary.creator.TruckSummaryCreator;
import com.kharitonov.fuel_summary.entity.report.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Report52Parser {
    public Map<Integer, Trip> parseTrips(String data) {
        Pattern pattern = Pattern.compile(RegexContainer.REGEX_TRIP);
        Matcher matcher = pattern.matcher(data);
        Map<Integer, Trip> tripMap = new HashMap<>();
        while (matcher.find()) {
            Trip trip = new TripCreator().create(matcher);
            tripMap.put(matcher.end(), trip);
        }
        return tripMap;
    }

    public Report52 parseReport52(String data) {
        Map<Integer, Trip> tripList = parseTrips(data);
        Map<Integer, TruckSummary> truckSummaryList = parseTruckSummaries(data);
        ReportHeader reportHeader = parseReportHeader(data);
        Report52Summary report52Summary = parseFuelSummary(data);
        return new Report52(reportHeader, tripList,
                truckSummaryList, report52Summary);
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

    public Map<Integer, TruckSummary> parseTruckSummaries(String data) {
        String truckSummaryRegex = String.format("(%s(\\s+)%s(\\s+))" +
                        "((%s)((\\s+)(%s))+)?",
                RegexContainer.REGEX_TRIP,
                RegexContainer.REGEX_TRUCK_SUMMARY,
                RegexContainer.DRIVERS_TEXT,
                RegexContainer.REGEX_DRIVER);
        Pattern pattern = Pattern.compile(truckSummaryRegex);
        Matcher matcher = pattern.matcher(data);
        Map<Integer, TruckSummary> truckSummaryMap = new HashMap<>();
        while (matcher.find()) {
            TruckSummaryCreator creator = new TruckSummaryCreator();
            TruckSummary truckSummary = creator.create(matcher);
            truckSummaryMap.put(matcher.end(), truckSummary);
        }
        return truckSummaryMap;
    }

    public Report52Summary parseFuelSummary(String data) {
        Pattern pattern = Pattern.compile(RegexContainer.REGEX_FUEL_SUMMARY);
        Matcher matcher = pattern.matcher(data);
        List<FuelSummary> fuelSummaries = new ArrayList<>();
        while (matcher.find()) {
            FuelSummary fuelSummary = new FuelSummaryCreator().create(matcher);
            fuelSummaries.add(fuelSummary);
        }
        return new Report52Summary(fuelSummaries);
    }
}
