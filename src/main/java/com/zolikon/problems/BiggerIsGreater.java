package com.zolikon.problems;
import java.util.Arrays;
import java.util.Scanner;

import com.zolikon.helpers.Log;
public class BiggerIsGreater implements Problem {

    public void start() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int p = 0; p < count; p++) {
            String next = in.next();
            char[] c = next.toCharArray();
            int index = c.length - 2;
            boolean match = false;
            while (index >= 0) {
                if (getNextSmallest(next.toCharArray(), index)) {
                    match = true;
                    break;
                }
                index--;
            }
            if (!match) {
                System.out.println("no answer");
            }
        }
    }

    private boolean getNextSmallest(char[] array, int from) {
        char start = array[from];
        char[] sortedArray = sortRange(array, from);
        int min = 'z';
        int index = -1;
        for (int i = 0; i < sortedArray.length; i++) {
            int diff = sortedArray[i] - start;
            if (diff > 0 && min - start > diff) {
                min = sortedArray[i];
                index = i;
            }
        }
        if (index != -1) {
            moveToFirst(sortedArray, index);
            System.out.println(new String(Arrays.copyOfRange(array, 0, from)) + new String(sortedArray));
        }
        return index != -1;

    }

    private void moveToFirst(char[] array, int index) {
        char temp = array[index];
        for (int i = index; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    private char[] sortRange(char[] array, int from) {
        char[] sortedArray = Arrays.copyOfRange(array, from, array.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    private void replace(char[] array, int one, int two) {
        char temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
