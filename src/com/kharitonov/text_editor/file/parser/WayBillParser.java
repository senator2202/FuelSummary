package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.WayBill;

public class WayBillParser {
    static WayBill parse(String id,
                         String pack,
                         String fuelReceived,
                         String fuelReturned) {
        int intPack ;
        int intId;
        double doubleFuelReceived;
        double doubleFuelReturned;
        intPack = Integer.parseInt(pack);
        intId = Integer.parseInt(id);
        doubleFuelReceived = Double.parseDouble(fuelReceived);
        doubleFuelReturned = Double.parseDouble(fuelReturned);
        return new WayBill(intPack, intId, doubleFuelReceived,
                doubleFuelReturned);
    }
}
