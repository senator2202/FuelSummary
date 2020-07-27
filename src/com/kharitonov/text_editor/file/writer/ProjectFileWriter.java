package com.kharitonov.text_editor.file.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProjectFileWriter {
    public boolean write(String  data, String fileName) {
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(fileName)) {
            fileOutputStream.write(data.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
