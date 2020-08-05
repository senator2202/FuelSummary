package com.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.entity.report.CarDriverSummary;
import com.kharitonov.fuel_summary.entity.report.CarSummary;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class FuelBalanceExcelBuilder {
    private static final int HEADER_ROW_INDEX = 0;
    private static final String SHEET_NAME = "Default";
    private static final String NUMBER_COLUMN = "  Гар. №  ";
    private static final String DRIVER_COLUMN = "      Водитель      ";
    private static final String ECONOMY_COLUMN = "Экономия/перерасход";
    private static final String LAST_WAY_BILL_COLUMN = "Последняя путевка";
    private static final short NUMBER_INDEX = 0;
    private static final short DRIVER_INDEX = 1;
    private static final short ECONOMY_INDEX = 2;
    private static final short LAST_WAY_BILL_INDEX = 3;
    private static final short HEADER_FONT_SIZE = 250;
    private static final short CELL_FONT_SIZE = 220;
    private static final String FONT_NAME = "Times New Roman";
    private static final String DELIMITER = ".";

    public HSSFWorkbook build(Report52 report52) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        createHeader(workbook);
        createSummary(workbook, report52);
        return workbook;
    }

    private void createHeader(Workbook workbook) {
        Sheet sheet = workbook.createSheet(SHEET_NAME);
        Row row = sheet.createRow(HEADER_ROW_INDEX);
        CellStyle style = createHeaderStyle(workbook);
        createHeaderCells(row);
        applyStyle(sheet, row, style);
    }

    private void createSummary(Workbook workbook, Report52 report52) {
        int counter = 1;
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        for (CarSummary carSummary : report52.getCarSummaryList()) {
            int garageNumber = carSummary.getCar().getGarageNumber();
            int lastDay = carSummary.getDayLast();
            for (CarDriverSummary summary :
                    carSummary.getCarDriverSummaryList()) {
                String driverName = summary.getDriver().getName();
                double economy = summary.getEconomy();
                Row row = sheet.createRow(counter++);
                CellStyle style = createCellStyle(workbook);
                StringBuilder sb = new StringBuilder();
                sb.append(lastDay).append(DELIMITER)
                        .append(report52.getHeader().getMonth().getIndex())
                        .append(DELIMITER)
                        .append(report52.getHeader().getYear());
                row.createCell(NUMBER_INDEX).setCellValue(garageNumber);
                row.createCell(DRIVER_INDEX)
                        .setCellValue(new HSSFRichTextString(driverName));
                row.createCell(ECONOMY_INDEX)
                        .setCellValue(economy);
                row.createCell(LAST_WAY_BILL_INDEX)
                        .setCellValue(new HSSFRichTextString(sb.toString()));
                applyStyle(sheet, row, style);
            }
        }
    }

    private CellStyle createHeaderStyle(Workbook workbook) {
        Font font = workbook.createFont();
        CellStyle style = workbook.createCellStyle();
        font.setBold(true);
        font.setFontHeight(HEADER_FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private void createHeaderCells(Row row) {
        row.createCell(NUMBER_INDEX)
                .setCellValue(new HSSFRichTextString(NUMBER_COLUMN));
        row.createCell(DRIVER_INDEX)
                .setCellValue(new HSSFRichTextString(DRIVER_COLUMN));
        row.createCell(ECONOMY_INDEX)
                .setCellValue(new HSSFRichTextString(ECONOMY_COLUMN));
        row.createCell(LAST_WAY_BILL_INDEX)
                .setCellValue(new HSSFRichTextString(LAST_WAY_BILL_COLUMN));
    }

    private void applyStyle(Sheet sheet, Row row, CellStyle style) {
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell((short) i);
            cell.setCellStyle(style);
            sheet.autoSizeColumn((short) i);
        }
    }

    private CellStyle createCellStyle(Workbook workbook) {
        Font font = workbook.createFont();
        CellStyle style = workbook.createCellStyle();
        font.setFontHeight(CELL_FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
}
