package com.zolikon.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by Zoltan on 2016.11.27..
 */
public class MinimumLoss implements Problem {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int years = in.nextInt();
        BigInteger[] value=new BigInteger[years];
        BigInteger min = new BigInteger("1000000000000000000");
        for(int i=0;i<years;i++){
            value[i] = new BigInteger(in.next());
        }
        for(int i=0;i<value.length-1;i++){
            BigInteger value1 = value[i];
            int minLength = 0;
            for(int p=i+1;p<value.length;p++){
                BigInteger value2 = value[p];
                int length = value2.toString().length();
                if(length>=minLength && value1.compareTo(value2)>0){
                    BigInteger diff = value1.subtract(value2);
                    if(diff.compareTo(min)<0){
                        min = diff;
                        minLength = length;
                    }
                }
            }
        }
        System.out.println(min);
    }

    @Override
    public void start() {
        main(null);
    }
}
