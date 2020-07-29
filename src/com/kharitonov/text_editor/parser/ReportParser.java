package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.constant.RegexContainer;
import com.kharitonov.text_editor.creator.ReportHeaderCreator;
import com.kharitonov.text_editor.creator.TripCreator;
import com.kharitonov.text_editor.creator.TruckSummaryCreator;
import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.entity.ReportHeader;
import com.kharitonov.text_editor.entity.Trip;
import com.kharitonov.text_editor.entity.TruckSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportParser {
    public List<Trip> parseTrips(String data) {
        Pattern pattern = Pattern.compile(RegexContainer.REGEX_TRIP);
        Matcher matcher = pattern.matcher(data);
        List<Trip> tripList = new ArrayList<>();
        while (matcher.find()) {
            Trip trip = new TripCreator().create(matcher);
            tripList.add(trip);
        }
        return tripList;
    }

    public FuelSummary parseFuelSummary(String data) {
        List<TruckSummary> truckSummaryList = parseTruckSummaries(data);
        ReportHeader reportHeader = parseReportHeader(data);
        return new FuelSummary(reportHeader, truckSummaryList);
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
}
