package test.kharitonov.text_editor.excel;

import com.kharitonov.text_editor.entity.report.Report52;
import com.kharitonov.text_editor.excel.FuelBalanceExcelBuilder;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class FuelBalanceExcelBuilderTest {
    private FuelBalanceExcelBuilder builder = new FuelBalanceExcelBuilder();

    @Test
    public void testBuild() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        HSSFWorkbook workbook = builder.build(report52);
        ExcelFileWriter excelWriter = new ExcelFileWriter();
        excelWriter.write(workbook, "Fuel.xls");
    }
}