package ru.job4j.io.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

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
    }
}
