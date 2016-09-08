package com.zolikon;

import com.zolikon.helpers.ConsoleWriter;
import com.zolikon.helpers.Log;
import com.zolikon.helpers.Timer;
import com.zolikon.problems.TestProblem;
public class Main {

    public static void main(String[] args) throws Exception {
        //@formatter:off
        ConsoleWriter.init().addInput("one").finish();
        //ConsoleReader consoleReader = ConsoleReader.getInstance().fromFile("results");
        Timer.start(TestProblem.class);

        //consoleReader.resetSystemOut();
        //Timer.printLastRun();
        System.out.println(Log.getInstance());
        //System.out.println(new Scanner(System.in).next());

        //@formatter:on

    }
}
