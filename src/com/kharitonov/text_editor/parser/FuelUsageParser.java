package com.kharitonov.text_editor.parser;

import com.kharitonov.text_editor.entity.FuelUsage;

public class FuelUsageParser {
    public static FuelUsage parse(String usageNormal, String usageWayBill) {
        double doubleUsageNormal;
        double doubleUsageWayBill;
        doubleUsageNormal = Double.parseDouble(usageNormal);
        doubleUsageWayBill = Double.parseDouble(usageWayBill);
        return new FuelUsage(doubleUsageNormal, doubleUsageWayBill);
    }
}
