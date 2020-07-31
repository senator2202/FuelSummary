package com.kharitonov.text_editor.entity.report;

import java.util.Collections;
import java.util.List;

public class Report52Summary {
    private static final String SUMMARY_LABEL = "Итого по АП";
    private List<FuelSummary> fuelSummaryList;

    public Report52Summary(List<FuelSummary> fuelSummaryList) {
        this.fuelSummaryList = fuelSummaryList;
    }

    public static String getSummaryLabel() {
        return SUMMARY_LABEL;
    }

    public List<FuelSummary> getFuelSummaryList() {
        return Collections.unmodifiableList(fuelSummaryList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report52Summary that = (Report52Summary) o;
        return fuelSummaryList != null ? fuelSummaryList.equals(that.fuelSummaryList) : that.fuelSummaryList == null;
    }

    @Override
    public int hashCode() {
        return fuelSummaryList != null ? fuelSummaryList.hashCode() : 0;
    }
}
