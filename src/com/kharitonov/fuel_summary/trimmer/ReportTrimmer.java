package com.kharitonov.fuel_summary.trimmer;

import com.kharitonov.fuel_summary.constant.RegexContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportTrimmer {
    public String trimUseless(String data) {
        String finalRegex =
                String.format("(%s)|(%s)|(%s)(%s)|(%s)|(%s)|(%s)|(%s)|(%s)",
                RegexContainer.REGEX_TRIP,
                RegexContainer.REGEX_TRUCK_SUMMARY,
                RegexContainer.DRIVERS_TEXT,
                RegexContainer.REGEX_DRIVER,
                RegexContainer.REGEX_HEADER,
                RegexContainer.REGEX_FUEL_SUMMARY,
                RegexContainer.SUMMARY_TEXT,
                RegexContainer.REGEX_FUEL,
                RegexContainer.CAR_NUMBER);
        Pattern pattern = Pattern.compile(finalRegex);
        Matcher matcher = pattern.matcher(data);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append("\n");
        }
        return sb.toString();
    }
}
