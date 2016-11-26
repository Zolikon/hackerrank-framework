package com.zolikon.problems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Zoltan on 2016.11.25..
 */
public class ValidString implements Problem{
    @Override
    public void start() {
        String str = "aabbcsdddasdc";
        List<Integer> chars = str.chars().sorted().boxed().collect(Collectors.toList());
        Map<Integer, Long> count = chars.stream().collect(Collectors.groupingBy(t->t,Collectors.counting()));
        Map<Long, Long> occurances = count.values().stream().sorted().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        if(occurances.size()>2||(occurances.get(1L)!=null&&occurances.get(1L)!=1)){
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
