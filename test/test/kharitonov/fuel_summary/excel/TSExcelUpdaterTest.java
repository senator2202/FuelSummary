package test.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.excel.TSExcelUpdater;
import com.kharitonov.fuel_summary.exception.ProjectException;
import com.kharitonov.fuel_summary.file.reader.ExcelFileReader;
import com.kharitonov.fuel_summary.file.reader.ProjectFileReader;
import com.kharitonov.fuel_summary.file.writer.ExcelFileWriter;
import com.kharitonov.fuel_summary.parser.Report52Parser;
import com.kharitonov.fuel_summary.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class TSExcelUpdaterTest {
    private final TSExcelUpdater updater = new TSExcelUpdater();

    @Test
    public void testUpdate() throws ProjectException {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader excelReader = new ExcelFileReader();
        HSSFWorkbook workbook = excelReader.read("resources\\ТО-1-2 2020.xls");
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        updater.update(workbook, report52);
        excelFileWriter.write(workbook, "ТО-1-2 2020.xls");
    }
}