package com.zolikon.helpers;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
public class Log {

    private static final Log LOG_INSTANCE = new Log();

    List<String> list = new ArrayList<>();

    public static Log getInstance() {
        return LOG_INSTANCE;
    }

    public void add(String message) {
        list.add(message);
    }

    @Override
    public String toString() {
        return Joiner.on("\n").join(list);
    }
}
