package com.zolikon.problems;

import java.util.Scanner;

public class MorganAndAString implements Problem {

    @Override
    public void start() {
        System.out.println("infinte loop!");
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            process(in.next(), in.next());
        }

//        process("JACK","DANIELS");
    }

    private static void process(String a, String b) {
        char[] aQueue = a.toCharArray();
        char[] bQueue = b.toCharArray();
        int aIndex = 0;
        int bIndex = 0;
        String result = "";
        while (aIndex < aQueue.length || bIndex < bQueue.length) {
            char aValue;
            char bValue;
            if (aIndex == aQueue.length) {
                result = add(result, bQueue,bIndex);
                break;
            }
            if (bIndex == bQueue.length) {
                result = add(result, aQueue,aIndex);
                break;
            }
            aValue = aQueue[aIndex];
            bValue = bQueue[bIndex];


            if (aValue < bValue) {
                result += aValue;
                aIndex++;
            } else if(aValue > bValue){
                result +=bValue;
                bIndex++;
            } else {
                int aTempIndex = aIndex+1;
                int bTempIndex = bIndex+1;
                boolean matchFound = false;
                while (aTempIndex < aQueue.length || bTempIndex < bQueue.length) {
                    if(aQueue[aTempIndex]<bQueue[bTempIndex]){
                        result=add(result,aQueue,aIndex,aTempIndex);
                        aIndex=aTempIndex+1;
                        matchFound = true;
                        break;
                    } else if(aQueue[aTempIndex]>bQueue[bTempIndex]){
                        result=add(result,bQueue,bIndex,bTempIndex);
                        bIndex=bTempIndex+1;
                        matchFound = true;
                        break;
                    }
                    aTempIndex++;
                    bTempIndex++;
                }
                if(!matchFound) {
                    if (aTempIndex == aQueue.length && bTempIndex < bQueue.length) {
                        result=add(result,bQueue,bIndex,bTempIndex);
                        bIndex=bTempIndex+1;
                    } else if (bTempIndex == bQueue.length && bTempIndex < bQueue.length) {
                        result=add(result,aQueue,aIndex,aTempIndex);
                        aIndex=aTempIndex+1;
                    } else if (aTempIndex == aQueue.length && bTempIndex == bQueue.length) {

                    }
                }

            }
        }
        System.out.println(result);
    }

    private static String add(String str, char[] characters,int startIndex, int endIndex) {
        for(int i=startIndex;i<=endIndex;i++) {
            str += characters[i];
        }
        return str;
    }

    private static String add(String str, char[] characters,int startIndex) {
        return add(str,characters,startIndex,characters.length-1);
    }

}
