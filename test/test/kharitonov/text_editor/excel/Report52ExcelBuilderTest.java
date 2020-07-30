package test.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.excel.Report52ExcelBuilder;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class Report52ExcelBuilderTest {
    Report52ExcelBuilder builder = new Report52ExcelBuilder();

    @Test
    public void testBuild() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JUNE52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        FuelSummary fuelSummary = parser.parseFuelSummary(data);
        HSSFWorkbook workbook = builder.build(fuelSummary);
        /*ExcelFileWriter writer = new ExcelFileWriter();
        writer.write(workbook,"Report52.xls");*/
    }
}