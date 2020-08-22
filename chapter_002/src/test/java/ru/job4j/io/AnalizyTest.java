package ru.job4j.io;

import org.junit.Test;
import org.junit.Rule;

import java.io.*;
import java.util.StringJoiner;
import org.junit.rules.TemporaryFolder;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder =  new TemporaryFolder();

    @Test
    public void when2TimesServerDown() throws IOException {
        Analizy test = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "200 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        }
        String expected = "10:58:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02";
        test.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(expected,
                is(result.toString())
        );
    }
}