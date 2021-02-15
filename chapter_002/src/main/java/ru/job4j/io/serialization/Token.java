package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Token {
    private final int number;
    private final String zooName;

    public Token(int number, String zooName) {
        this.number = number;
        this.zooName = zooName;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                ", zooName='" + zooName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        final Animal animal = new Animal(false, 5,
                new Token(1245,"NewYorkZoo"),"Africa", "Brazil");
        System.out.println(animal.toString());

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(animal));

        /*
        Relocate to Moscow
         */
        final String animalJson =
                "{"
                + "\"sex\":false,"
                + "\"age\":6,"
                + "\"token\":"
                + "{"
                + "\"number\":13241,"
                + "\"zooName\":\"MoscowZoo\""
                + "},"
                + "\"habitat\":"
                + "[\"Africa\",\"Brazil\"]"
                + "}";
        Animal relocatedAnimal = gson.fromJson(animalJson, Animal.class);
        System.out.println(relocatedAnimal);
    }
}
