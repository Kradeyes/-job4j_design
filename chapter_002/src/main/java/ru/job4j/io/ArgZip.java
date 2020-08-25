package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private final String[] args;
    private Map<String, String> map = new HashMap<>();
    private String[] keys = {"-d", "-e", "-o"};

    public ArgZip(String[] args) {
        this.args = args;
    }

    public void getMap() {
        for (String string:args) {
            if (string.contains("=")) {
                String[] rsl = string.split("=");
                map.put(rsl[0], rsl[1]);
            }
        }
    }

    public boolean valid() {
        getMap();
        boolean rsl = true;
        for (String key: keys) {
            if (!map.containsKey(key)) {
                rsl = false;
                System.out.println(key + " is absent.");
            }
        }
        return rsl;
    }

    public String directory() {
        return map.get("-d");
    }

    public String exclude() {
        return map.get("-e");
    }

    public String output() {
        return map.get("-o");
    }
}