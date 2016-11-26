package com.zolikon.problems;

import java.util.Arrays;

public class EqualizeTheArray implements Problem {
    @Override
    public void start() {
        int[] numbers = {1,1,1,1,4,4,2};
        System.out.println(Arrays.toString(counter(numbers)));
    }

    private int[] counter(int[] numbers){
        int distinctCounter = (int) Arrays.stream(numbers).distinct().count();
        int[] counter = new int[distinctCounter];
        Arrays.sort(numbers);
        int index=0;
        counter[0]=1;
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]!=numbers[i-1]){
                index++;
            }
            counter[index]++;
        }
        Arrays.sort(counter);
        return counter;
    }





}
