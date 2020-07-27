package com.kharitonov.text_editor.file.parser;

import com.kharitonov.text_editor.entity.OfficialBill;

public class OfficialBillParser {
    private static final String DOUBLE_DELIMITER = ".";

    public static OfficialBill parse(String id,
                                     String fuelReceived,
                                     String fuelReturned) {
        int intId = -1;
        double intFuelReceived = -1.1;
        double intFuelReturned = -1.1;
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            intFuelReceived = Double.parseDouble(fuelReceived);
        } catch (NumberFormatException e) {
            try {
                intFuelReceived = Double
                        .parseDouble(fuelReceived
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        try {
            intFuelReturned = Double.parseDouble(fuelReturned);
        } catch (NumberFormatException e) {
            try {
                intFuelReturned = Double
                        .parseDouble(fuelReturned
                                .split(DOUBLE_DELIMITER)[0]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return new OfficialBill(intId, intFuelReceived, intFuelReturned);
    }
}
