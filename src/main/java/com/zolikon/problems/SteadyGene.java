package com.zolikon.problems;

import com.zolikon.utils.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zoltan on 2016.11.26..
 */
public class SteadyGene implements Problem {
    @Override
    public void start() {
        process();
    }


    public static void process() {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();
        String str =in.next();
        char[] charArray = str.toCharArray();


        int[] genes = getGenes(charArray);
        int A = length / 4 - genes[0];
        int C = length / 4 - genes[1];
        int G = length / 4 - genes[2];
        int T = length / 4 - genes[3];
        int minLength = posOnly(A) + posOnly(C) + posOnly(G) + posOnly(T);
        int[] target = { negOnly(A), negOnly(C), negOnly(G), negOnly(T) };
        for (int i = minLength; i <= charArray.length; i++) {
            if (searchString(charArray, i, target)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean searchString(char[] charArray, int length, int[] target) {
        int sum = sum(target);
        for (int i = 0; i < charArray.length - length; i++) {
            int[] subStringLetters = getGenes(substring(charArray, i, i + length));
            if (compare(target, subStringLetters, length - sum)) {
                return true;
            }
        }
        return false;
    }

    private static char[] substring(char[] charArray, int from, int to) {
        char[] result = new char[to - from];
        for (int i = from; i < to; i++) {
            result[i - from] = charArray[i];
        }
        return result;
    }

    private static boolean compare(int[] target, int[] actual, int diff) {
        for (int i = 0; i < 4; i++) {
            if (target[i] > actual[i]) {
                return false;
            }
        }
        return sum(actual) - sum(target) == diff;
    }

    private static int sum(int[] a) {
        int result = 0;
        for (int b : a) {
            result += b;
        }
        return result;
    }

    private static int posOnly(int a) {
        return a < 0 ? 0 : a;
    }

    private static int negOnly(int a) {
        return a > 0 ? 0 : -a;
    }

    private static int[] getGenes(char[] charArray) {
        int[] result = new int[4];
        for (char ch : charArray) {
            switch (ch) {
                case 'A':
                    result[0]++;
                    break;
                case 'C':
                    result[1]++;
                    break;
                case 'G':
                    result[2]++;
                    break;
                case 'T':
                    result[3]++;
                    break;
            }
        }
        return result;
    }

}
