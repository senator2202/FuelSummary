package com.kharitonov.text_editor.entity.report;

public class ReportContext {
    private int reportPosition;

    public ReportContext(int reportPosition) {
        this.reportPosition = reportPosition;
    }

    public int getReportPosition() {
        return reportPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportContext that = (ReportContext) o;
        return reportPosition == that.reportPosition;
    }

    @Override
    public int hashCode() {
        return reportPosition;
    }
}
