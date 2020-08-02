package com.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.report.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Map;
import java.util.TreeMap;

public class Report52ExcelBuilder {
    private static final int START_INDEX = 4;
    private static final int HEADER_ROW_INDEX = 0;
    private static final int CREATION_DATE_ROW_INDEX = 1;
    private static final short UNITED_CELL_INDEX = 0;
    private static final String SHEET_NAME = "Default";
    private static final String MONTH_YEAR_TEXT =
            "СВЕДЕНИЯ О РАСХОДЕ ТОПЛИВА ЗА %s %d ГОД";
    private static final String CREATION_DATE =
            "ДАТА СЧЕТА %s";
    private static final short DATE_COLUMN_INDEX = 0;
    private static final short OFFICIAL_BILL_ID_INDEX = 1;
    private static final short WAY_BILL_PACK_INDEX = 2;
    private static final short WAY_BILL_ID_INDEX = 3;
    private static final short DRIVER_NAME_INDEX = 4;
    private static final short DRIVER_ID_INDEX = 5;
    private static final short KILOMETRAGE_INDEX = 6;
    private static final short CARGO_TRAFFIC_INDEX = 7;
    private static final short RIDERS_NUMBER_INDEX = 8;
    private static final short FUEL_START_INDEX = 9;
    private static final short RECEIVED_FUEL_INDEX = 10;
    private static final short RECEIVED_FUEL_OFFICIAL_INDEX = 11;
    private static final short FUEL_END_INDEX = 12;
    private static final short USAGE_NORMAL_INDEX = 13;
    private static final short USAGE_WAY_BILL_INDEX = 14;
    private static final short ECONOMY_INDEX = 15;
    private static final short TRUCK_SUMMARY_START_INDEX = 0;
    private static final String TRUCK_SUMMARY_START_TEXT =
            "С  %d ПО %d ГАРАЖНЫЙ НОМЕР %d КОД МАРКИ %d";
    private static final short UNITED_REGION_START = 0;
    private static final short UNITED_REGION_END = 5;
    private static final String CAR_NUMBER_TEXT =
            "ГОСУДАРСТВЕННЫЙ НOМЕР %s";
    private static final short SUMMARY_START_INDEX = 0;
    private static final String DRIVER_SUMMARY_TEXT =
            "В ТОМ ЧИСЛЕ ПО ВОДИТЕЛЯМ";

    public void fillReport(HSSFWorkbook workbook, Report52 report52) {
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        updateHeader(workbook, report52);
        Map<Integer, ReportContext> map = new TreeMap<>();
        HSSFRow row;
        int counter = START_INDEX;
        map.putAll(report52.getTripMap());
        map.putAll(report52.getTruckSummaryMap());
        for (ReportContext value : map.values()) {
            if (value instanceof Trip) {
                row = sheet.createRow(counter);
                addTrip(row, (Trip) value);
                counter++;
            } else {
                TruckSummary truckSummary = (TruckSummary) value;
                counter = addTruckSummary(sheet, counter, truckSummary);
                counter = addTruckDriverSummaries(sheet, counter,
                        truckSummary);
            }
        }
        addReportSummary(sheet, counter, report52.getSummary());
    }

