package com.zolikon.problems;


import com.zolikon.utils.RandomStringTypes;
import com.zolikon.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuperFunctionalStrings implements Problem {

    public static final int DIVEDER = 1000000007;

    @Override
    public void start() {

    }

    private static List<String> substrings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String str = StringUtils.random(1000, RandomStringTypes.LOWER_CASE);
        List<Character> list = str.chars().boxed().map(t -> Character.valueOf((char) t.intValue())).collect(Collectors.toList());
        for (int i = 1; i <= str.length(); i++) {
            combination(str.toCharArray(), i);
        }
        substrings = substrings.stream().distinct().collect(Collectors.toList());
        System.out.println(substrings.size());
        long counter = 0;
        for (String s : substrings) {
            counter += count(s);
        }
        System.out.println(counter % DIVEDER);
    }

    private static long count(String str) {
        long distinct = str.chars().distinct().count();
        int length = str.length();
        return ((long) Math.pow(length, distinct)) % DIVEDER;
    }

    private static void combination(char[] a, int length) {
        for (int i = 0; i <= a.length - length; i++) {
            substrings.add(new String(Arrays.copyOfRange(a, i, i + length)));
        }
    }


}
