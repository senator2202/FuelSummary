package test.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.excel.TSExcelUpdater;
import com.kharitonov.text_editor.exception.ProjectException;
import com.kharitonov.text_editor.file.reader.ExcelFileReader;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class TSExcelUpdaterTest {
    TSExcelUpdater updater = new TSExcelUpdater();

    @Test
    public void testUpdate() throws ProjectException {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        FuelSummary fuelSummary = parser.parseFuelSummary(data);
        ExcelFileReader excelReader = new ExcelFileReader();
        HSSFWorkbook workbook = excelReader.read("resources\\ТО-1-2 2020.xls");
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        updater.update(workbook, fuelSummary);
        excelFileWriter.write(workbook,"TS.xls");
    }
}