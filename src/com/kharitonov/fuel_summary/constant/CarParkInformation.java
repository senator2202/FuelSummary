package com.kharitonov.fuel_summary.constant;

import com.kharitonov.fuel_summary.entity.Car;
import com.kharitonov.fuel_summary.type.CarType;
import com.kharitonov.fuel_summary.type.FuelType;

import java.util.ArrayList;
import java.util.List;

public class CarParkInformation {
    private static final List<Car> carList;

    static {
        carList = new ArrayList<>();
        carList.add(new Car("АА6622-7", 10049, 220030, FuelType.AI_92,
                CarType.TRUCK, true));
        carList.add(new Car("80-28АЕ7", 11118, 113080, FuelType.AI_92,
                CarType.PASSENGER_CAR, true));
        carList.add(new Car("0014II-7", 10014, 113001, FuelType.AI_95,
                CarType.PASSENGER_CAR, true));
        carList.add(new Car("KM 2290", 10332, 322773, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("KI 0839", 10367, 322773, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("КЕ 0098", 10987, 322780, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АВ5980-7", 11606, 330599, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АВ5978-7", 11614, 330598, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АВ5981-7", 11622, 330598, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АК0119-7", 11721, 330602, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АК0118-7", 11738, 330602, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АК0116-7", 11746, 310900, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АК1122-7", 11754, 330599, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АМ3434-7", 11771, 330598, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("AM9776-7", 11789, 330599, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("AM9778-7", 11801, 330599, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АH3129-7", 11819, 330602, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АН5270-7", 11827, 330602, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АI1336-7", 12238, 330600, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АI1335-7", 12246, 330600, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АI4259-7", 12254, 330601, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АI4258-7", 12262, 330601, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("AP0194-7", 12271, 330601, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АМ3459-7", 12289, 330600, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АН0243-7", 12301, 330600, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АC1817-7", 12319, 330605, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АC1818-7", 12327, 330605, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АC3419-7", 12335, 330606, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АC3420-7", 12343, 330606, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("АT0777-7", 12350, 330610, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("AC1659-7", 13064, 340502, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("AC1994-7", 13072, 340502, FuelType.DIESEL,
                CarType.TRUCK, false));
        carList.add(new Car("КС 22-61", 14915, 361526, FuelType.DIESEL,
                CarType.TRUCK, true));
    }

    public static FuelType getFuelType(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car.getFuelType();
            }
        }
        return null;
    }

    public static CarType getCarType(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car.getCarType();
            }
        }
        return null;
    }

    public static boolean isUtilityTruck(int garageNumber) {
        for (Car car : carList) {
            if (car.getGarageNumber() == garageNumber) {
                return car.isUtility();
            }
        }
        return false;
    }
}
