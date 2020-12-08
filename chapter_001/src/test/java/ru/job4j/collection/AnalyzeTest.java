package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AnalyzeTest {
    private final Analyze newAnalyze = new Analyze();
    private Analyze.User first = new Analyze.User(1, "Roma");
    private Analyze.User second = new Analyze.User(2, "Petya");
    private Analyze.User third = new Analyze.User(3, "Vasya");
    private Analyze.User sameFirst = new Analyze.User(1, "Roma");
    private Analyze.User sameId = new Analyze.User(2, "Kolya");
    private final List<Analyze.User> previous = new ArrayList<>();
    private List<Analyze.User> current = new ArrayList<>();

    @Test
    public void whenAdd1New() {
        previous.add(first);
        previous.add(second);
        current.add(sameFirst);
        current.add(third);
        assertEquals(1, newAnalyze.diff(previous, current).getAdded());
    }

    @Test
    public void whenChange() {
        previous.add(first);
        previous.add(second);
        current.add(third);
        current.add(sameId);
        current.add(sameFirst);
        assertEquals(1, newAnalyze.diff(previous, current).getChanged());
    }

    @Test
    public void whenDelete() {
        previous.add(first);
        previous.add(second);
        current.add(first);
        current.add(second);
        current.remove(first);
        current.remove(second);
        assertEquals(2, newAnalyze.diff(previous, current).getDeleted());
    }
}