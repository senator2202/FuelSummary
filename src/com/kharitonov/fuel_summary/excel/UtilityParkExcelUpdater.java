package com.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.CarSummary;
import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.type.CarType;
import com.kharitonov.fuel_summary.type.FuelType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Iterator;
import java.util.List;

public class UtilityParkExcelUpdater {
    private static final String SHEET_NAME = "Default";
    private static final int INDEX_DELTA = 3;
    private static final int GARAGE_NUMBER_INDEX = 2;
    private static final int START_ROW_INDEX = 4;
    private static final int PASSENGER_SUMMARY_ROW_INDEX = 9;
    private static final int PETROL_SUMMARY_ROW_INDEX = 15;
    private static final int DIESEL_SUMMARY_ROW_INDEX = 16;

    public void update(HSSFWorkbook workbook, Report52 report52) {
        updateContextRows(workbook, report52);
        updateFuelSummary(workbook, report52);
    }

    private void updateContextRows(HSSFWorkbook workbook, Report52 report52) {
        List<CarSummary> carSummaryList = report52.getUtilityCarSummaryList();
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        Iterator<CarSummary> carSummaryIterator = carSummaryList.iterator();
        int monthIndex = report52.getHeader().getMonth().getIndex();
        int fuelUsageIndex = (monthIndex - 1) * 2 + INDEX_DELTA;
        int kilometrageIndex = fuelUsageIndex + 1;
        while (carSummaryIterator.hasNext()) {
            int rowIndex = START_ROW_INDEX;
            HSSFRow row = sheet.getRow(rowIndex);
            CarSummary carSummary = carSummaryIterator.next();
            int garageNumber;
            HSSFCell cell;
            while (rowIndex < sheet.getLastRowNum()) {
                try {
                    row = sheet.getRow(rowIndex);
                    garageNumber = (int) row.getCell(GARAGE_NUMBER_INDEX)
                            .getNumericCellValue();
                    if (garageNumber == carSummary.getCar().getGarageNumber()) {
                        break;
                    } else {
                        ++rowIndex;
                    }
                } catch (Exception ex) {
                    ++rowIndex;
                }
            }
            cell = row.createCell(kilometrageIndex);
            cell.setCellValue(carSummary.getKilometrage());
            cell = row.createCell(fuelUsageIndex);
            cell.setCellValue(carSummary.getFuelUsage().getWayBillUsage());
        }
    }

    private void updateFuelSummary(HSSFWorkbook workbook, Report52 report52) {
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        HSSFRow row;
        HSSFCell cell;
        double petrolSum = 0;
        double dieselSum = 0;
        double passengerSum = 0;
        int monthIndex = report52.getHeader().getMonth().getIndex();
        int fuelColumnIndex = (monthIndex - 1) * 2 + INDEX_DELTA;
        for (CarSummary carSummary : report52.getUtilityCarSummaryList()) {
            if (carSummary.getCar().getFuelType() == FuelType.AI_95 ||
                    carSummary.getCar().getFuelType() == FuelType.AI_92) {
                petrolSum += carSummary.getFuelUsage().getWayBillUsage();
            } else {
                dieselSum += carSummary.getFuelUsage().getWayBillUsage();
            }
            if (carSummary.getCar().getCarType() == CarType.PASSENGER_CAR) {
                passengerSum += carSummary.getFuelUsage().getWayBillUsage();
            }
        }
        row = sheet.getRow(PASSENGER_SUMMARY_ROW_INDEX);
        cell = row.createCell(fuelColumnIndex);
        cell.setCellValue(passengerSum);
        row = sheet.getRow(PETROL_SUMMARY_ROW_INDEX);
        cell = row.createCell(fuelColumnIndex);
        cell.setCellValue(petrolSum);
        row = sheet.getRow(DIESEL_SUMMARY_ROW_INDEX);
        cell = row.createCell(fuelColumnIndex);
        cell.setCellValue(dieselSum);
    }
}
