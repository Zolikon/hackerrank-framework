package com.zolikon.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Joiner;
public class InputHolder {

    private static final InputHolder instance = new InputHolder();

    List<Object> inputList = new ArrayList<>();
    Iterator<Object> iterator;
    boolean isContainingCounter = false;

    public static InputHolder init() {
        return instance;
    }

    public synchronized void addInput(Object input) {
        inputList.add(input);
    }

    public synchronized void addCounter() {
        isContainingCounter = true;
    }

    public synchronized void finishInput() {
        iterator = inputList.iterator();
    }

    public synchronized String getNextInput() {
        if (iterator == null) {
            throw new IllegalStateException("Input insertion isn't finished");
        }
        String result = "no more input";
        if (iterator.hasNext()) {
            result = iterator.next().toString();
        }
        return result;
    }

    public synchronized int getInputCount() {
        return inputList.size();
    }

    public synchronized String toString() {
        String result = Joiner.on("\n").join(inputList);
        if (isContainingCounter) {
            result = inputList.size() + "\n" + result;
        }
        return result;
    }

}
