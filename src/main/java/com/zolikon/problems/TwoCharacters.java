package com.zolikon.problems;

import java.util.*;


public class TwoCharacters implements Problem {

    @Override
    public void start() {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        CharacterCounter[] counter = new CharacterCounter[26];
        for (char i = 'a'; i <= 'z'; i++) {
            counter[i - 'a'] = new CharacterCounter(i);
        }
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a'].add();
        }
        int max = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int p = i + 1; p < counter.length; p++) {
                int diff = diff(counter[i].getCount(), counter[p].getCount());
                if (diff == 1 || diff == 0) {
                    String test = remove(s, counter[i].c, counter[p].c);
                    if (check(test)) {
                        int result = counter[i].getCount() + counter[p].getCount();
                        max = max < result ? result : max;
                    }
                }
            }
        }
        System.out.println(max);

    }

    private boolean check(String str) {
        char[] c = str.toCharArray();
        Set<Character> test = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            test.add(c[i]);
        }
        boolean result = true;
        if (test.size() != 2) {
            result = false;
        } else {
            for (int i = 1; i < c.length; i++) {
                if (c[i] == c[i - 1]) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    private static int diff(int a, int b) {
        return a - b < 0 ? b - a : a - b;
    }

    private static String remove(String str, char a, char b) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == a || c == b) {
                result += c;
            }
        }
        return result;
    }

    private static class CharacterCounter {
        char c;
        int count;

        public CharacterCounter(char c) {
            this.c = c;
        }

        public void add() {
            count++;
        }

        public int getCount() {
            return count;
        }

    }
}
