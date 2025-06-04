package com.eryckavel.spring_boot_3.service;

import com.eryckavel.spring_boot_3.exception.ResourceNotFoundException;
import com.eryckavel.spring_boot_3.model.Person;
import com.eryckavel.spring_boot_3.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger log = LoggerFactory.getLogger(PersonService.class.getName());
    @Autowired
    private PersonRepository repository;


    public List<Person> findAll(){
        log.info("Find All People!");
        return repository.findAll();
    }

    public Person findById(Long id){
        log.info("Find a Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public Person create(Person person){
        log.info("Creating a Person!");
        return repository.save(person);
    }

    public Person update(Person person){
        log.info("Updating a Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id){
        log.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        repository.delete(entity);
    }

}
