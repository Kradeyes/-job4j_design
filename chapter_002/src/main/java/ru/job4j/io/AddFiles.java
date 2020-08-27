package ru.job4j.io;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddFiles extends SimpleFileVisitor<Path> {
    private final Map<String, Long> result = new HashMap<>();
    private final Map<String, Long> dup = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (!result.containsKey(file.toFile().getName())) {
            result.put(file.toFile().getName(), file.toFile().length());
        } else {
            if (!result.containsValue(result.get(file.toFile().getName()))) {
                result.put(file.toFile().getName(), file.toFile().length());
            } else {
                dup.put(file.toFile().getName(), file.toFile().length());
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public Map<String, Long> getPaths() {
        return this.result;
    }

    public Map<String, Long> dup() {
        return this.dup;
    }
}