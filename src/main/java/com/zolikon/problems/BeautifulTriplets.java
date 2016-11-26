package com.zolikon.problems;

/**
 * Created by Zoltan on 2016.11.25..
 */
public class BeautifulTriplets implements Problem {
    @Override
    public void start() {
        int count = 7;
        int diff = 3;
        int[] numbers = {1,2,4,5,7,8,10};
        int result = 0;
        for(int i=0;i<count;i++){
            int firstIndex = indexOfFollowingBeautifulTriplet(numbers,i,diff);
            if(firstIndex!=-1){
                int secondIndex = indexOfFollowingBeautifulTriplet(numbers,firstIndex,diff);
                if(secondIndex!=-1){
                    result++;
                }
            }
        }
        System.out.println(result);
    }


    private static int indexOfFollowingBeautifulTriplet(int[] numbers,int index,int diff){
        int base = numbers[index];
        index++;
        int result = -1;
        while(index<numbers.length && numbers[index]<=base+diff){
            if(numbers[index]==base+diff){
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}
