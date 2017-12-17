package com.zolikon.problems;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by Zoltan on 2016.11.27..
 */
public class NewYearPresent implements Problem {
    @Override
    public void start() {
        main(null);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l[] = new int[n];
        for (int l_i = 0; l_i < n; l_i++) {
            l[l_i] = in.nextInt();
        }
        Arrays.sort(l);

        Map<Integer, Long> counters =
                Arrays.stream(l).boxed()
                        .collect(groupingBy(t -> t, counting()));

        long twoStickSidesSolution = processTwoStickSides(l, counters);
        long threeStickSidesSolution = processThreeStickSides(l, counters);
        System.out.println(twoStickSidesSolution+threeStickSidesSolution);
    }

    private static long processThreeStickSides(int[] l, Map<Integer, Long> counters) {
        List<Integer> atLeastThree = counters.entrySet().stream().filter(t -> t.getValue() >= 2 && t.getKey() > 1).map(t -> t.getKey()).collect(toList());
        long result = 0;
        for (Integer value : atLeastThree) {
            int solutionCount = 0;
            int endIndex = Arrays.binarySearch(l, value + 1);
            endIndex = endIndex < 0 ? -endIndex : endIndex;
            endIndex = endIndex >= l.length ? l.length : endIndex;
            for (int i = 0; i < endIndex; i++) {
                for (int p = i + 1; p < endIndex; p++) {
                    for (int q = p + 1; q < endIndex; q++) {
                        if (l[i] + l[p] + l[q] == value) {
                            solutionCount++;
                        }
                    }
                }
            }
            long occ = counters.get(value);
            result = combinations(occ, 2) * solutionCount;
        }
        return result;
    }

    private static long processTwoStickSides(int[] l, Map<Integer, Long> counters) {
        List<Integer> atLeastTwo = counters.entrySet().stream().filter(t -> t.getValue() >= 2 && t.getKey() > 1).map(t -> t.getKey()).collect(toList());
        long result = 0;
        for (Integer value : atLeastTwo) {
            List<Pair> possiblePairs = new ArrayList<>();
            int endIndex = Arrays.binarySearch(l, value + 1);
            endIndex = endIndex < 0 ? -endIndex : endIndex;
            endIndex = endIndex >= l.length ? l.length : endIndex;
            for (int i = 0; i < endIndex; i++) {
                for (int p = i + 1; p < endIndex; p++) {
                    if (l[i] + l[p] == value) {
                        possiblePairs.add(new Pair(i, p));
                    }
                }
            }
            Set<TwoPairs> possiblePairCombinations =new HashSet<>();
            for(int i=0;i<possiblePairs.size();i++){
                for(int p=i+1;p<possiblePairs.size();p++){
                    Pair pair1 = possiblePairs.get(i);
                    Pair pair2 = possiblePairs.get(p);
                    if(!pair1.equals(pair2)){
                        possiblePairCombinations.add(new TwoPairs(pair1,pair2));
                    }
                }

            }
            long occ = counters.get(value);
            result = combinations(occ, 2) * possiblePairCombinations.size();
        }
        return result;
    }


    private static long combinations(long number, long count) {
        return fact(number) / (fact(count) * fact(number - count));
    }

    private static long fact(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * fact(number - 1);
        }
    }

    private static class TwoPairs {
        private int[] indexes;

        public TwoPairs(Pair pair1, Pair pair2) {
            indexes = new int[4];
            indexes[0] = pair1.index1;
            indexes[1] = pair1.index2;
            indexes[2] = pair2.index1;
            indexes[3] = pair2.index2;
            Arrays.sort(indexes);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TwoPairs twoPairs = (TwoPairs) o;

            return Arrays.equals(indexes, twoPairs.indexes);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(indexes);
        }
    }

    private static class Pair {
        private int index1;
        private int index2;

        public Pair(int index1, int index2) {
            if (index1 < index2) {
                this.index1 = index1;
                this.index2 = index2;
            } else {
                this.index1 = index2;
                this.index2 = index1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            boolean b = pair.index1 == this.index1;
            boolean b1 = pair.index1 == this.index2;
            boolean b2 = pair.index2 == this.index1;
            boolean b3 = pair.index2 == this.index2;
            return b || b1 || b2 || b3;
        }

        @Override
        public String toString() {
            return String.format("%d%d", index1, index2);
        }
    }
}
