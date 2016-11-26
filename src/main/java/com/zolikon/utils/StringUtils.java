package com.zolikon.utils;

import java.util.Arrays;

@SuppressWarnings("unused")
public class StringUtils {


    public static String random(int length){
        return random(length,RandomStringTypes.LOWER_CASE);
    }

    public static String random(int length,RandomStringTypes type){
        char[] result = new char[length];
        for(int i=0;i<length;i++){
            result[i] = type.randomChar();
        }
        return new String(result);
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

    public static boolean isPalidrom(String a,String b){
        if (a.length() != b.length()) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        boolean result = true;
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[bChars.length-i-1]) {
                result = false;
                break;
            }
        }
        return result;
    }



}
