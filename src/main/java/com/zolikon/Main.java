package com.zolikon;


import com.zolikon.helpers.ConsoleReader;
import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.problems.*;

import static com.zolikon.helpers.Timer.printLastRun;
import static com.zolikon.helpers.Timer.start;

public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().addLines("3","51234564564654654132345 51234564564654654132345 51234564564654654132343").finish();
        //ConsoleReader consoleReader = ConsoleReader.init().addLines("3");
        start(SuperFunctionalStrings.class);
       // consoleReader.finish().printResults();
        printLastRun();
        //@formatter:on



    }

}
