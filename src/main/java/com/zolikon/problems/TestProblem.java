package com.zolikon.problems;
import java.util.Scanner;

import com.zolikon.helpers.Log;
public class TestProblem implements Problem {
    @Override
    public void start() {
        Scanner in = new Scanner(System.in);
        Log log = Log.init();
        String line;
        while ((line = in.nextLine()) != null) {
            log.add(line);
        }
    }
}
