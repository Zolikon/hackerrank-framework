package com.zolikon.problems;

public class BeautifulDays implements Problem {

    @Override
    public void start() {
        System.out.println(reverse(120));
    }

    private Integer reverse(int number){
        StringBuilder builder = new StringBuilder(Integer.toString(number));
        return Integer.parseInt(builder.reverse().toString());
    }
}
