package ru.job4j.collection;

import ru.job4j.generic.User;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MyMap {

    public static class User {
        private String name;
        private int children;
        private Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }

    public static void main(String[] args) {
        User first = new User("Roman", 1,
                new GregorianCalendar(1990, Calendar.AUGUST, 31));
        User second = new User("Roman", 1,
                new GregorianCalendar(1990, Calendar.AUGUST, 31));
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(first, first);
        testMap.put(second, second);
        System.out.println(testMap);
        }
    }
