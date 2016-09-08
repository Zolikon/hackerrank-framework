package com.zolikon;

import com.zolikon.helpers.ConsoleReader;
import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.helpers.Timer;
import com.zolikon.problems.BiggerIsGreater;
public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().fromFile("test");
        ConsoleReader consoleReader = ConsoleReader.init().fromFile("results");
        Timer.start(BiggerIsGreater.class);
        consoleReader.resetSystemOut().printFailedResults();
        Timer.printLastRun();
        //@formatter:on

    }
}
