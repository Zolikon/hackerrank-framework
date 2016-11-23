package com.zolikon.helpers;

import java.io.*;
import java.net.URL;

@SuppressWarnings("unused")
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
        builder.append(line).append("\n");
        inputCounter++;
        for (String oneLine : lines) {
            builder.append(oneLine).append("\n");
            inputCounter++;
        }
        return this;
    }

    public ConsoleWriter addInputCounter() {
        builder.append("%s ");
        return this;
    }

    public ConsoleWriter addInt(int... number) {
        for (int item : number) {
            builder.append(item).append(" ");
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

    @SuppressWarnings("deprecation")
    public void finish() {
        StringBufferInputStream s = new StringBufferInputStream(String.format(builder.toString(), inputCounter));
        System.setIn(s);
    }

}