    private void addReportSummary(HSSFSheet sheet, int rowIndex,
                                  Report52Summary summary) {
        HSSFRow row = sheet.createRow(++rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        HSSFCell cell = row.createCell(SUMMARY_START_INDEX);
        cell.setCellValue(new HSSFRichTextString(Report52Summary
                .getSummaryLabel()));
        for (FuelSummary fuelSummary : summary.getFuelSummaryList()) {
            row = sheet.createRow(++rowIndex);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                    UNITED_REGION_START, UNITED_REGION_END));
            cell = row.createCell(SUMMARY_START_INDEX);
            cell.setCellValue(new HSSFRichTextString(fuelSummary
                    .getFuelType().getStringValue()));
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

    private int addTruckSummary(HSSFSheet sheet, int rowIndex,
                                TruckSummary truckSummary) {
        HSSFRow row = sheet.createRow(rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        int dayFirst = truckSummary.getDayFirst();
        int dayLast = truckSummary.getDayLast();
        int garageNumber = truckSummary.getTruck().getGarageNumber();
        int modelCode = truckSummary.getTruck().getModelCode();
        String text = String.format(TRUCK_SUMMARY_START_TEXT,
                dayFirst, dayLast, garageNumber, modelCode);
        HSSFCell cell = row.createCell(TRUCK_SUMMARY_START_INDEX);
        cell.setCellValue(new HSSFRichTextString(text));
        cell = row.createCell(KILOMETRAGE_INDEX);
        cell.setCellValue(truckSummary.getKilometrage());
        cell = row.createCell(CARGO_TRAFFIC_INDEX);
        cell.setCellValue(truckSummary.getCargoTraffic());
        cell = row.createCell(RIDERS_NUMBER_INDEX);
        cell.setCellValue(truckSummary.getRidersNumber());
        cell = row.createCell(FUEL_START_INDEX);
        cell.setCellValue(truckSummary.getFuelBalance().getFuelStart());
        cell = row.createCell(RECEIVED_FUEL_INDEX);
        cell.setCellValue(truckSummary.getFuelBalance().getReceivedFuel());
        cell = row.createCell(RECEIVED_FUEL_OFFICIAL_INDEX);
        cell.setCellValue(truckSummary.getFuelBalance()
                .getReceivedFuelOfficial());
        cell = row.createCell(FUEL_END_INDEX);
        cell.setCellValue(truckSummary.getFuelBalance().getFuelEnd());
        cell = row.createCell(USAGE_NORMAL_INDEX);
        cell.setCellValue(truckSummary.getFuelUsage().getNormalUsage());
        cell = row.createCell(USAGE_WAY_BILL_INDEX);
        cell.setCellValue(truckSummary.getFuelUsage().getWayBillUsage());
        cell = row.createCell(ECONOMY_INDEX);
        cell.setCellValue(truckSummary.getFuelUsage().getNormalUsage() -
                truckSummary.getFuelUsage().getWayBillUsage());
        row = sheet.createRow(++rowIndex);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                UNITED_REGION_START, UNITED_REGION_END));
        text = String.format(CAR_NUMBER_TEXT,
                truckSummary.getTruck().getCarNumber());
        cell = row.createCell(TRUCK_SUMMARY_START_INDEX);
        cell.setCellValue(new HSSFRichTextString(text));
        return ++rowIndex;
    }

    private int addTruckDriverSummaries(HSSFSheet sheet, int rowIndex,
                                        TruckSummary truckSummary) {
        if (!truckSummary.getTruckDriverSummaryList().isEmpty()) {
            HSSFRow row = sheet.createRow(++rowIndex);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex,
                    UNITED_REGION_START, UNITED_REGION_END));
            HSSFCell cell = row.createCell(UNITED_REGION_START);
            cell.setCellValue(new HSSFRichTextString(DRIVER_SUMMARY_TEXT));
            for (TruckDriverSummary summary :
                    truckSummary.getTruckDriverSummaryList()) {
                int tempInt;
                double tempDouble;
                String text = summary.getDriver().getName();
                row = sheet.createRow(++rowIndex);
                cell = row.createCell(DRIVER_NAME_INDEX);
                cell.setCellValue(new HSSFRichTextString(text));
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
            ++rowIndex;
        }
        return rowIndex;
    }

    private void addTrip(HSSFRow row, Trip trip) {
        try {
            HSSFCell cell = row.createCell(DATE_COLUMN_INDEX);
            cell.setCellValue(new HSSFRichTextString(trip.getDate()));
            cell = row.createCell(OFFICIAL_BILL_ID_INDEX);
            if (trip.getOfficialBill().getId() != 0) {
                cell.setCellValue(trip.getOfficialBill().getId());
            }
            cell = row.createCell(WAY_BILL_PACK_INDEX);
            cell.setCellValue(trip.getWayBill().getPack());
            cell = row.createCell(WAY_BILL_ID_INDEX);
            cell.setCellValue(trip.getWayBill().getId());
            cell = row.createCell(DRIVER_NAME_INDEX);
            cell.setCellValue(new HSSFRichTextString(trip
                    .getDriver().getName()));
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

    private void updateHeader(HSSFWorkbook workbook, Report52 report52) {
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        updateMonthAndYear(sheet, report52);
        updateCreationDate(sheet, report52);
    }

    private void updateMonthAndYear(HSSFSheet sheet, Report52 report52) {
        HSSFRow row = sheet.getRow(HEADER_ROW_INDEX);
        HSSFCell cell = row.getCell(UNITED_CELL_INDEX);
        String month = report52.getHeader().getMonth().getValue();
        int year = report52.getHeader().getYear();
        String text = String.format(MONTH_YEAR_TEXT, month, year);
        cell.setCellValue(new HSSFRichTextString(text));
    }

    private void updateCreationDate(HSSFSheet sheet, Report52 report52) {
        HSSFRow row = sheet.getRow(CREATION_DATE_ROW_INDEX);
        HSSFCell cell = row.getCell(UNITED_CELL_INDEX);
        String creationDate = report52.getHeader().getStringDateCreation();
        String text = String.format(CREATION_DATE, creationDate);
        cell.setCellValue(new HSSFRichTextString(text));
    }
}
