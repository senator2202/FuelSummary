package com.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.entity.TruckSummary;
import org.apache.poi.hssf.usermodel.*;

import java.util.Map;

public class WorkBookBuilder {
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

    public HSSFWorkbook build(FuelSummary fuelSummary) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        createHeader(workbook);
        createSummary(workbook, fuelSummary);
        return workbook;
    }

    private void createHeader(HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        HSSFRow row = sheet.createRow(HEADER_ROW_INDEX);
        HSSFCellStyle style = createHeaderStyle(workbook);
        createHeaderCells(row);
        applyStyle(sheet, row, style);
    }

    private void createSummary(HSSFWorkbook workbook, FuelSummary fuelSummary) {
        int counter = 1;
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        for (TruckSummary truckSummary : fuelSummary.getTruckSummaryList()) {
            int garageNumber = truckSummary.getTruck().getGarageNumber();
            int lastDay = truckSummary.getDayLast();
            for (Map.Entry<TruckDriver, Double> entry :
                    truckSummary.getFuelEconomy().entrySet()) {
                String driverName = entry.getKey().getName();
                Double economy = entry.getValue();
                HSSFRow row = sheet.createRow(counter++);
                HSSFCellStyle style = createCellStyle(workbook);
                StringBuilder sb = new StringBuilder();
                sb.append(lastDay).append(DELIMITER)
                        .append(fuelSummary.getHeader().getMonth().getIndex())
                        .append(DELIMITER)
                        .append(fuelSummary.getHeader().getYear());
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

    private HSSFCellStyle createHeaderStyle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        HSSFCellStyle style = workbook.createCellStyle();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeight(HEADER_FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        return style;
    }

    private void createHeaderCells(HSSFRow row) {
        row.createCell(NUMBER_INDEX)
                .setCellValue(new HSSFRichTextString(NUMBER_COLUMN));
        row.createCell(DRIVER_INDEX)
                .setCellValue(new HSSFRichTextString(DRIVER_COLUMN));
        row.createCell(ECONOMY_INDEX)
                .setCellValue(new HSSFRichTextString(ECONOMY_COLUMN));
        row.createCell(LAST_WAY_BILL_INDEX)
                .setCellValue(new HSSFRichTextString(LAST_WAY_BILL_COLUMN));
    }

    private void applyStyle(HSSFSheet sheet, HSSFRow row, HSSFCellStyle style) {
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = row.getCell((short) i);
            cell.setCellStyle(style);
            sheet.autoSizeColumn((short) i);
        }
    }

    private HSSFCellStyle createCellStyle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        HSSFCellStyle style = workbook.createCellStyle();
        font.setFontHeight(CELL_FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        return style;
    }
}
