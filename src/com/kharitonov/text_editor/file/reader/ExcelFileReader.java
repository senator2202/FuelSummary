package com.kharitonov.text_editor.file.reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelFileReader {
    public HSSFWorkbook read(String fileName) {
        HSSFWorkbook workbook = null;
        try (FileInputStream inputStream =
                     new FileInputStream(new File(fileName))) {
            workbook = new HSSFWorkbook(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
