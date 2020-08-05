package test.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.excel.Report52ExcelBuilder;
import com.kharitonov.fuel_summary.file.reader.ExcelFileReader;
import com.kharitonov.fuel_summary.file.reader.ProjectFileReader;
import com.kharitonov.fuel_summary.file.writer.ExcelFileWriter;
import com.kharitonov.fuel_summary.parser.Report52Parser;
import com.kharitonov.fuel_summary.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

public class Report52ExcelBuilderTest {
    final Report52ExcelBuilder builder = new Report52ExcelBuilder();

    @Test
    public void testBuild() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader reader = new ExcelFileReader();
        Workbook workbook = reader.read("resources\\Report52Base.xls");
        builder.fillReport(workbook, report52);
        ExcelFileWriter writer = new ExcelFileWriter();
        writer.write(workbook, "Report52.xls");
    }
}