package com.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.entity.report.CarSummary;
import com.kharitonov.fuel_summary.exception.ProjectException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;

public class TSExcelUpdater {
    private static final String SHEET_NAME = "Default";
    private static final int INDEX_DELTA = 1;
    private static final int START_INDEX = 0;
    private static final int TRUCK_INDEX_START = 3;
    private static final int TRUCK_INDEX_END = 38;
    private static final int[] EXCLUDE_INDEXES = {6, 7, 11};
    private static final int ROUND_KOEFF = 1000;
    private static final int TS_1_INDEX = 14;
    private static final int TS_2_INDEX = 15;
    private static final int SUM_INDEX = 39;

    public void update(Workbook workbook, Report52 report52)
            throws ProjectException {
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        Iterator<Row> rowIterator = sheet.rowIterator();
        Iterator<CarSummary> carSummaryIterator =
                report52.getCarSummaryList().iterator();
        int columnIndex = report52.getHeader().getMonth()
                .getIndex() + INDEX_DELTA;
        while (carSummaryIterator.hasNext()) {
            Row row = rowIterator.next();
            CarSummary carSummary = carSummaryIterator.next();
            try {
                while (!isRequiredIndex(row.getRowNum()) ||
                        carSummary.getCar().getGarageNumber() !=
                                (int) row.getCell(START_INDEX)
                                        .getNumericCellValue()) {
                    row = rowIterator.next();
                }
            } catch (Exception e) {
                throw new ProjectException("Invalid document structure!");
            }
            double tSValue1;
            double tSValue2;
            row.getCell(columnIndex)
                    .setCellValue(carSummary.getKilometrage() / ROUND_KOEFF);
            tSValue1 = row.getCell(TS_1_INDEX).getNumericCellValue();
            tSValue2 = row.getCell(TS_2_INDEX).getNumericCellValue();
            tSValue1 += carSummary.getKilometrage() / ROUND_KOEFF;
            tSValue2 += carSummary.getKilometrage() / ROUND_KOEFF;
            row.getCell(TS_1_INDEX).setCellValue(tSValue1);
            row.getCell(TS_2_INDEX).setCellValue(tSValue2);
        }
        Row row = sheet.getRow(SUM_INDEX);
        FormulaEvaluator evaluator =
                workbook.getCreationHelper()
                        .createFormulaEvaluator();
        evaluator.evaluateFormulaCell(row.getCell(columnIndex));
        evaluator.evaluateFormulaCell(row.getCell(TS_1_INDEX));
    }

    private boolean isRequiredIndex(int index) {
        return index >= TRUCK_INDEX_START &&
                index <= TRUCK_INDEX_END &&
                !excludedIndex(index);
    }

    private boolean excludedIndex(int index) {
        for (int excludeIndex : EXCLUDE_INDEXES) {
            if (excludeIndex == index) {
                return true;
            }
        }
        return false;
    }
}
