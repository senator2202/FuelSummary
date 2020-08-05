package com.kharitonov.fuel_summary.constant;

import com.kharitonov.fuel_summary.entity.vehicle.*;
import com.kharitonov.fuel_summary.type.FuelType;

import java.util.ArrayList;
import java.util.List;

public class CarParkInformation {
    private static final List<Car> carList;

    static {
        Trailer trailer;
        carList = new ArrayList<>();
        carList.add(new UtilityCar("АА 6622-7", 10049, 220030, FuelType.AI_92));
        carList.add(new UtilityCar("80-28АЕ7", 11118, 113080, FuelType.AI_92));
        carList.add(new UtilityCar("II 0014-7", 10014, 113001, FuelType.AI_95));
        trailer = new Trailer("45-11 KA", 19320, 610222);
        carList.add(new TrailerTruck("KM 2290", 10332, 322773,
                FuelType.DIESEL, trailer));
        trailer = new Trailer("A3175A-7", 19526, 610503);
        carList.add(new TrailerTruck("KI 0839", 10367, 322773,
                FuelType.DIESEL, trailer));
        trailer = new Trailer("A1927A-7", 19259, 610225);
        carList.add(new TrailerTruck("KE 0098", 10987, 322780,
                FuelType.DIESEL, trailer));
        carList.add(new DumpTruck("AB 5980-7", 11606, 330599, FuelType.DIESEL));
        carList.add(new DumpTruck("AB 5978-7", 11614, 330598, FuelType.DIESEL));
        carList.add(new DumpTruck("AB 5981-7", 11622, 330598, FuelType.DIESEL));
        carList.add(new DumpTruck("AK 0119-7", 11721, 330602, FuelType.DIESEL));
        carList.add(new DumpTruck("АК 0118-7", 11738, 330602, FuelType.DIESEL));
        carList.add(new DumpTruck("АК 0116-7", 11746, 310900, FuelType.DIESEL));
        carList.add(new DumpTruck("АК 1122-7", 11754, 330599, FuelType.DIESEL));
        carList.add(new DumpTruck("AM 3434-7", 11771, 330598, FuelType.DIESEL));
        carList.add(new DumpTruck("AM 9776-7", 11789, 330599, FuelType.DIESEL));
        carList.add(new DumpTruck("AM 9778-7", 11801, 330599, FuelType.DIESEL));
        carList.add(new DumpTruck("AH 3129-7", 11819, 330602, FuelType.DIESEL));
        carList.add(new DumpTruck("AH 5270-7", 11827, 330602, FuelType.DIESEL));
        carList.add(new DumpTruck("AI 1336-7", 12238, 330600, FuelType.DIESEL));
        carList.add(new DumpTruck("AI 1335-7", 12246, 330600, FuelType.DIESEL));
        carList.add(new DumpTruck("AI 4259-7", 12254, 330601, FuelType.DIESEL));
        carList.add(new DumpTruck("AI 4258-7", 12262, 330601, FuelType.DIESEL));
        carList.add(new DumpTruck("AP 0194-7", 12271, 330601, FuelType.DIESEL));
        carList.add(new DumpTruck("AM 3459-7", 12289, 330600, FuelType.DIESEL));
        carList.add(new DumpTruck("AH 0243-7", 12301, 330600, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 1817-7", 12319, 330605, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 1818-7", 12327, 330605, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 3419-7", 12335, 330606, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 3420-7", 12343, 330606, FuelType.DIESEL));
        carList.add(new DumpTruck("AT 0777-7", 12350, 330610, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 1659-7", 13064, 340502, FuelType.DIESEL));
        carList.add(new DumpTruck("AC 1994-7", 13072, 340502, FuelType.DIESEL));
        carList.add(new UtilityCar("KC 2261", 14915, 361526, FuelType.DIESEL));
    }

    private CarParkInformation() {
    }

    public static FuelType getFuelType(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car.getFuelType();
            }
        }
        return null;
    }

    public static boolean isUtilityTruck(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car instanceof UtilityCar;
            }
        }
        return false;
    }

    public static Car getCar(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car;
            }
        }
        return null;
    }
}
