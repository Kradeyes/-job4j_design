package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.*;
import java.nio.file.Files;

@XmlElement(value = "contact")
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private int zipCode;
    @XmlAttribute
    private String phone;

    public Contact() { }

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        /* Запись объекта в файл */
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        /* Чтение объекта из файла */
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);

            final Person person = new Person(false, 30, new Contact(123154,"11-111"),
                    "Worker", "Married");
            System.out.println(person.toString());

            /* Преобразуем объект person в json-строку. */
            final Gson gson = new GsonBuilder().create();
            System.out.println(gson.toJson(person));

            /* Модифицируем json-строку */
            final String personJson =
                    "{"
                            + "\"sex\":false,"
                            + "\"age\":35,"
                            + "\"contact\":"
                            + "{"
                            + "\"zipCode\":123456,"
                            + "\"phone\":\"+7(924)111-111-11-11\""
                            + "},"
                            + "\"statuses\":"
                            + "[\"Student\",\"Free\"]"
                            + "}";
            final Person personMod = gson.fromJson(personJson, Person.class);
            System.out.println(personMod);
        }
    }
}

