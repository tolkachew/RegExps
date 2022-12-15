package com.company;

import com.company.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

public class WriteXML {
    public static void main(String[] args) {
        writePerson();
    }
    public static void writePerson(){
        Person person = new Person(1, "Alex");
        person.addEmail("alex@gmail.com");
        person.addEmail("alex@rambler.com");
        Person person1 = new Person(2, "Mikhail");
        person1.addEmail("Mikhail@gmail.com");
        person1.addEmail("Mikhail@rambler.com");
        Person person2 = new Person(3, "Wlad");
        person2.addEmail("Wladislaw@gmail.com");
        person2.addEmail("Wladislaw@rambler.com");


        Persons persons = new Persons();
        persons.addPerson(person);
        persons.addPerson(person1);
        persons.addPerson(person2);



        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to file
            jaxbMarshaller.marshal(persons, new File("src/com/company/data/persons.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
