package com.zolikon;


import com.zolikon.helpers.ConsoleReader;
import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.problems.TwoCharacters;

import static com.zolikon.helpers.Timer.printLastRun;
import static com.zolikon.helpers.Timer.start;

public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().addLines("63","pvmaigytciycvjdhovwiouxxylkxjjyzrcdrbmokyqvsradegswrezhtdyrsyhg").finish();
        ConsoleReader consoleReader = ConsoleReader.init().addLines("6");
        start(TwoCharacters.class);
        consoleReader.finish().findFails();
        printLastRun();
        //@formatter:on



    }

}
