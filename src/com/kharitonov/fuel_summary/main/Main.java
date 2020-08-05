package com.kharitonov.fuel_summary.main;

import com.kharitonov.fuel_summary.entity.report.Report52;
import com.kharitonov.fuel_summary.excel.TSExcelUpdater;
import com.kharitonov.fuel_summary.exception.ProjectException;
import com.kharitonov.fuel_summary.file.reader.ExcelFileReader;
import com.kharitonov.fuel_summary.file.reader.ProjectFileReader;
import com.kharitonov.fuel_summary.file.writer.ExcelFileWriter;
import com.kharitonov.fuel_summary.parser.Report52Parser;
import com.kharitonov.fuel_summary.trimmer.ReportTrimmer;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {
    public static void main(String[] args) throws ProjectException {
        ProjectFileReader fileReader = new ProjectFileReader();
        String data = fileReader.read("resources\\JUNE52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        Report52Parser parser = new Report52Parser();
        Report52 report52 = parser.parseReport52(data);
        ExcelFileReader excelReader = new ExcelFileReader();
        Workbook workbook = excelReader.read("resources\\ТО-1-2 2020.xls");
        TSExcelUpdater tsExcelUpdater = new TSExcelUpdater();
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        tsExcelUpdater.update(workbook, report52);
        excelFileWriter.write(workbook, "TS.xls");
    }
}
