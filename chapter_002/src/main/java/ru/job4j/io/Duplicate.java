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
        System.out.println("Count off duplicates: " + count);
    }

    public static void duplicateSearch(Path root) throws IOException {
        List<Path> allPaths;
        List<File> allFiles = new ArrayList<>();
        AddFiles add = new AddFiles();
        Files.walkFileTree(root, add);
        allPaths = add.getPaths();
        for (Path path : allPaths) {
            allFiles.add(path.toFile());
        }
        Collections.sort(allFiles);
        for (int i = 0; i < allFiles.size() - 1; i++) {
            if (allFiles.get(i).getName().equals(allFiles.get(i + 1).getName())
                    && allFiles.get(i).length() == allFiles.get(i + 1).length()) {
                System.out.println(allFiles.get(i).getName() + " " + allFiles.get(i).length());
                count++;
            }
        }
    }
}