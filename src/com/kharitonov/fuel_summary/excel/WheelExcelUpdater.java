package com.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.CarSummary;
import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.entity.vehicle.TrailerTruck;
import org.apache.poi.ss.usermodel.*;

import java.util.Iterator;
import java.util.List;

public class WheelExcelUpdater {
    private static final String CAR_NUMBER_HEADER = "Гос номер";
    private static final String SPACE = " ";
    private static final int CAR_NUMBER_HEADER_ROW_LENGTH = 2;
    private static final int ROUNDER_KOEFF = 1000;
    private static final int TOTAL_KILOMETRAGE_ROW = 15;
    private static final int TOTAL_KILOMETRAGE_COLUMN = 6;

    public void update(Workbook workbook, Report52 report52) {
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        String stateNumber = new String();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String month = report52.getHeader().getMonth()
                        .getValue().toLowerCase();
                String year = String
                        .valueOf(report52.getHeader().getYear());
                String compareString = month + SPACE + year;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() != CellType.STRING) {
                        continue;
                    }
                    String cellValue = cell.getStringCellValue();
                    if (cellValue.equals(CAR_NUMBER_HEADER)) {
                        int rowNum = row.getRowNum() +
                                CAR_NUMBER_HEADER_ROW_LENGTH;
                        int columnNum = cell.getColumnIndex();
                        Row tempRow = sheet.getRow(rowNum);
                        Cell tempCell = tempRow.getCell(columnNum);
                        stateNumber = tempCell.getStringCellValue();
                    }
                    if (cellValue.equals(compareString)) {
                        CarSummary carSummary =
                                findCarSummary(report52.getCarSummaryList(),
                                        stateNumber);
                        Row tempRow = sheet.getRow(TOTAL_KILOMETRAGE_ROW);
                        Cell tempCell =
                                tempRow.getCell(TOTAL_KILOMETRAGE_COLUMN);
                        FormulaEvaluator evaluator =
                                workbook.getCreationHelper()
                                        .createFormulaEvaluator();
                        double kilometrage = carSummary == null
                                ? 0
                                : carSummary.getKilometrage();
                        cell = cellIterator.next();
                        cell.setCellValue(kilometrage / ROUNDER_KOEFF);
                        if (tempCell.getCellType() == CellType.FORMULA) {
                            evaluator.evaluateFormulaCell(tempCell);
                        }
                    }
                }
            }
        }
    }

    private CarSummary findCarSummary(List<CarSummary> list, String stateNumber) {
        for (CarSummary carSummary : list) {
            if (carSummary.getCar().getStateNumber().equals(stateNumber) ||
                    (carSummary.getCar() instanceof TrailerTruck &&
                            ((TrailerTruck) carSummary.getCar()).getTrailer()
                                    .getStateNumber().equals(stateNumber))) {
                return carSummary;
            }
        }
        return null;
    }
}
