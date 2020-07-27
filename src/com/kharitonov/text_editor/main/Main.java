package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.entity.Trip;
import com.kharitonov.text_editor.file.parser.TripParser;
import com.kharitonov.text_editor.file.reader.DosFileReader;
import com.kharitonov.text_editor.file.writer.ProjectFileWriter;

import java.nio.charset.Charset;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        DosFileReader reader = new DosFileReader();
        String data = reader.read("resources\\JULY52");
        TripParser parser = new TripParser();
        List<Trip> tripList = parser.parse(data);
        ProjectFileWriter writer = new ProjectFileWriter();
        writer.write(data, "JULY52.txt");
        SortedMap<String, Charset> map = Charset.availableCharsets();
    }
}
