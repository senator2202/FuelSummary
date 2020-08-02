package com.kharitonov.text_editor.creator;

import com.kharitonov.text_editor.entity.fuel.FuelUsage;
import com.kharitonov.text_editor.entity.report.FuelSummary;
import com.kharitonov.text_editor.type.FuelType;

import java.util.regex.Matcher;

public class FuelSummaryCreator {
    public FuelSummary create(Matcher matcher) {
        String fuelType = matcher.group("fuelTypeSummary");
        String kilometrage = matcher.group("kilometrageSummary");
        String ridersNumber = matcher.group("ridersNumberSummary");
        String fuelReceived = matcher.group("fuelReceivedSummary");
        String usageWayBill = matcher.group("usageWayBillSummary");
        String cargoTraffic = matcher.group("cargoTrafficSummary");
        String fuelReceivedOfficial =
                matcher.group("fuelReceivedOfficialSummary");
        String usageNormal = matcher.group("usageNormalSummary");
        String economy = matcher.group("economySummary");
        FuelUsage fuelUsage = new FuelUsage(Double.parseDouble(usageNormal),
                Double.parseDouble(usageWayBill));
        int riders = ridersNumber == null
                ? 0
                : Integer.parseInt(ridersNumber);
        return FuelSummary.FuelSummaryBuilder.aFuelSummary()
                .withFuelType(FuelType.getFuelType(fuelType))
                .withKilometrage(Double.parseDouble(kilometrage))
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withRidersNumber(riders)
                .withFuelReceived(Double.parseDouble(fuelReceived))
                .withFuelReceivedOfficial(Double
                        .parseDouble(fuelReceivedOfficial))
                .withFuelUsage(fuelUsage)
                .withEconomy(Double.parseDouble(economy))
                .build();
    }
}
