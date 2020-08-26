package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Duplicate {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        duplicateSearch(start);
    }

    public static void duplicateSearch(Path root) throws IOException {
        Map<String, Long> allPaths;
        Map<String, Long> dupPaths;
        AddFiles add = new AddFiles();
        Files.walkFileTree(root, add);
        allPaths = add.getPaths();
        dupPaths = add.dup();
        System.out.println("Count without duplicates " + allPaths.size());
        System.out.println("Count off duplicates: " + dupPaths.size());
        System.out.println("Duplicates list:");
        for (Map.Entry<String, Long> entry: dupPaths.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        }
    }
