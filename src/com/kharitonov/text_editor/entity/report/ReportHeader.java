package com.kharitonov.text_editor.entity.report;

import com.kharitonov.text_editor.type.MonthRussian;

import java.util.Calendar;
import java.util.Objects;

public class ReportHeader {
    private final MonthRussian month;
    private final int year;
    private final Calendar dateCreation;

    public ReportHeader(MonthRussian month, int year, Calendar dateCreation) {
        this.month = month;
        this.year = year;
        this.dateCreation = dateCreation;
    }

    public MonthRussian getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Calendar getDateCreation() {
        return dateCreation;
    }

    public String getStringDateCreation() {
        StringBuilder sb = new StringBuilder();
        sb.append(dateCreation.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(dateCreation.get(Calendar.MONTH)).append("/")
                .append(dateCreation.get(Calendar.YEAR));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportHeader that = (ReportHeader) o;
        if (year != that.year) return false;
        if (month != that.month) return false;
        return Objects.equals(dateCreation, that.dateCreation);
    }

    @Override
    public int hashCode() {
        int result = month != null ? month.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        return result;
    }
}
