package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.FuelUsage;

public class FuelUsageParser {
    private static final String DOUBLE_DELIMITER = ".";

    public static FuelUsage parse(String usageNormal, String usageWayBill) {
        double doubleUsageNormal = 0;
        double doubleUsageWayBill = 0;
        try {
            doubleUsageNormal = Double.parseDouble(usageNormal);
        } catch (NumberFormatException e) {
            try {
                doubleUsageNormal = Double
                        .parseDouble(usageNormal
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        try {
            doubleUsageWayBill = Double.parseDouble(usageWayBill);
        } catch (NumberFormatException e) {
            try {
                doubleUsageWayBill = Double
                        .parseDouble(usageWayBill
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return new FuelUsage(doubleUsageNormal, doubleUsageWayBill);
    }
}
