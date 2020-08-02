package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.entity.report.Report52;
import com.kharitonov.text_editor.excel.TSExcelUpdater;
import com.kharitonov.text_editor.exception.ProjectException;
import com.kharitonov.text_editor.file.reader.ExcelFileReader;
import com.kharitonov.text_editor.file.reader.ProjectFileReader;
import com.kharitonov.text_editor.file.writer.ExcelFileWriter;
import com.kharitonov.text_editor.parser.Report52Parser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {
    public static void main(String[] args) throws ProjectException {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JUNE52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader excelReader = new ExcelFileReader();
        HSSFWorkbook workbook = excelReader.read("resources\\ТО-1-2 2020.xls");
        TSExcelUpdater tsExcelUpdater = new TSExcelUpdater();
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        tsExcelUpdater.update(workbook, report52);
        excelFileWriter.write(workbook, "TS.xls");
    }
}
