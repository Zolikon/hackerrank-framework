package com.zolikon.helpers;
import java.lang.reflect.Method;

import com.zolikon.problems.Problem;
public class Timer {

    private static double lastRun;

    public static <T extends Problem> void start(Class<T> clazz) throws Exception {
        long start = System.currentTimeMillis();
        Class<?> problem = Class.forName(clazz.getName());
        Method m = problem.getMethod("start");
        m.invoke(problem.newInstance());
        lastRun = (System.currentTimeMillis() - start) / 1000.0;
    }

    public static void printLastRun() {
        System.out.println("Run time: " + lastRun + " seconds");
    }
}
