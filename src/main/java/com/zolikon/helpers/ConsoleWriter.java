package com.zolikon.helpers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
public class ConsoleWriter {

    private StringBuilder builder;
    private int inputCounter = 0;

    private ConsoleWriter() {
        this.builder = new StringBuilder();
    }
    public static ConsoleWriter init() {
        return new ConsoleWriter();
    }

    public ConsoleWriter addLines(String line, String... lines) {
        builder.append(line + "\n");
        inputCounter++;
        for (String oneLine : lines) {
            builder.append(oneLine + "\n");
            inputCounter++;
        }
        return this;
    }

    public ConsoleWriter addInputCounter() {
        builder.append("%s ");
        return this;
    }

    public ConsoleWriter addInt(int... number) {
        for (int i = 0; i < number.length; i++) {
            builder.append(number[i] + " ");
        }
        inputCounter = number.length;
        return this;
    }

    public void fromFile(String fileName) {
        try {
            URL url = ConsoleWriter.class.getClassLoader().getResource(fileName);
            InputStream input = new BufferedInputStream(new FileInputStream(new File(url.toURI())));
            System.setIn(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finish() {
        StringBufferInputStream s = new StringBufferInputStream(String.format(builder.toString(), inputCounter));
        System.setIn(s);
    }

}
