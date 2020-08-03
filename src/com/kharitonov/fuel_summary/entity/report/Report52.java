package com.kharitonov.fuel_summary.entity.report;

import java.util.*;

public class Report52 {
    private final ReportHeader header;
    private final Map<Integer, Trip> tripMap;
    private final Map<Integer, TruckSummary> truckSummaryMap;
    private final Report52Summary summary;

    public Report52(ReportHeader header,
                    Map<Integer, Trip> tripMap,
                    Map<Integer, TruckSummary> truckSummaryMap,
                    Report52Summary summary) {
        this.header = header;
        this.tripMap = tripMap;
        this.truckSummaryMap = truckSummaryMap;
        this.summary = summary;
    }

    public ReportHeader getHeader() {
        return header;
    }

    public Map<Integer, Trip> getTripMap() {
        return Collections.unmodifiableMap(tripMap);
    }

    public List<Trip> getTripList() {
        return List.copyOf(tripMap.values());
    }

    public Map<Integer, TruckSummary> getTruckSummaryMap() {
        return Collections.unmodifiableMap(truckSummaryMap);
    }

    public List<TruckSummary> getTruckSummaryList() {
        TreeMap<Integer, TruckSummary> treeMap = new TreeMap<>();
        treeMap.putAll(truckSummaryMap);
        return List.copyOf(treeMap.values());
    }

    public Report52Summary getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report52 report52 = (Report52) o;
        if (!Objects.equals(header, report52.header))
            return false;
        if (!Objects.equals(tripMap, report52.tripMap))
            return false;
        if (!Objects.equals(truckSummaryMap, report52.truckSummaryMap))
            return false;
        return Objects.equals(summary, report52.summary);
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
