package ru.job4j.io.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "animal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animal {
    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private Token token;

    @XmlElementWrapper(name = "habitats")
    @XmlElement(name = "habitat")
    private String[] habitat;

    public Animal() { }

    public Animal(boolean sex, int age, Token token, String... habitat) {
        this.sex = sex;
        this.age = age;
        this.token = token;
        this.habitat = habitat;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Token getToken() {
        return token;
    }

    public String[] getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "sex=" + sex +
                ", age=" + age +
                ", token=" + token +
                ", habitat=" + Arrays.toString(habitat) +
                '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Animal person = new Animal(false, 5,
                new Token(1245,"NewYorkZoo"), "Africa", "Brazil");

        JAXBContext context = JAXBContext.newInstance(Animal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
          e.printStackTrace();
        }

        JSONObject jsonToken =
                new JSONObject("{\"number\":1235,\"zooName\":\"NewYorkZoo\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Africa");
        list.add("Brazil");
        JSONArray jsonHabitat = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Animal animal = new Animal(false, 5,
                new Token(1235,"NewYorkZoo"), "Africa", "Brazil");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("token", jsonToken);
        jsonObject.put("habitat", jsonHabitat);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(animal).toString());

    }
}
