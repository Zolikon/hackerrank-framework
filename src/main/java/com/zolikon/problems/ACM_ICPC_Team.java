package com.zolikon.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zoltan on 2016.11.25..
 */
public class ACM_ICPC_Team implements Problem {

    @Override
    public void start() {
        String[] peoples = {"10101",
                "11100",
                "11010",
                "00101"};
        int numberOfPersons = peoples.length;
        int numberOfTopics = peoples[0].length();
        List<Integer> teams = new ArrayList<>();
        for (int i = 0; i < peoples.length - 1; i++) {
            for (int p = i + 1; p < peoples.length; p++) {
                teams.add(countTeamTopics(peoples[i], peoples[p]));
            }
        }
        Collections.sort(teams, (a, b) -> b - a);
        int max = teams.get(0);
        System.out.println(max);
        System.out.println(teams.stream().filter(t->t==max).count());
    }

    private int countTeamTopics(String member1, String member2) {
        int topicsCount = 0;
        for (int i = 0; i < member1.length(); i++) {
            if (member1.charAt(i) == '1' || member2.charAt(i) == '1') {
                topicsCount++;
            }
        }
        return topicsCount;
    }


}
