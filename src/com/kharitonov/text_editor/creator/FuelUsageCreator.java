package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.fuel.FuelUsage;

public class FuelUsageCreator {
    FuelUsage create(String usageNormal, String usageWayBill) {
        double doubleUsageNormal;
        double doubleUsageWayBill;
        doubleUsageNormal = Double.parseDouble(usageNormal);
        doubleUsageWayBill = Double.parseDouble(usageWayBill);
        return new FuelUsage(doubleUsageNormal, doubleUsageWayBill);
    }
}
