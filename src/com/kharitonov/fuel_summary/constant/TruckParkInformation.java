package com.kharitonov.fuel_summary.constant;

import com.kharitonov.fuel_summary.type.FuelType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckParkInformation {
    private static final Map<Integer, FuelType> fuelMap;
    private static final List<Integer> utilityParkList;

    static {
        fuelMap = new HashMap<>();
        fuelMap.put(10014, FuelType.AI_92);
        fuelMap.put(11118, FuelType.AI_92);
        fuelMap.put(10049, FuelType.AI_95);
        fuelMap.put(10332, FuelType.DIESEL);
        fuelMap.put(10367, FuelType.DIESEL);
        fuelMap.put(10987, FuelType.DIESEL);
        fuelMap.put(11606, FuelType.DIESEL);
        fuelMap.put(11614, FuelType.DIESEL);
        fuelMap.put(11622, FuelType.DIESEL);
        fuelMap.put(11721, FuelType.DIESEL);
        fuelMap.put(11738, FuelType.DIESEL);
        fuelMap.put(11746, FuelType.DIESEL);
        fuelMap.put(11754, FuelType.DIESEL);
        fuelMap.put(11771, FuelType.DIESEL);
        fuelMap.put(11789, FuelType.DIESEL);
        fuelMap.put(11801, FuelType.DIESEL);
        fuelMap.put(11819, FuelType.DIESEL);
        fuelMap.put(11827, FuelType.DIESEL);
        fuelMap.put(12238, FuelType.DIESEL);
        fuelMap.put(12246, FuelType.DIESEL);
        fuelMap.put(12254, FuelType.DIESEL);
        fuelMap.put(12262, FuelType.DIESEL);
        fuelMap.put(12271, FuelType.DIESEL);
        fuelMap.put(12289, FuelType.DIESEL);
        fuelMap.put(12301, FuelType.DIESEL);
        fuelMap.put(12319, FuelType.DIESEL);
        fuelMap.put(12327, FuelType.DIESEL);
        fuelMap.put(12335, FuelType.DIESEL);
        fuelMap.put(12343, FuelType.DIESEL);
        fuelMap.put(12350, FuelType.DIESEL);
        fuelMap.put(13064, FuelType.DIESEL);
        fuelMap.put(13072, FuelType.DIESEL);
        fuelMap.put(14915, FuelType.DIESEL);
        utilityParkList = new ArrayList<>();
        utilityParkList.add(10014);
        utilityParkList.add(10049);
        utilityParkList.add(11118);
        utilityParkList.add(14915);
    }

    public static FuelType getFuelType(int garageNumber) {
        return fuelMap.get(garageNumber);
    }

    public static boolean isUtilityTruck(int garageNumber) {
        return utilityParkList.contains(garageNumber);
    }
}
