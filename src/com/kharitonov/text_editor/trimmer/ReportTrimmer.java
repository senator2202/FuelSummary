package com.kharitonov.text_editor.trimmer;

import com.kharitonov.text_editor.regex.RegexContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportTrimmer {
    public String trimUseless(String data) {
        String finalRegex = String.format("(?<trip>%s)|" +
                        "(?<truckSummary>%s)|" +
                        "(?<driversText>%s)|" +
                        "(?<driver>%s)|" +
                        "(?<header>%s)",
                RegexContainer.REGEX_TRIP,
                RegexContainer.REGEX_TRUCK_SUMMARY,
                RegexContainer.DRIVERS_TEXT,
                RegexContainer.REGEX_DRIVER,
                RegexContainer.REGEX_HEADER);
        Pattern pattern = Pattern.compile(finalRegex);
        Matcher matcher = pattern.matcher(data);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append("\n");
        }
        return sb.toString();
    }
}
