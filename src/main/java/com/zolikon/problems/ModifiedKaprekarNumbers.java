package com.zolikon.problems;

/**
 * Created by Zoltan on 2016.11.25..
 */
public class ModifiedKaprekarNumbers implements Problem {
    @Override
    public void start() {
        System.out.println(isModifiedKaprekarNumber(1));
    }


    private boolean isModifiedKaprekarNumber(long number) {
        long square = number * number;
        int length = Long.toString(number).length();
        int longLength = Long.toString(square).length();
        int rightLength = longLength - length;
        long left = Long.parseLong(Long.toString(square).substring(rightLength));
        String substring = Long.toString(square).substring(0, rightLength);
        if (substring.isEmpty()) {
            return left == number;
        } else {
            long right = Long.parseLong(substring);
            return left != 0 && right + left == number;
        }
    }
}
