package com.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Map;
import java.util.TreeMap;

public class Report52ExcelBuilder {
    private static final int START_INDEX = 4;
    private static final int HEADER_ROW_INDEX = 0;
    private static final int CREATION_DATE_ROW_INDEX = 1;
    private static final int UNITED_CELL_INDEX = 0;
    private static final String SHEET_NAME = "Default";
    private static final String MONTH_YEAR_TEXT =
            "СВЕДЕНИЯ О РАСХОДЕ ТОПЛИВА ЗА %s %d ГОД";
    private static final String CREATION_DATE =
            "ДАТА СЧЕТА %s";
    private static final int DATE_COLUMN_INDEX = 0;
    private static final int OFFICIAL_BILL_ID_INDEX = 1;
    private static final int WAY_BILL_PACK_INDEX = 2;
    private static final int WAY_BILL_ID_INDEX = 3;
    private static final int DRIVER_NAME_INDEX = 4;
    private static final int DRIVER_ID_INDEX = 5;
    private static final int KILOMETRAGE_INDEX = 6;
    private static final int CARGO_TRAFFIC_INDEX = 7;
    private static final int RIDERS_NUMBER_INDEX = 8;
    private static final int FUEL_START_INDEX = 9;
    private static final int RECEIVED_FUEL_INDEX = 10;
    private static final int RECEIVED_FUEL_OFFICIAL_INDEX = 11;
    private static final int FUEL_END_INDEX = 12;
    private static final int USAGE_NORMAL_INDEX = 13;
    private static final int USAGE_WAY_BILL_INDEX = 14;
    private static final int ECONOMY_INDEX = 15;
    private static final int TRUCK_SUMMARY_START_INDEX = 0;
    private static final int ROW_DELTA = 2;
    private static final String TRUCK_SUMMARY_START_TEXT =
            "С  %d ПО %d ГАРАЖНЫЙ НОМЕР %d КОД МАРКИ %d";
    private static final int UNITED_REGION_START = 0;
    private static final int UNITED_REGION_END = 5;
    private static final String CAR_NUMBER_TEXT =
            "ГОСУДАРСТВЕННЫЙ НOМЕР %s";
    private static final int SUMMARY_START_INDEX = 0;
    private static final String DRIVER_SUMMARY_TEXT =
            "В ТОМ ЧИСЛЕ ПО ВОДИТЕЛЯМ";

    public void fillReport(Workbook workbook, Report52 report52) {
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        updateHeader(workbook, report52);
        Map<Integer, ReportContext> map = new TreeMap<>();
        Row row;
        int counter = START_INDEX;
        map.putAll(report52.getTripMap());
        map.putAll(report52.getCarSummaryMap());
        for (ReportContext value : map.values()) {
            if (value instanceof Trip) {
                row = sheet.createRow(counter);
                addTrip(row, (Trip) value);
                counter++;
            } else {
                CarSummary carSummary = (CarSummary) value;
                counter = addTruckSummary(sheet, counter, carSummary);
                counter = addTruckDriverSummaries(sheet, counter,
                        carSummary);
            }
        }
        addReportSummary(sheet, counter, report52.getSummary());
    }

