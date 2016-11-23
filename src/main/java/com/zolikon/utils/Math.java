package com.zolikon.utils;

@SuppressWarnings("unused")
public class Math {

    private Math() {

    }

    public static long highestCommonDenominator(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static long highestCommonDenominator(long[] array) {
        return processArray(array, Math::highestCommonDenominator);
    }

    public static long lowestCommonMultiple(long[] array) {
        return processArray(array, Math::lowestCommonMultiple);
    }

    public static long lowestCommonMultiple(long a, long b) {
        return a * b / highestCommonDenominator(a, b);
    }

    public static boolean isPrime(long number){
        boolean result = true;
        long sqrt = (long) java.lang.Math.sqrt(number);
        for(long i=2;i<=sqrt;i++){
            if(number%i==0){
                result = false;
                break;
            }
        }
        return result;
    }

    private interface TwoParameterFunction<T, R> {
        R apply(T a, T b);
    }

    private static long processArray(long[] array, TwoParameterFunction<Long, Long> function) {
        long hcd = array[0];
        for (int i = 1; i < array.length; i++) {
            hcd = function.apply(hcd, array[i]);
        }
        return hcd;
    }

}
