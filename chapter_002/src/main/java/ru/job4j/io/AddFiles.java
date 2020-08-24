package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class AddFiles extends SimpleFileVisitor<Path> {
    private final List<Path> result = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            result.add(file);

        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return this.result;
    }
}