package test.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.excel.FuelSummaryExcelBuilder;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class FuelSummaryExcelBuilderTest {
    private FuelSummaryExcelBuilder builder = new FuelSummaryExcelBuilder();

    @Test
    public void testBuild() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        FuelSummary fuelSummary = parser.parseFuelSummary(data);
        HSSFWorkbook workbook = builder.build(fuelSummary);
        ExcelFileWriter excelWriter = new ExcelFileWriter();
        excelWriter.write(workbook, "Fuel.xls");
    }
}