package com.kharitonov.fuel_summary.file.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileWriter {
    public void write(HSSFWorkbook workbook, String fileName) {
        try (FileOutputStream out = new FileOutputStream(new File(fileName))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
