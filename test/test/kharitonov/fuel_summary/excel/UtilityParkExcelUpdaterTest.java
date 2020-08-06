package test.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.excel.UtilityParkExcelUpdater;
import com.kharitonov.fuel_summary.file.reader.ExcelFileReader;
import com.kharitonov.fuel_summary.file.reader.ProjectFileReader;
import com.kharitonov.fuel_summary.file.writer.ExcelFileWriter;
import com.kharitonov.fuel_summary.parser.Report52Parser;
import com.kharitonov.fuel_summary.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UtilityParkExcelUpdaterTest {
    UtilityParkExcelUpdater updater = new UtilityParkExcelUpdater();

    @Test
    public void testUpdate() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader excelReader = new ExcelFileReader();
        Workbook workbook = excelReader.read("resources\\Хоз парк 2020.xlsx");
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        updater.update(workbook, report52);
        excelFileWriter.write(workbook, "Хоз парк 2020.xlsx");
    }
}