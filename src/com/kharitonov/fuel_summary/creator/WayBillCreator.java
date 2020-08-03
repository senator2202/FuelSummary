package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.entity.bill.WayBill;

public class WayBillCreator {
    WayBill create(String id,
                   String pack,
                   String fuelReceived,
                   String fuelReturned) {
        int intPack;
        int intId;
        double doubleFuelReceived;
        double doubleFuelReturned;
        intPack = pack == null
                ? 0
                : Integer.parseInt(pack);
        intId = id == null
                ? 0
                : Integer.parseInt(id);
        doubleFuelReceived = Double.parseDouble(fuelReceived);
        doubleFuelReturned = Double.parseDouble(fuelReturned);
        return new WayBill(intPack, intId, doubleFuelReceived,
                doubleFuelReturned);
    }
}
