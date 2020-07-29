package com.kharitonov.text_editor.file.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProjectFileReader {
    public String read(String fileName) {
        String data = new String();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName),
                        "x-MacCyrillic"))) {
            String sub;
            while ((sub = br.readLine()) != null) {
                data = String.format("%s%s\n", data, sub);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
