package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.OfficialBill;

public class OfficialBillCreator {
    OfficialBill create(String id,
                        String fuelReceived,
                        String fuelReturned) {
        double doubleFuelReceived;
        double doubleFuelReturned;
        int intId = id.isEmpty()
                ? 0
                : Integer.parseInt(id);
        doubleFuelReceived = Double.parseDouble(fuelReceived);
        doubleFuelReturned = Double.parseDouble(fuelReturned);
        return new OfficialBill(intId, doubleFuelReceived, doubleFuelReturned);
    }
}
