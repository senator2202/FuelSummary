package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.file.reader.DosFileReader;
import com.kharitonov.text_editor.file.writer.ProjectFileWriter;
import com.kharitonov.text_editor.parser.ReportParser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;

public class Main {
    public static void main(String[] args) {
        DosFileReader reader = new DosFileReader();
        String data = reader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        ReportParser parser = new ReportParser();
        FuelSummary fuelSummary = parser.parseFuelSummary(data);
        ProjectFileWriter writer = new ProjectFileWriter();
        writer.write(fuelSummary, "Fuel.txt");
    }
}
