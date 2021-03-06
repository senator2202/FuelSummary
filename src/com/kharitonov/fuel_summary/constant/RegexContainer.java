package com.kharitonov.fuel_summary.constant;

public class RegexContainer {
    public static final String REGEX_TRIP =
            "(?<dateTrip>\\d\\d\\.\\d\\d)(\\s{5})" +
                    "(?<officialBillId>\\d)?(\\s+)" +
                    "(?<pack>\\d+)?(\\s+)" +
                    "(?<wayBillId>\\d+)?(\\s+)" +
                    "(?<driverNameTrip>\\p{L}+\\s\\p{L}[\\s\\.]\\p{L}\\.?)(\\s+)" +
                    "(?<driverIdTrip>\\d+)(\\s+)" +
                    "(?<kilometrageTrip>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTrafficTrip>\\d+)(\\s+)" +
                    "(?<ridersNumberTrip>\\d+)?(\\s+)" +
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
                    "(?<fuelEconomy>-?\\d+\\.\\d+)(\\s+)" +
                    "((ГОСУДАРСТВЕННЫЙ\\sНOМЕР\\s)" +
                    "(?<carNumber>(\\p{L}{2}\\s?\\d{2}-?\\d{2}-?\\d?)" +
                    "|(\\d\\d-\\d\\d\\p{L}\\p{L}\\d)" +
                    "|(\\d{4}\\p{L}{2}-\\d)))?";
    public static final String CAR_NUMBER =
            "(ГОСУДАРСТВЕННЫЙ\\sНOМЕР\\s)" +
                    "(?<carNumberSolo>(\\p{L}{2}\\s?\\d{2}-?\\d{2}-?\\d?)" +
                    "|(\\d\\d-\\d\\d\\p{L}\\p{L}\\d)" +
                    "|(\\d{4}\\p{L}{2}-\\d))";
    public static final String DRIVERS_TEXT =
            "(В\\sТОМ\\sЧИСЛЕ\\sПО\\sВОДИТЕЛЯМ)";
    public static final String REGEX_DRIVER =
            "(?<nameDriver>\\p{L}+\\s\\p{L}[\\s\\.]\\p{L}\\.?)(\\s+)" +
                    "(?<idDriver>\\d+)(\\s+)" +
                    "(?<kilometrageDriver>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTrafficDriver>\\d+)(\\s+)" +
                    "(?<fuelReceivedDriver>\\d+\\.\\d+)(\\s+)" +
                    "(?<fuelReturnedDriver>\\d+)(\\s+)" +
                    "(?<usageNormalDriver>\\d+\\.\\d+)(\\s+)" +
                    "(?<usageWayBillDriver>\\d+\\.\\d+)(\\s+)" +
                    "(?<economyDriver>-?\\d+\\.\\d+)";
    public static final String REGEX_HEADER =
            "(?<month>\\p{L}+)(\\s+)" +
                    "(?<year>\\d+)(\\s+ГОД\\s+\\d+\\s+ДАТА\\sСЧЕТА\\s)" +
                    "(?<dateCreation>\\d{1,2}/\\d{2}/\\d{2})(\\s+ЛИСТ\\s+1)";
    public static final String REGEX_FUEL =
            "(?<fuelType>(БЕНЗИН АИ-92)|(БЕНЗИН АИ-95)|(ДИЗТОПЛИВО))" +
                    "(?=\\s+\\d{2}\\.\\d{2})";
    public static final String SUMMARY_TEXT =
            "ИТОГО ПО АП";
    public static final String REGEX_FUEL_SUMMARY =
            "(?<fuelTypeSummary>(БЕНЗИН АИ-92)|(БЕНЗИН АИ-95)|(ДИЗТОПЛИВО))(\\s+)" +
                    "(?<kilometrageSummary>\\d+\\.?\\d?)(\\s+)" +
                    "(?<ridersNumberSummary>\\d+)?(\\s+)" +
                    "(?<fuelReceivedSummary>\\d+\\.\\d+)(\\s+)" +
                    "(?<fuelReturnedSummary>\\d+\\.?\\d?)(\\s+)" +
                    "(?<usageWayBillSummary>\\d+\\.\\d+)(\\s+)" +
                    "(?<cargoTrafficSummary>\\d+)(\\s+)" +
                    "(?<fuelReceivedOfficialSummary>\\d+\\.\\d+)(\\s+\\d+\\s+)" +
                    "(?<usageNormalSummary>\\d+\\.\\d+)(\\s+)" +
                    "(?<economySummary>\\d+\\.\\d+)";

    private RegexContainer() {
    }
}
