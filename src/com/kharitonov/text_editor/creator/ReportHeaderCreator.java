package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.ReportHeader;
import com.kharitonov.text_editor.type.MonthRussian;

import java.util.Calendar;
import java.util.regex.Matcher;

public class ReportHeaderCreator {
    public ReportHeader create(Matcher matcher) {
        String stringMonth = matcher.group("month");
        String stringYear = matcher.group("year");
        String dateCreation = matcher.group("dateCreation");
        MonthRussian monthRussian = MonthRussian.getMonth(stringMonth);
        int year = Integer.parseInt(stringYear);
        Calendar calendar = Calendar.getInstance();
        String[] date = dateCreation.split("/");
        int dayCreation = Integer.parseInt(date[0]);
        int monthCreation = Integer.parseInt(date[1]);
        int yearCreation = Integer.parseInt(date[2]);
        calendar.set(yearCreation, monthCreation, dayCreation);
        return new ReportHeader(monthRussian, year, calendar);
    }
}
