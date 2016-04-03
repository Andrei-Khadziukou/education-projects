package com.eu.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * The event logger to track information in log file.
 *
 * @author Andrei Khadziukou
 */
public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    private void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new RuntimeException("The app can not write to the file: " + fileName);
        }
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + '\n', true);
        } catch (IOException e) {
            System.err.println("The issue with writing event to file: " + fileName);
        }
    }
}
