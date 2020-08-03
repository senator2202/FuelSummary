package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.bill.OfficialBill;

public class OfficialBillCreator {
    OfficialBill create(String id,
                        String fuelReceived,
                        String fuelReturned) {
        double doubleFuelReceived;
        double doubleFuelReturned;
        int intId = id == null || id.isEmpty()
                ? 0
                : Integer.parseInt(id);
        doubleFuelReceived = Double.parseDouble(fuelReceived);
        doubleFuelReturned = Double.parseDouble(fuelReturned);
        return new OfficialBill(intId, doubleFuelReceived, doubleFuelReturned);
    }
}
