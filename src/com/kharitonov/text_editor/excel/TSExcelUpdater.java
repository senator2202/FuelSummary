package com.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.entity.TruckSummary;
import com.kharitonov.text_editor.exception.ProjectException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Iterator;

public class TSExcelUpdater {
    private static final String SHEET_NAME = "Default";
    private static final int DELTA = 1;
    private static final short START_INDEX = 0;
    private static final int TRUCK_INDEX_START = 3;
    private static final int TRUCK_INDEX_END = 38;
    private static final int[] EXCLUDE_INDEXES = {6, 7, 11};
    private static final int ROUND_KOEFF = 1000;
    private static final short TS_1_INDEX = 14;
    private static final short TS_2_INDEX = 15;
    private static final short SUMM_INDEX = 39;

    public HSSFWorkbook update(HSSFWorkbook workbook, FuelSummary fuelSummary)
            throws ProjectException {
        HSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        Iterator<HSSFRow> rowIterator = sheet.rowIterator();
        Iterator<TruckSummary> truckSummaryIterator =
                fuelSummary.getTruckSummaryList().iterator();
        short columnIndex = (short) (fuelSummary.getHeader().getMonth()
                .getIndex() + DELTA);
        while (truckSummaryIterator.hasNext()) {
            HSSFRow row = rowIterator.next();
            TruckSummary truckSummary = truckSummaryIterator.next();
            try {
                while (!isRequiredIndex(row.getRowNum()) ||
                        truckSummary.getTruck().getGarageNumber() !=
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
                    .setCellValue(truckSummary.getKilometrage() / ROUND_KOEFF);
            tSValue1 = row.getCell(TS_1_INDEX).getNumericCellValue();
            tSValue2 = row.getCell(TS_2_INDEX).getNumericCellValue();
            tSValue1 += truckSummary.getKilometrage() / ROUND_KOEFF;
            tSValue2 += truckSummary.getKilometrage() / ROUND_KOEFF;
            row.getCell(TS_1_INDEX).setCellValue(tSValue1);
            row.getCell(TS_2_INDEX).setCellValue(tSValue2);
        }
        HSSFRow row = sheet.getRow(SUMM_INDEX);
        String formula = row.getCell(columnIndex).getCellFormula();
        String formulaGeneral = row.getCell(TS_1_INDEX).getCellFormula();
        row.getCell(columnIndex).setCellFormula(formula);
        row.getCell(TS_1_INDEX).setCellFormula(formulaGeneral);
        return workbook;
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
