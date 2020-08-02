package test.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.report.Report52;
import com.kharitonov.text_editor.excel.Report52ExcelBuilder;
import com.kharitonov.text_editor.file.reader.ExcelFileReader;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class Report52ExcelBuilderTest {
    final Report52ExcelBuilder builder = new Report52ExcelBuilder();

    @Test
    public void testBuild() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JUNE52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader reader = new ExcelFileReader();
        HSSFWorkbook workbook = reader.read("resources\\Report52Base.xls");
        builder.fillReport(workbook, report52);
        ExcelFileWriter writer = new ExcelFileWriter();
        writer.write(workbook, "Report52.xls");
    }
}