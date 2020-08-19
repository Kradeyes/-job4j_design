package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void when2TimesServerDown() {
        Analizy test = new Analizy();
        String source = "./src/main/resources/server.txt";
        String target = "./src/main/resources/downtime.txt";
        String expected = "10:58:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02";
        test.unavailable(source, target);
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected,
                is(result.toString())
        );
    }
}