    private void addReportSummary(Sheet sheet, int rowIndex,
                                  Report52Summary summary) {
        Row row = sheet.createRow(++rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        Cell cell = row.createCell(SUMMARY_START_INDEX);
        cell.setCellValue(Report52Summary.getSummaryLabel());
        for (FuelSummary fuelSummary : summary.getFuelSummaryList()) {
            row = sheet.createRow(++rowIndex);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                    UNITED_REGION_START, UNITED_REGION_END));
            cell = row.createCell(SUMMARY_START_INDEX);
            cell.setCellValue(fuelSummary.getFuelType().getStringValue());
            cell = row.createCell(KILOMETRAGE_INDEX);
            cell.setCellValue(fuelSummary.getKilometrage());
            cell = row.createCell(CARGO_TRAFFIC_INDEX);
            cell.setCellValue(fuelSummary.getCargoTraffic());
            cell = row.createCell(RIDERS_NUMBER_INDEX);
            cell.setCellValue(fuelSummary.getRidersNumber());
            cell = row.createCell(RECEIVED_FUEL_INDEX);
            cell.setCellValue(fuelSummary.getFuelReceived());
            cell = row.createCell(RECEIVED_FUEL_OFFICIAL_INDEX);
            cell.setCellValue(fuelSummary.getFuelReceivedOfficial());
            cell = row.createCell(USAGE_NORMAL_INDEX);
            cell.setCellValue(fuelSummary.getFuelUsage().getNormalUsage());
            cell = row.createCell(USAGE_WAY_BILL_INDEX);
            cell.setCellValue(fuelSummary.getFuelUsage().getWayBillUsage());
            cell = row.createCell(ECONOMY_INDEX);
            cell.setCellValue(fuelSummary.getEconomy());
        }
    }

    private int addTruckSummary(Sheet sheet, int rowIndex,
                                CarSummary carSummary) {
        Row row = sheet.createRow(rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        int dayFirst = carSummary.getDayFirst();
        int dayLast = carSummary.getDayLast();
        int garageNumber = carSummary.getCar().getGarageNumber();
        int modelCode = carSummary.getCar().getModelCode();
        String text = String.format(TRUCK_SUMMARY_START_TEXT,
                dayFirst, dayLast, garageNumber, modelCode);
        Cell cell = row.createCell(TRUCK_SUMMARY_START_INDEX);
        cell.setCellValue(text);
        cell = row.createCell(KILOMETRAGE_INDEX);
        cell.setCellValue(carSummary.getKilometrage());
        cell = row.createCell(CARGO_TRAFFIC_INDEX);
        cell.setCellValue(carSummary.getCargoTraffic());
        cell = row.createCell(RIDERS_NUMBER_INDEX);
        cell.setCellValue(carSummary.getRidersNumber());
        cell = row.createCell(FUEL_START_INDEX);
        cell.setCellValue(carSummary.getFuelBalance().getFuelStart());
        cell = row.createCell(RECEIVED_FUEL_INDEX);
        cell.setCellValue(carSummary.getFuelBalance().getReceivedFuel());
        cell = row.createCell(RECEIVED_FUEL_OFFICIAL_INDEX);
        cell.setCellValue(carSummary.getFuelBalance()
                .getReceivedFuelOfficial());
        cell = row.createCell(FUEL_END_INDEX);
        cell.setCellValue(carSummary.getFuelBalance().getFuelEnd());
        cell = row.createCell(USAGE_NORMAL_INDEX);
        cell.setCellValue(carSummary.getFuelUsage().getNormalUsage());
        cell = row.createCell(USAGE_WAY_BILL_INDEX);
        cell.setCellValue(carSummary.getFuelUsage().getWayBillUsage());
        cell = row.createCell(ECONOMY_INDEX);
        cell.setCellValue(carSummary.getFuelUsage().getNormalUsage() -
                carSummary.getFuelUsage().getWayBillUsage());
        row = sheet.createRow(++rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        text = String.format(CAR_NUMBER_TEXT,
                carSummary.getCar().getStateNumber());
        cell = row.createCell(TRUCK_SUMMARY_START_INDEX);
        cell.setCellValue(text);
        return ++rowIndex;
    }

    private int addTruckDriverSummaries(Sheet sheet, int rowIndex,
                                        CarSummary carSummary) {
        if (carSummary.getCarDriverSummaryList().size() > 1) {
            Row row = sheet.createRow(rowIndex);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                    UNITED_REGION_START, UNITED_REGION_END));
            Cell cell = row.createCell(UNITED_REGION_START);
            cell.setCellValue(DRIVER_SUMMARY_TEXT);
            for (CarDriverSummary summary :
                    carSummary.getCarDriverSummaryList()) {
                int tempInt;
                double tempDouble;
                String text = summary.getDriver().getName();
                row = sheet.createRow(++rowIndex);
                cell = row.createCell(DRIVER_NAME_INDEX);
                cell.setCellValue(text);
                tempInt = summary.getDriver().getId();
                cell = row.createCell(DRIVER_ID_INDEX);
                cell.setCellValue(tempInt);
                tempDouble = summary.getKilometrage();
                cell = row.createCell(KILOMETRAGE_INDEX);
                cell.setCellValue(tempDouble);
                tempInt = summary.getCargoTraffic();
                cell = row.createCell(CARGO_TRAFFIC_INDEX);
                cell.setCellValue(tempInt);
                tempDouble = summary.getFuelReceived();
                cell = row.createCell(RECEIVED_FUEL_INDEX);
                cell.setCellValue(tempDouble);
                tempDouble = summary.getFuelUsage().getNormalUsage();
                cell = row.createCell(USAGE_NORMAL_INDEX);
                cell.setCellValue(tempDouble);
                tempDouble = summary.getFuelUsage().getWayBillUsage();
                cell = row.createCell(USAGE_WAY_BILL_INDEX);
                cell.setCellValue(tempDouble);
                tempDouble = summary.getEconomy();
                cell = row.createCell(ECONOMY_INDEX);
                cell.setCellValue(tempDouble);
            }
            rowIndex += ROW_DELTA;
        }
        return rowIndex;
    }

    private void addTrip(Row row, Trip trip) {
        try {
            Cell cell = row.createCell(DATE_COLUMN_INDEX);
            cell.setCellValue(trip.getDate());
            cell = row.createCell(OFFICIAL_BILL_ID_INDEX);
            if (trip.getOfficialBill().getId() != 0) {
                cell.setCellValue(trip.getOfficialBill().getId());
            }
            cell = row.createCell(WAY_BILL_PACK_INDEX);
            cell.setCellValue(trip.getWayBill().getPack());
            cell = row.createCell(WAY_BILL_ID_INDEX);
            cell.setCellValue(trip.getWayBill().getId());
            cell = row.createCell(DRIVER_NAME_INDEX);
            cell.setCellValue(trip
                    .getDriver().getName());
            cell = row.createCell(DRIVER_ID_INDEX);
            cell.setCellValue(trip.getDriver().getId());
            cell = row.createCell(KILOMETRAGE_INDEX);
            cell.setCellValue(trip.getKilometrage());
            cell = row.createCell(CARGO_TRAFFIC_INDEX);
            cell.setCellValue(trip.getCargoTraffic());
            cell = row.createCell(RIDERS_NUMBER_INDEX);
            cell.setCellValue(trip.getRidersNumber());
            cell = row.createCell(FUEL_START_INDEX);
            cell.setCellValue(trip.getFuelStart());
            cell = row.createCell(RECEIVED_FUEL_INDEX);
            cell.setCellValue(trip.getWayBill().getFuelReceived());
            cell = row.createCell(RECEIVED_FUEL_OFFICIAL_INDEX);
            cell.setCellValue(trip.getOfficialBill().getFuelReceived());
            cell = row.createCell(FUEL_END_INDEX);
            cell.setCellValue(trip.getFuelEnd());
            cell = row.createCell(USAGE_NORMAL_INDEX);
            cell.setCellValue(trip.getFuelUsage().getNormalUsage());
            cell = row.createCell(USAGE_WAY_BILL_INDEX);
            cell.setCellValue(trip.getFuelUsage().getWayBillUsage());
            cell = row.createCell(ECONOMY_INDEX);
            cell.setCellValue(trip.getFuelEconomy());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateHeader(Workbook workbook, Report52 report52) {
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        updateMonthAndYear(sheet, report52);
        updateCreationDate(sheet, report52);
    }

    private void updateMonthAndYear(Sheet sheet, Report52 report52) {
        Row row = sheet.getRow(HEADER_ROW_INDEX);
        Cell cell = row.getCell(UNITED_CELL_INDEX);
        String month = report52.getHeader().getMonth().getValue();
        int year = report52.getHeader().getYear();
        String text = String.format(MONTH_YEAR_TEXT, month, year);
        cell.setCellValue(text);
    }

    private void updateCreationDate(Sheet sheet, Report52 report52) {
        Row row = sheet.getRow(CREATION_DATE_ROW_INDEX);
        Cell cell = row.getCell(UNITED_CELL_INDEX);
        String creationDate = report52.getHeader().getStringDateCreation();
        String text = String.format(CREATION_DATE, creationDate);
        cell.setCellValue(text);
    }
}
