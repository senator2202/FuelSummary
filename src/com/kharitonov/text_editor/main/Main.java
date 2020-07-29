package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.excel.WorkBookBuilder;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.ReportParser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {
    public static void main(String[] args) {
        ProjectFileReader reader = new ProjectFileReader();
        String data = reader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        ReportParser parser = new ReportParser();
        FuelSummary fuelSummary = parser.parseFuelSummary(data);
        WorkBookBuilder workBookBuilder = new WorkBookBuilder();
        HSSFWorkbook workbook = workBookBuilder.build(fuelSummary);
        ExcelFileWriter excelWriter = new ExcelFileWriter();
        excelWriter.write(workbook,"Fuel.xls");
    }
}
