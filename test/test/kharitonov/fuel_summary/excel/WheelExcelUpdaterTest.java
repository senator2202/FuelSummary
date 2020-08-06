package test.kharitonov.fuel_summary.excel;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.excel.WheelExcelUpdater;
import com.kharitonov.fuel_summary.file.reader.ExcelFileReader;
import com.kharitonov.fuel_summary.file.reader.ProjectFileReader;
import com.kharitonov.fuel_summary.file.writer.ExcelFileWriter;
import com.kharitonov.fuel_summary.parser.Report52Parser;
import com.kharitonov.fuel_summary.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class WheelExcelUpdaterTest {
    WheelExcelUpdater updater = new WheelExcelUpdater();

    @Test
    public void testUpdate() {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        File dir = new File("resources\\wheels"); //path указывает на директорию
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        for (File file : lst) {
            String filename = file.getName();
            ExcelFileReader excelReader = new ExcelFileReader();
            Workbook workbook = excelReader.read("resources\\wheels\\"+filename);
            ExcelFileWriter excelFileWriter = new ExcelFileWriter();
            updater.update(workbook, report52);
            excelFileWriter.write(workbook, "wheels\\"+filename);
        }

    }
}