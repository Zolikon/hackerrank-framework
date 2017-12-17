package com.zolikon.utils;

import java.util.Random;

/**
 * Created by Zoltan on 2016.11.26..
 */
@SuppressWarnings("unused")
public enum RandomStringTypes {
    LOWER_CASE {
        @Override
        public char randomChar() {
            return (char) (RANDOM.nextInt(26)+'a');
        }
    },
    UPPER_CASE {
        @Override
        public char randomChar() {
            return (char) (RANDOM.nextInt(26) + 'A');
        }
    },
    NUMBER{
        @Override
        public char randomChar() {
            return (char) (RANDOM.nextInt(10) + '0');
        }
    },
    MIXED{
        @Override
        public char randomChar() {
            int type = RANDOM.nextInt(102)%3;
            char value;
            switch (type){
                case 0:
                    value = LOWER_CASE.randomChar();
                    break;
                case 1:
                    value = UPPER_CASE.randomChar();
                    break;
                default:
                    value = NUMBER.randomChar();
            }
            return value;
        }
    };

    private static final Random RANDOM = new Random();
    public abstract char randomChar();

}
