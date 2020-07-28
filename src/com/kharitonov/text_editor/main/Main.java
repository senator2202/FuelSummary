package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.entity.TruckSummary;
import com.kharitonov.text_editor.file.reader.DosFileReader;
import com.kharitonov.text_editor.file.writer.ProjectFileWriter;
import com.kharitonov.text_editor.parser.ReportParser;
import com.kharitonov.text_editor.trimmer.ReportTrimmer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DosFileReader reader = new DosFileReader();
        String data = reader.read("resources\\JULY52");
        ReportTrimmer trimmer = new ReportTrimmer();
        data = trimmer.trimUseless(data);
        ReportParser parser = new ReportParser();
        List<TruckSummary> truckSummaryList = parser.parseTruckSummaries(data);
        ProjectFileWriter writer =new ProjectFileWriter();
        writer.write(truckSummaryList,"Fuel.txt");
    }
}
