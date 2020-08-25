package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgsName {

    private Map<String, String> values = new HashMap<>();

    public String get(String key) throws IllegalArgumentException {
        if (values.get(key) == null) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        values = Arrays.stream(args)
                .map(p -> p.replaceFirst("-", ""))
                .map(p -> p.split("="))
                .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(jvm.get("out"));
    }
}