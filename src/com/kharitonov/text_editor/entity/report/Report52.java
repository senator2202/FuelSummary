package com.kharitonov.text_editor.entity.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Report52 {
    private final ReportHeader header;
    private final Map<Integer,Trip> tripMap;
    private final Map<Integer,TruckSummary> truckSummaryMap;
    private final Report52Summary summary;

    public Report52(ReportHeader header,
                    Map<Integer,Trip> tripMap,
                    Map<Integer,TruckSummary> truckSummaryMap,
                    Report52Summary summary) {
        this.header = header;
        this.tripMap = tripMap;
        this.truckSummaryMap = truckSummaryMap;
        this.summary = summary;
    }

    public ReportHeader getHeader() {
        return header;
    }

    public Map<Integer,Trip> getTripMap() {
        return Collections.unmodifiableMap(tripMap);
    }

    public List<Trip> getTripList() {
        return Collections
                .unmodifiableList(new ArrayList<>(tripMap.values()));
    }

    public Map<Integer,TruckSummary> getTruckSummaryMap() {
        return Collections.unmodifiableMap(truckSummaryMap);
    }

    public List<TruckSummary> getTruckSummaryList() {
        return Collections
                .unmodifiableList(new ArrayList<>(truckSummaryMap.values()));
    }

    public Report52Summary getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report52 report52 = (Report52) o;
        if (header != null ? !header.equals(report52.header) : report52.header != null)
            return false;
        if (tripMap != null ? !tripMap.equals(report52.tripMap) : report52.tripMap != null)
            return false;
        if (truckSummaryMap != null ? !truckSummaryMap.equals(report52.truckSummaryMap) : report52.truckSummaryMap != null)
            return false;
        return summary != null ? summary.equals(report52.summary) : report52.summary == null;
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (tripMap != null ? tripMap.hashCode() : 0);
        result = 31 * result + (truckSummaryMap != null ? truckSummaryMap.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }
}
