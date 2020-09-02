package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        long size = 9218301L;
        double time = 12.15;
        byte count = 1;
        boolean answer = true;
        char sex = 'm';
        float score = 12.4343F;
        LOG.debug("User info name : {}, age : {}, size: {}"
                + ", time: {}, count: {}, answer: {}, sex: {}, score: {}",
                name, age, size, time, count, answer, sex, score);
    }
}