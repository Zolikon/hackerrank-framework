package com.zolikon.problems;

import com.zolikon.utils.RandomStringTypes;
import com.zolikon.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zoltan on 2016.11.26..
 */
public class SherlockAndAnagrams implements Problem {

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    @Override
    public void start() {
        String input = "pvmupwjjjf";
        process(input);
    }


    private static void process(String input){
        int count = 0;
        for (int i = 1; i < input.length(); i++) {
            for(int p = 0;p<=input.length()-i;p++){
                String first = input.substring(p, p + i);
                for(int r = p+1;r<=input.length()-i;r++){
                    String second = input.substring(r, r + i);
                    if(isAnagram(first,second)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        boolean result = true;
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                result = false;
                break;
            }
        }
        return result;
    }


}
