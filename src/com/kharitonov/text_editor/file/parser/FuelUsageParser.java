package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.FuelUsage;

public class FuelUsageParser {
    static FuelUsage parse(String usageNormal, String usageWayBill) {
        double doubleUsageNormal;
        double doubleUsageWayBill;
        doubleUsageNormal = Double.parseDouble(usageNormal);
        doubleUsageWayBill = Double.parseDouble(usageWayBill);
        return new FuelUsage(doubleUsageNormal, doubleUsageWayBill);
    }
}
