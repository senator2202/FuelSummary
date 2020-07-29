package com.kharitonov.text_editor.entity;

import com.kharitonov.text_editor.type.MonthRussian;

import java.util.Calendar;

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
}