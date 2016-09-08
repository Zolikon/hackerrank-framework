package com.zolikon.problems;
import java.util.Scanner;

import com.zolikon.helpers.Log;
public class TestProblem implements Problem {
    @Override
    public void start() {
        Scanner in = new Scanner(System.in);
        Log log = Log.getInstance();
        String line;
        while ((line = in.next()) != null) {
            log.add(line);
        }
    }
}
