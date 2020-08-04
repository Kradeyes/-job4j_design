package ru.job4j.collection;

import java.util.*;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return children == user.children
                    && Objects.equals(name, user.name)
                    && Objects.equals(birthday, user.birthday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, children, birthday);
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
