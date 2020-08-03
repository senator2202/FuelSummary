package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;

public class FuelUsageCreator {
    FuelUsage create(String usageNormal, String usageWayBill) {
        double doubleUsageNormal;
        double doubleUsageWayBill;
        doubleUsageNormal = Double.parseDouble(usageNormal);
        doubleUsageWayBill = Double.parseDouble(usageWayBill);
        return new FuelUsage(doubleUsageNormal, doubleUsageWayBill);
    }
}
