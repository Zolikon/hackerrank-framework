package com.zolikon.problems;

import java.time.LocalDate;

public class LibraryFine implements Problem {
    @Override
    public void start() {
        int rDay = 31;
        int rMonth = 10;
        int rYear = 2017;
        int eDay = 31;
        int eMonth = 8;
        int eYear = 2017;
        LocalDate rDate = convert(rYear,rMonth,rDay);
        LocalDate eDate = convert(eYear,eMonth,eDay);
        int result =0;
        if(rDate.isAfter(eDate)){
            if(rYear!=eYear){
                result = 10000;
            } else if(rMonth!=eMonth){
                result = (rMonth-eMonth)*500;
            } else{
                result = (rDay-eDay)*15;
            }
        }
        System.out.println(result);
    }

    private LocalDate convert(int year,int month,int day){
        return LocalDate.parse(String.format("%d-%02d-%02d",year,month,day));
    }
}
