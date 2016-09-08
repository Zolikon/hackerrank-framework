package com.zolikon.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
public class ConsoleWriter {

    private boolean isInputCounted = false;
    private InputHolder inputHolder;
    private ConsoleWriter() {
        inputHolder = InputHolder.init();
    }

    public static ConsoleWriter init() {
        return new ConsoleWriter();
    }

    public ConsoleWriter addInput(Object line, Object... lines) {
        inputHolder.addInput(line);
        for (Object oneLine : lines) {
            inputHolder.addInput(oneLine);
        }
        return this;
    }

    public ConsoleWriter addInputCounter() {
        inputHolder.addCounter();
        return this;
    }

    public void fromFile(String fileName) {
        URL url = ConsoleWriter.class.getClassLoader().getResource(fileName);
        try {
            InputStream input = new BufferedInputStream(new FileInputStream(new File(url.toURI())));
            // readSourceFile(url);
            System.setIn(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readSourceFile(URL url) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(url.toURI())));
        // ignore first line
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            inputHolder.addInput(line);
        }
        inputHolder.finishInput();
        reader.close();
    }

    public void finish() {
        inputHolder.finishInput();
        String inputAsString = inputHolder.toString();
        StringBufferInputStream s = new StringBufferInputStream(inputAsString);
        System.setIn(s);
    }

}
