package com.kharitonov.text_editor.entity;

import java.util.Collections;
import java.util.List;

public class FuelSummary {
    private ReportHeader header;
    private List<TruckSummary> truckSummaryList;

    public FuelSummary(ReportHeader header, List<TruckSummary> truckSummaryList) {
        this.header = header;
        this.truckSummaryList = truckSummaryList;
    }

    public ReportHeader getHeader() {
        return header;
    }

    public List<TruckSummary> getTruckSummaryList() {
        return Collections.unmodifiableList(truckSummaryList);
    }
}
