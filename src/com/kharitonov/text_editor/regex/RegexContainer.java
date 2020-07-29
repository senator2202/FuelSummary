package com.kharitonov.text_editor.regex;

public class RegexContainer {
    public static final String REGEX_TRIP =
            "(?<date>\\d\\d\\.\\d\\d)(\\s+)" +
                    "(?<officialBillId>\\d?)(\\s+)" +
                    "(?<pack>\\d+)(\\s+)" +
                    "(?<wayBillId>\\d+)(\\s+)" +
                    "(?<driverNameTrip>\\p{L}+\\s\\p{L}[\\s\\.]\\p{L}\\.?)(\\s+)" +
                    "(?<driverIdTrip>\\d+)(\\s+)" +
                    "(?<kilometrageTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTrafficTrip>\\d+)(\\s+)" +
                    "(?<ridersNumberTrip>\\d)?(\\s+)" +
                    "(?<fuelStartTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<receivedFuelTrip>\\d+\\.\\d?)(\\s+)" +
                    "(?<receivedFuelOfficialTrip>\\d+\\.\\d?)(\\s+)" +
                    "(?<returnedFuelTrip>\\d+)(\\s+)" +
                    "(?<returnedFuelOfficialTrip>\\d+)(\\s+)" +
                    "(?<fuelEndTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageNormalTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageWayBillTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<fuelEconomyTrip>-?\\d+\\.\\d+)";
    public static final String REGEX_TRUCK_SUMMARY =
            "(С\\s+)" +
                    "(?<dayFirst>\\d+)(\\sПО\\s?)" +
                    "(?<dayLast>\\d+)(\\sГАРАЖ.НОМЕР\\s+)" +
                    "(?<garageNumber>\\d+)(\\sКОД МАРКИ\\s)" +
                    "(?<modelCode>\\d+)(\\s+)" +
                    "(?<kilometrage>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTraffic>\\d+)(\\s+)" +
                    "(?<ridersNumber>\\d+)?(\\s+)" +
                    "(?<fuelStart>\\d+\\.\\d+)(\\s+)" +
                    "(?<receivedFuel>\\d+\\.\\d?)(\\s+)" +
                    "(?<receivedFuelOfficial>\\d+\\.+d?)(\\s+)" +
                    "(?<returnedFuel>\\d+)(\\s+)" +
                    "(?<returnedFuelOfficial>\\d+)(\\s+)" +
                    "(?<fuelEnd>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageNormal>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageWayBill>\\d+\\.\\d+)(\\s+)" +
                    "(?<fuelEconomy>-?\\d+\\.\\d+)" +
                    "(\\s+ГОСУДАРСТВЕННЫЙ\\sНOМЕР\\s)" +
                    "(?<carNumber>\\p{L}\\p{L}\\s?\\d\\d-?\\d\\d-?\\d?)";
    public static final String DRIVERS_TEXT =
            "(В\\sТОМ\\sЧИСЛЕ\\sПО\\sВОДИТЕЛЯМ)";
    public static final String REGEX_DRIVER =
            "(?<driverName>\\p{L}+\\s\\p{L}[\\s\\.]\\p{L}\\.?)(\\s+)" +
                    "(?<driverId>\\d+)(\\s+\\d+\\.\\d+\\s+\\s+\\d+\\s+\\d+\\.\\d+\\s+\\d+\\s+\\d+\\.\\d+\\s+\\d+\\.\\d+\\s+)" +
                    "(?<driverEconomy>-?\\d+\\.\\d+)";
    public static final String REGEX_HEADER =
            "(?<month>\\p{L}+)(\\s+)" +
                    "(?<year>\\d+)(\\s+ГОД\\s+\\d+\\s+ДАТА\\sСЧЕТА\\s)" +
                    "(?<dateCreation>\\d{1,2}/\\d{2}/\\d{2})(\\s+ЛИСТ\\s+1)";
    public static final String REGEX_MONTH_YEAR =
                    "(?<month>\\p{L}+)(\\s+)" +
                    "(?<year>\\d+)(\\s+ГОД)";
    public static final String REGEX_DATE_CREATION =
            "(?<dateCreation>\\d{1,2}/\\d{2}/\\d{2})";
}
