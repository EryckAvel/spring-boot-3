package com.eryckavel.spring_boot_3;

import com.eryckavel.spring_boot_3.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger log = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        log.info("Find All People!");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        log.info("Find a Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eryck");
        person.setLastName("Avelino");
        person.setAdress("Rua 27, 1206");
        person.setGender("Masculino");
        return person;
    }

    public Person create(Person person){
        log.info("Creating a Person!");
        return person;
    }

    public Person update(Person person){
        log.info("Updating a Person!");
        return person;
    }

    public void delete(String id){
        log.info("Deleting one Person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAdress("Some Adress in Brazil");
        person.setGender("Masculino");
        return person;
    }

}
