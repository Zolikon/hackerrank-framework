package com.zolikon.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zoltan on 2016.12.31..
 */
public class StringReduction implements Problem {
    @Override
    public void start() {

    }

    private static final char A = 'a';
    private static final char B = 'b';
    private static final char C = 'c';

    public static void main(String[] args) throws Exception {
        System.out.println(process("cab"));
    }

    private static String process(String str) {
        if(str.length() == 1){
            return str;
        }
        char[] c = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        char last = c[0];
        for (int i = 1; i < str.length(); i++) {
            if(last!=c[i]){
                last = switchChar(last,c[i]);
                builder.append(last);
            } else {
                builder.append(last);
                last = c[i];
                if(i==str.length()-1){
                    builder.append(last);
                }
            }
        }
        String result = builder.toString();
        if(result.length()==str.length()){
            return result;
        } else {
            return process(result);
        }
    }

    private static char switchChar(char one, char two){
        Set<Character> chars = new HashSet<>();
        chars.add(one);
        chars.add(two);
        if (!chars.contains(A)) {
            return A;
        }
        if (!chars.contains(B)) {
            return B;
        }
        return C;
    }


}
