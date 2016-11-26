package com.zolikon;


import com.zolikon.helpers.ConsoleReader;
import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.problems.*;

import static com.zolikon.helpers.Timer.printLastRun;
import static com.zolikon.helpers.Timer.start;

public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().fromFile("test");
        ConsoleReader consoleReader = ConsoleReader.init().fromFile("results");
        start(SteadyGene.class);
        consoleReader.finish().findFails();
        printLastRun();
        //@formatter:on



    }

}
