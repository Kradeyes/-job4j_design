package ru.job4j.io;

import java.io.FileOutputStream;

public class Multiplication {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int k = 1; k < 10; k++) {
                    out.write(((i * k) + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
