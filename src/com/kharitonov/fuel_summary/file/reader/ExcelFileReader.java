package com.kharitonov.fuel_summary.file.reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelFileReader {
    public Workbook read(String fileName) {
        Workbook workbook = null;
        try (FileInputStream inputStream =
                     new FileInputStream(new File(fileName))) {
            String format = fileName.split("\\.")[1];
            if (format.equals("xls")) {
                workbook = new HSSFWorkbook(inputStream);
            }
            if (format.equals("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

}
