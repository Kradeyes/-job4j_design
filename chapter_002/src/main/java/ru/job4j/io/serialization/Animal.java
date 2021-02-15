package ru.job4j.io.serialization;

import java.util.Arrays;

public class Animal {
    private final boolean sex;
    private final int age;
    private final Token token;
    private final String[] habitat;

    public Animal(boolean sex, int age, Token token, String... habitat) {
        this.sex = sex;
        this.age = age;
        this.token = token;
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "sex=" + sex +
                ", age=" + age +
                ", token=" + token +
                ", habitat=" + Arrays.toString(habitat) +
                '}';
    }
}
