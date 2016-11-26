package com.zolikon.problems;

import java.math.BigInteger;


public class ExtraLongFactorials implements Problem{
    @Override
    public void start() {
        int n=25;
        BigInteger result = BigInteger.ONE;
        for(int i=2;i<=n;i++){
            result=result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
