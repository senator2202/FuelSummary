package com.kharitonov.fuel_summary.creator;

import com.kharitonov.fuel_summary.constant.GroupNames;
import com.kharitonov.fuel_summary.entity.TruckDriver;
import com.kharitonov.fuel_summary.entity.bill.OfficialBill;
import com.kharitonov.fuel_summary.entity.bill.WayBill;
import com.kharitonov.fuel_summary.entity.fuel.FuelUsage;
import com.kharitonov.fuel_summary.entity.report.Trip;

import java.util.regex.Matcher;

public class TripCreator {
    public Trip create(Matcher matcher) {
        String date = matcher.group(GroupNames.DATE_TRIP);
        String officialBillId = matcher.group(GroupNames.OFFICIAL_BILL_ID);
        String pack = matcher.group(GroupNames.PACK);
        String wayBillId = matcher.group(GroupNames.WAY_BILL_ID);
        String driverName = matcher.group(GroupNames.DRIVER_NAME_TRIP);
        String driverId = matcher.group(GroupNames.DRIVER_ID_TRIP);
        String kilometrage = matcher.group(GroupNames.KILOMETRAGE_TRIP);
        String cargoTraffic = matcher.group(GroupNames.CARGO_TRAFFIC_TRIP);
        String ridersNumber = matcher.group(GroupNames.RIDERS_NUMBER_TRIP);
        String fuelStart = matcher.group(GroupNames.FUEL_START_TRIP);
        String receivedFuel = matcher.group(GroupNames.RECEIVED_FUEL_TRIP);
        String receivedFuelOfficial = matcher
                .group(GroupNames.RECEIVED_FUEL_OFFICIAL_TRIP);
        String returnedFuel = matcher.group(GroupNames.RETURNED_FUEL_TRIP);
        String returnedFuelOfficial = matcher
                .group(GroupNames.RETURNED_FUEL_OFFICIAL_TRIP);
        String fuelEnd = matcher.group(GroupNames.FUEL_END_TRIP);
        String usageNormal = matcher.group(GroupNames.USAGE_NORMAL_TRIP);
        String usageWayBill = matcher.group(GroupNames.USAGE_WAY_BILL_TRIP);
        String fuelEconomy = matcher.group(GroupNames.FUEL_ECONOMY_TRIP);
        OfficialBill officialBill = new OfficialBillCreator()
                .create(officialBillId, receivedFuelOfficial,
                        returnedFuelOfficial);
        WayBill wayBill = new WayBillCreator().create(pack, wayBillId,
                receivedFuel, returnedFuel);
        TruckDriver truckDriver =
                new TruckDriverCreator().create(driverId, driverName);
        FuelUsage fuelUsage =
                new FuelUsageCreator().create(usageNormal, usageWayBill);
        int numberOfRiders = ridersNumber == null || ridersNumber.isEmpty()
                ? 0
                : Integer.parseInt(ridersNumber);
        return Trip.TripBuilder.aTrip()
                .withReportPosition(matcher.start())
                .withDate(date)
                .withOfficialBill(officialBill)
                .withWayBill(wayBill)
                .withDriver(truckDriver)
                .withFuelUsage(fuelUsage)
                .withKilometrage(Double.parseDouble(kilometrage))
                .withCargoTraffic(Integer.parseInt(cargoTraffic))
                .withRidersNumber(numberOfRiders)
                .withFuelStart(Double.parseDouble(fuelStart))
                .withFuelEnd(Double.parseDouble(fuelEnd))
                .withFuelEconomy(Double.parseDouble(fuelEconomy))
                .build();
    }
}
