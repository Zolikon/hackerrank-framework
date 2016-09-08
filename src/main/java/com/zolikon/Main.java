package com.zolikon;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.zolikon.helpers.ConsoleReader;
import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.helpers.Timer;
import com.zolikon.problems.BiggerIsGreater;
public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().addInputCounter().fromFile("test");
        ConsoleReader consoleReader = ConsoleReader.init().fromFile("results");
        Timer.start(BiggerIsGreater.class);
        consoleReader.finish().findFails();
        Timer.printLastRun();
        //@formatter:on

    }
}
