package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.GroupNames;
import com.kharitonov.fuel_summary.entity.report.ReportHeader;
import com.kharitonov.fuel_summary.type.MonthRussian;

import java.util.Calendar;
import java.util.regex.Matcher;

public class ReportHeaderCreator {
    public ReportHeader create(Matcher matcher) {
        String stringMonth = matcher.group(GroupNames.MONTH);
        String stringYear = matcher.group(GroupNames.YEAR);
        String dateCreation = matcher.group(GroupNames.DATE_CREATION);
        MonthRussian monthRussian = MonthRussian.getMonth(stringMonth);
        int year = Integer.parseInt(stringYear);
        Calendar calendar = Calendar.getInstance();
        String delimiter = "/";
        String[] date = dateCreation.split(delimiter);
        int dayCreation = Integer.parseInt(date[0]);
        int monthCreation = Integer.parseInt(date[1]);
        int yearCreation = Integer.parseInt(date[2]);
        calendar.set(yearCreation, monthCreation, dayCreation);
        return new ReportHeader(monthRussian, year, calendar);
    }
}
