package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.WayBill;

public class WayBillParser {
    private static final String DOUBLE_DELIMITER = ".";

    public static WayBill parse(String id,
                                String pack,
                                String fuelReceived,
                                String fuelReturned) {
        int intPack = 0;
        int intId = 0;
        double doubleFuelReceived = -1.1;
        double doubleFuelReturned = -1.1;
        try {
            intPack = Integer.parseInt(pack);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            doubleFuelReceived = Double.parseDouble(fuelReceived);
        } catch (NumberFormatException e) {
            try {
                doubleFuelReceived = Double
                        .parseDouble(fuelReceived
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        try {
            doubleFuelReturned = Double.parseDouble(fuelReturned);
        } catch (NumberFormatException e) {
            try {
                doubleFuelReturned = Double
                        .parseDouble(fuelReturned
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return new WayBill(intPack, intId, doubleFuelReceived,
                doubleFuelReturned);
    }
}
