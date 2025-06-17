package com.eryckavel.spring_boot_3.service;

import com.eryckavel.spring_boot_3.dto.v1.PersonDTO;
import com.eryckavel.spring_boot_3.dto.v2.PersonDTOV2;
import com.eryckavel.spring_boot_3.exception.ResourceNotFoundException;
import static com.eryckavel.spring_boot_3.mapper.ObjectMapper.parseListObjects;
import static com.eryckavel.spring_boot_3.mapper.ObjectMapper.parseObject;

import com.eryckavel.spring_boot_3.mapper.custom.PersonMapper;
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
    @Autowired
    private PersonMapper converter;



    public List<PersonDTO> findAll(){
        log.info("Find All People!");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        log.info("Find a PersonDTO!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonDTO not found!"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        log.info("Creating a PersonDTO!");
        Person entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        log.info("Creating a PersonDTO!");
        Person entity = converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }


    public PersonDTO update(PersonDTO person){
        log.info("Updating a PersonDTO!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("PersonDTO not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        log.info("Deleting one PersonDTO!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonDTO not found!"));
        repository.delete(entity);
    }

}
